package com.telefonica.clientelineaoferta.presentacion.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.clientelineaoferta.aplication.service.IClienteLineaOfertaService;
import com.telefonica.clientelineaoferta.infrastructure.persistence.entity.Cliente;
import com.telefonica.clientelineaoferta.infrastructure.persistence.model.ClienteBusqueda;
import com.telefonica.clientelineaoferta.infrastructure.persistence.repository.IClienteProcedureRepository;
import com.telefonica.clientelineaoferta.infrastructure.persistence.repository.IClienteRepository;
import com.telefonica.clientelineaoferta.presentacion.api.entity.request.BusquedaFechasRequest;
import com.telefonica.clientelineaoferta.presentacion.api.entity.response.ClienteResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Servicios para busqueda de los clientes sus lineas y ofertas" })
@RequestMapping("/clientelineaoferta")
public class ClienteController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IClienteLineaOfertaService clienteLineaOfertaService;
	
	@Autowired
	IClienteProcedureRepository clienteProcedureRepository;
	
	@ApiOperation(value = "Busqueda tipo y numero de documento de cliente", response = String.class)
    @GetMapping(value="/busqueda/tipoDocumento/{tipoDocumento}")
    public ResponseEntity<List<ClienteResponse>> busquedaTipNroDc(@PathVariable Integer tipoDocumento,@RequestParam(required = false) String nroDocumento) {
   	    logger.info("Inicio busquedaTipNroDc");
   	    
   	    return ResponseEntity.status(HttpStatus.OK).body(clienteLineaOfertaService.busquedaTipoNroDocumento(tipoDocumento, nroDocumento));
    }
	
	@ApiOperation(value = "Busqueda personalizada", response = String.class)
    @PostMapping(value="/busqueda/rangoFechas")
    public ResponseEntity<List<ClienteResponse>> busquedaPersonalizada(@RequestBody BusquedaFechasRequest requestBusqueda) {
   	    logger.info("Inicio busquedaPersonalizada");
   	    return ResponseEntity.status(HttpStatus.OK).body(clienteLineaOfertaService.busquedaPersonalizada(requestBusqueda));
    }
}
