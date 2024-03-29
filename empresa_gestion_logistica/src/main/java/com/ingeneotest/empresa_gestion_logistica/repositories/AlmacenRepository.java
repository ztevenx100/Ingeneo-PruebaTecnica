package com.ingeneotest.empresa_gestion_logistica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneotest.empresa_gestion_logistica.models.Almacen;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, String> {
    List<Almacen> findByEstadoIn(List<String> estados);
}