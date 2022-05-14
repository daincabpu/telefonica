package com.telefonica.clientelineaoferta.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telefonica.clientelineaoferta.infrastructure.persistence.entity.Oferta;

public interface IOfertaRepository extends JpaRepository<Oferta, Integer> {

}
