package com.ingeneotest.empresa_gestion_logistica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneotest.empresa_gestion_logistica.models.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, String> {

}