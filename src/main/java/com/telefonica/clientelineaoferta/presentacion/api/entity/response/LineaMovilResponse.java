package com.telefonica.clientelineaoferta.presentacion.api.entity.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineaMovilResponse {
	private String nroTelefono;
	private String estado;
	private String tipo;
	private String nombrePlan;
	private List<OfertaResponse> ofertas;
}
