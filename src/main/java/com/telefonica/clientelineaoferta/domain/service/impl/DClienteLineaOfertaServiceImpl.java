package com.telefonica.clientelineaoferta.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telefonica.clientelineaoferta.domain.service.IDClienteLineaOfertaService;
import com.telefonica.clientelineaoferta.infrastructure.persistence.repository.IClienteRepository;

@Service
public class DClienteLineaOfertaServiceImpl implements IDClienteLineaOfertaService{

	@Autowired
	IClienteRepository clienteRepository;
	
}
