package com.telefonica.clientelineaoferta.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telefonica.clientelineaoferta.infrastructure.persistence.entity.LineaMovil;

public interface ILineaMovilRepository extends JpaRepository<LineaMovil, Integer>{

}
