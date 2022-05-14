package com.telefonica.clientelineaoferta.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telefonica.clientelineaoferta.infrastructure.persistence.entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
