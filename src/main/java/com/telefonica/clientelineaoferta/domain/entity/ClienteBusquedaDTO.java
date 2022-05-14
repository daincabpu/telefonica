package com.telefonica.clientelineaoferta.domain.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteBusquedaDTO {
	
	private Integer clienteId;
	private String nombres;
	private String apePaterno;
	private String apeMaterno;
	private Integer tipoDocumento;
	private String nroDocumento;
	private String estado;
	private String fechaNacimiento;
	private List<LineaMovilDTO> lineasMoviles;
}
