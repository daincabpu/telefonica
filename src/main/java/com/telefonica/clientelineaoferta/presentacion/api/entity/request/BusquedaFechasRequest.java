package com.telefonica.clientelineaoferta.presentacion.api.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusquedaFechasRequest {
	private String fechaInicio;
	private String fechaFin;
	private Integer nroMinimoLineas;
	private Integer nroMinimoOfertasXLinea;
}
