package com.telefonica.clientelineaoferta.aplication.service;

import com.telefonica.clientelineaoferta.presentacion.api.entity.request.BusquedaFechasRequest;
import com.telefonica.clientelineaoferta.presentacion.api.entity.response.ClienteResponse;

public interface IClienteLineaOfertaService {

	ClienteResponse busquedaTipoNroDocumento(Integer tipoDocumento, String nroDocumento);

	ClienteResponse busquedaPersonalizada(BusquedaFechasRequest requestBusqueda);

}
