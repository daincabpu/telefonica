package com.telefonica.clientelineaoferta.aplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telefonica.clientelineaoferta.aplication.service.IClienteLineaOfertaService;
import com.telefonica.clientelineaoferta.domain.entity.ClienteBusquedaDTO;
import com.telefonica.clientelineaoferta.domain.service.IDClienteLineaOfertaService;
import com.telefonica.clientelineaoferta.presentacion.api.entity.request.BusquedaFechasRequest;
import com.telefonica.clientelineaoferta.presentacion.api.entity.response.ClienteResponse;


@Service
public class ClienteLineaOfertaServiceImpl implements IClienteLineaOfertaService{

	@Autowired
	IDClienteLineaOfertaService cliLinOferService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<ClienteResponse> busquedaTipoNroDocumento(Integer tipoDocumento, String nroDocumento) {
		
		List<ClienteBusquedaDTO> resp = cliLinOferService.busquedaTipoNroDocumento(tipoDocumento, nroDocumento);
		
		return resp.stream()
				.map(param -> modelMapper.map(param, ClienteResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ClienteResponse> busquedaPersonalizada(BusquedaFechasRequest requestBusqueda) {
		// TODO Auto-generated method stub
		return null;
	}

}
