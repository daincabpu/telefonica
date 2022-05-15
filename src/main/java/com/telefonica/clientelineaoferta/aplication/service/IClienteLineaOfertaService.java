package com.telefonica.clientelineaoferta.aplication.service;

import java.util.List;

import com.telefonica.clientelineaoferta.presentacion.api.entity.request.BusquedaFechasRequest;
import com.telefonica.clientelineaoferta.presentacion.api.entity.response.ClienteResponse;

public interface IClienteLineaOfertaService {

	List<ClienteResponse> busquedaTipoNroDocumento(Integer tipoDocumento, String nroDocumento);

	List<ClienteResponse> busquedaPersonalizada(BusquedaFechasRequest requestBusqueda);

}
