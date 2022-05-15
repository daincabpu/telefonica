package com.telefonica.clientelineaoferta.infrastructure.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Oferta {
	private String codigoOferta;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private String estado;
}
