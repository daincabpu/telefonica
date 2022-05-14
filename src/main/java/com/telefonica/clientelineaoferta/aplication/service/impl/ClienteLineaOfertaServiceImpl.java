package com.telefonica.clientelineaoferta.aplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telefonica.clientelineaoferta.aplication.service.IClienteLineaOfertaService;
import com.telefonica.clientelineaoferta.domain.service.IDClienteLineaOfertaService;
import com.telefonica.clientelineaoferta.presentacion.api.entity.request.BusquedaFechasRequest;
import com.telefonica.clientelineaoferta.presentacion.api.entity.response.ClienteResponse;

@Service
public class ClienteLineaOfertaServiceImpl implements IClienteLineaOfertaService{

	@Autowired
	IDClienteLineaOfertaService cliLinOferService;
	
	@Override
	public ClienteResponse busquedaTipoNroDocumento(Integer tipoDocumento, String nroDocumento) {
		
		return null;
	}

	@Override
	public ClienteResponse busquedaPersonalizada(BusquedaFechasRequest requestBusqueda) {
		// TODO Auto-generated method stub
		return null;
	}

}
