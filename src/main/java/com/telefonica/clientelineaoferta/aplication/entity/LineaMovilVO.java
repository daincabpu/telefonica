package com.telefonica.clientelineaoferta.aplication.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineaMovilVO {
	private String nroTelefono;
	private String estado;
	private String tipo;
	private String nombrePlan;
	private List<OfertaVO> ofertas;
}
