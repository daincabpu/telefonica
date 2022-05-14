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
@Table(name = "CLIENTE")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CLIENTE_SEQ")
    @SequenceGenerator(name="CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
    @Column(name = "CLIENTE_ID", updatable = false, nullable = false)
	private Integer clienteId;
	
    @Column(name = "NOMBRES")
	private String nombres;
    
    @Column(name = "APE_PATERNO")
	private String apePaterno;
    
    @Column(name = "APE_MATERNO")
	private String apeMaterno;
    
    @Column(name = "TIPO_DOCUMENTO")
	private Integer tipoDocumento;
    
    @Column(name = "NRO_DOCUMENTO")
	private String nroDocumento;
    
    @Column(name = "ESTADO")
	private String estado; 
    
    @Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;
    
}
