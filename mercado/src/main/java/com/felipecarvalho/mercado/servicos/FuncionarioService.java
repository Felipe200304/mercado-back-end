package com.felipecarvalho.mercado.servicos;

import com.felipecarvalho.mercado.entities.Funcionarios;
import com.felipecarvalho.mercado.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Criar ou atualizar um funcionário
    public Funcionarios saveFuncionario(Funcionarios funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    // Listar todos os funcionários
    public List<Funcionarios> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    // Buscar um funcionário por CPF
    public Optional<Funcionarios> getFuncionarioByCpf(String cpf) {
        return funcionarioRepository.findById(cpf);
    }

    // Deletar um funcionário
    public void deleteFuncionario(String cpf) {
        funcionarioRepository.deleteById(cpf);
    }
}
