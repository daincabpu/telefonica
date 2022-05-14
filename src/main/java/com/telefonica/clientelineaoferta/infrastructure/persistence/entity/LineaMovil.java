package com.telefonica.clientelineaoferta.infrastructure.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LINEA_MOVIL")
public class LineaMovil implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "LINEA_MOVIL_SEQ")
    @SequenceGenerator(name="LINEA_MOVIL_SEQ", sequenceName = "LINEA_MOVIL_SEQ", allocationSize = 1)
    @Column(name = "LINEA_MOVIL_ID", updatable = false, nullable = false)
	private Integer lineaMovilId;
	
    @Column(name = "CLIENTE_ID", nullable = false)
	private Integer clienteId;
    
    @Column(name = "NRO_TELEFONO")
	private String nroTelefono;
	
    @Column(name = "ESTADO")
	private String estado;
	
    @Column(name = "TIPO")
	private String tipo;
	
    @Column(name = "NOMBRE_PLAN")
	private String nombrePlan;
	
}
