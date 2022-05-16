package com.telefonica.clientelineaoferta.domain.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.clientelineaoferta.domain.entity.ClienteBusquedaDTO;
import com.telefonica.clientelineaoferta.domain.service.IDClienteLineaOfertaService;
import com.telefonica.clientelineaoferta.infrastructure.persistence.model.ClienteBusquedaModel;
import com.telefonica.clientelineaoferta.infrastructure.persistence.repository.IClienteProcedureRepository;
import com.telefonica.clientelineaoferta.infrastructure.persistence.repository.IClienteRepository;

@Service
public class DClienteLineaOfertaServiceImpl implements IDClienteLineaOfertaService{

	@Autowired
	IClienteProcedureRepository clienteProcedureRepository;

	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<ClienteBusquedaDTO> busquedaTipoNroDocumento(Integer tipoDocumento, String nroDocumento) {
		List<ClienteBusquedaModel> resp = clienteProcedureRepository.buscarClienteByTipoNroDoc(tipoDocumento, nroDocumento);
		
		return resp.stream()
				.map(item -> modelMapper.map(item, ClienteBusquedaDTO.class))
				.collect(Collectors.toList());
	}
	
}
