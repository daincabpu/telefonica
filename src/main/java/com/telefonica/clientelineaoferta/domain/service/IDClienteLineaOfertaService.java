package com.telefonica.clientelineaoferta.domain.service;

import java.util.List;

import com.telefonica.clientelineaoferta.domain.entity.ClienteBusquedaDTO;

public interface IDClienteLineaOfertaService {

	List<ClienteBusquedaDTO> busquedaTipoNroDocumento(Integer tipoDocumento, String nroDocumento);
}
