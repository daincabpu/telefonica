package com.telefonica.clientelineaoferta.infrastructure.persistence.repository;

import java.util.List;
import com.telefonica.clientelineaoferta.infrastructure.persistence.model.ClienteBusqueda;

public interface IClienteProcedureRepository {
	List<ClienteBusqueda> buscarClienteByTipoNroDoc(Integer tipoDocumento, String nroDocumento);
}
