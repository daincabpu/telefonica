package com.telefonica.clientelineaoferta.infrastructure.persistence.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

import com.telefonica.clientelineaoferta.core.utils.IDateTime;
import com.telefonica.clientelineaoferta.infrastructure.persistence.model.ClienteBusqueda;
import com.telefonica.clientelineaoferta.infrastructure.persistence.repository.IClienteProcedureRepository;

@Service
public class ClienteProcedureRepository implements IClienteProcedureRepository {

final Logger logger = LoggerFactory.getLogger(this.getClass());
    
	@PersistenceContext
	private EntityManager em;  
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	IDateTime datetime;
	
	@Override
	public List<ClienteBusqueda> buscarClienteByTipoNroDoc(Integer tipoDocumento, String nroDocumento) {
		// TODO Auto-generated method stub
		
		List<ClienteBusqueda> outputList = jdbcTemplate.query("select * from public.buscar_x_tip_nrodoc(?::SMALLINT,?)"
                ,new Object[] {tipoDocumento, nroDocumento}
                ,new RowMapper<ClienteBusqueda>() {
                    @Nullable
                    @Override
                    public ClienteBusqueda mapRow(ResultSet resultSet, int i) throws SQLException {
                    	
                    	return ClienteBusqueda
                    				.builder()
				                    	.clienteId(resultSet.getInt("cliente_id"))
				                    	.nombres(resultSet.getString("nombres"))
				                    	.apePaterno(resultSet.getString("ape_paterno"))
				                    	.apeMaterno(resultSet.getString("ape_materno"))
				                    	.tipoDocumento(resultSet.getInt("tipo_documento"))
				                    	.nroDocumento(resultSet.getString("nro_documento"))
				                    	.fechaNacimiento(datetime.format(resultSet.getDate("fecha_nacimiento"), "dd/MM/yyyy"))
				                    	.estado(resultSet.getString("estado"))
			                    	.build();
                    }
                });
        
		return outputList;
	}

}
