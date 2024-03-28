package com.ingeneotest.empresa_gestion_logistica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneotest.empresa_gestion_logistica.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
    List<Producto> findByEstadoIn(List<String> estados);
}