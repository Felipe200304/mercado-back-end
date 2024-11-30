package com.felipecarvalho.mercado.repositories;

import com.felipecarvalho.mercado.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {  // Altere para Long aqui

}

