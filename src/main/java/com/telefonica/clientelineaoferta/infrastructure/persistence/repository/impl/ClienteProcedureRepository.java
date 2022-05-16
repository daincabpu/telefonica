package com.telefonica.clientelineaoferta.infrastructure.persistence.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.mapping.Embedded.Nullable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.clientelineaoferta.core.utils.IDateTime;
import com.telefonica.clientelineaoferta.infrastructure.persistence.model.ClienteBusquedaModel;
import com.telefonica.clientelineaoferta.infrastructure.persistence.model.LineaMovilModel;
import com.telefonica.clientelineaoferta.infrastructure.persistence.model.OfertaModel;
import com.telefonica.clientelineaoferta.infrastructure.persistence.repository.IClienteProcedureRepository;

@Service
public class ClienteProcedureRepository implements IClienteProcedureRepository {

final Logger logger = LoggerFactory.getLogger(this.getClass());
    
	@PersistenceContext
	private EntityManager em;  
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	@Autowired
//	ObjectMapper objectMapper;
	
	@Autowired
	IDateTime datetime;
	
	@Override
	public List<ClienteBusquedaModel> buscarClienteByTipoNroDoc(Integer tipoDocumento, String nroDocumento) {
		// TODO Auto-generated method stub
		
		List<ClienteBusquedaModel> outputList = jdbcTemplate.query("select * from public.buscar_x_tip_nrodoc(?::SMALLINT,?)"
                ,new Object[] {tipoDocumento, nroDocumento}
                ,new RowMapper<ClienteBusquedaModel>() {
                    @Nullable
                    @Override
                    public ClienteBusquedaModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    	ObjectMapper objectMapper = new ObjectMapper();
                    	List<LineaMovilModel> lineasMovil = null;
                    	try {
                    		if(resultSet.getString("lineas_moviles") == null)
                    			return null;
                    		
                    		String lineasMovilesJsStr = resultSet.getString("lineas_moviles").replaceAll("\"\"", "\"");
                    		
                    		List<Map<String, Object>> lineasMovilesJs = objectMapper.readValue(lineasMovilesJsStr,
                    			    new TypeReference<List<Map<String, Object>>>(){});
                    			if(lineasMovilesJs != null)
                    			{
	                    			lineasMovil = lineasMovilesJs.stream().map(item -> {
	                    			List<OfertaModel> ofertas = null;
	                    			if(item.get("ofertas") != null)
	                    			{
	                    				List<Map<String, Object>> ofertasJson = (ArrayList)item.get("ofertas");
	                    				
										ofertas =  ofertasJson.stream().map(ofe ->{
											ofe.get("fecha_inicio");
											return OfertaModel.builder()
													.codigoOferta(ofe.get("codigo_oferta").toString())
													.descripcion(ofe.get("descripcion").toString())
													.estado(ofe.get("estado").toString())
													.fechaInicio(datetime.changeFormat(ofe.get("fecha_inicio").toString(), "yyyy-MM-dd", "dd/MM/yyyy") )
													.fechaFin(datetime.changeFormat(ofe.get("fecha_fin").toString(), "yyyy-MM-dd", "dd/MM/yyyy"))
													.build();
										}).collect(Collectors.toList());
										
	                    			}
									return LineaMovilModel.builder()
											.nombrePlan(item.get("nombre_plan").toString())
											.estado(item.get("estado").toString())
											.nroTelefono(item.get("nro_telefono").toString())
											.tipo(item.get("tipo").toString())
											.ofertas(ofertas)
											.build();
								}).collect(Collectors.toList());
                			}
						} catch (JsonMappingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JsonProcessingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    	
                    	return ClienteBusquedaModel
                    				.builder()
				                    	.clienteId(resultSet.getInt("cliente_id"))
				                    	.nombres(resultSet.getString("nombres"))
				                    	.apePaterno(resultSet.getString("ape_paterno"))
				                    	.apeMaterno(resultSet.getString("ape_materno"))
				                    	.tipoDocumento(resultSet.getInt("tipo_documento"))
				                    	.nroDocumento(resultSet.getString("nro_documento"))
				                    	.fechaNacimiento(datetime.format(resultSet.getDate("fecha_nacimiento"), "dd/MM/yyyy"))
				                    	.estado(resultSet.getString("estado"))
				                    	.lineasMoviles(lineasMovil)
			                    	.build();
                    }
                });
        
		return outputList;
	}

}
