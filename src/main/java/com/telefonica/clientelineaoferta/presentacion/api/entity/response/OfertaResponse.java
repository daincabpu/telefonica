package com.telefonica.clientelineaoferta.presentacion.api.entity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfertaResponse {
	private String codigoOferta;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private String estado;
}
