package com.ingeneotest.empresa_gestion_logistica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneotest.empresa_gestion_logistica.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    List<Cliente> findByEstadoIn(List<String> estados);
}