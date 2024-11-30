package com.felipecarvalho.mercado.repositories;

import com.felipecarvalho.mercado.entities.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionarios, String> {
    // Métodos de consulta personalizados, se necessário, podem ser adicionados aqui
}
