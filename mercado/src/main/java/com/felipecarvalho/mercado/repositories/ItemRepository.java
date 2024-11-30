package com.felipecarvalho.mercado.repositories;

import com.felipecarvalho.mercado.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByCodigo(String codigo); // Apenas o método para buscar pelo código
}
