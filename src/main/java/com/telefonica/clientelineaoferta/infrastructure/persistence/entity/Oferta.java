package com.telefonica.clientelineaoferta.infrastructure.persistence.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "OFERTA")
public class Oferta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "OFERTA_SEQ")
    @SequenceGenerator(name="OFERTA_SEQ", sequenceName = "OFERTA_SEQ", allocationSize = 1)
	@Column(name = "OFERTA_ID", nullable = false)
	private Integer ofertaId;
	
	@Column(name = "LINEA_MOVIL_ID", nullable = false)
	private Integer lineaMovilId;
	
    @Column(name = "CLIENTE_ID", nullable = false)
	private Integer clienteId;
	
	@Column(name = "CODIGO_OFERTA")
	private String codigoOferta;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;
	
	@Column(name = "FECHA_FIN")
	private Date fechaFin;
	
	@Column(name = "ESTADO")
	private String estado;
	
}
