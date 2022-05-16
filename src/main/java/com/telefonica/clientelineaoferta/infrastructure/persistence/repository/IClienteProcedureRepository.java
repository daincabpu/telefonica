package com.telefonica.clientelineaoferta.infrastructure.persistence.repository;

import java.util.List;
import com.telefonica.clientelineaoferta.infrastructure.persistence.model.ClienteBusquedaModel;

public interface IClienteProcedureRepository {
	List<ClienteBusquedaModel> buscarClienteByTipoNroDoc(Integer tipoDocumento, String nroDocumento);
}
