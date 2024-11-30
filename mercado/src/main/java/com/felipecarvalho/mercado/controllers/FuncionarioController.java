package com.felipecarvalho.mercado.controllers;

import com.felipecarvalho.mercado.entities.Funcionarios;
import com.felipecarvalho.mercado.servicos.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // Criar funcionário
    @PostMapping
    public ResponseEntity<Funcionarios> createFuncionario(@RequestBody Funcionarios funcionario) {
        Funcionarios savedFuncionario = funcionarioService.saveFuncionario(funcionario);
        return new ResponseEntity<>(savedFuncionario, HttpStatus.CREATED);
    }

    // Atualizar funcionário
    @PutMapping("/{cpf}")
    public ResponseEntity<Funcionarios> updateFuncionario(@PathVariable String cpf, @RequestBody Funcionarios funcionario) {
        Optional<Funcionarios> existingFuncionario = funcionarioService.getFuncionarioByCpf(cpf);

        if (existingFuncionario.isPresent()) {
            funcionario.setCpf(cpf);  // Garantir que o CPF não seja alterado
            Funcionarios updatedFuncionario = funcionarioService.saveFuncionario(funcionario);
            return new ResponseEntity<>(updatedFuncionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Funcionário não encontrado
        }
    }

    // Listar todos os funcionários
    @GetMapping
    public ResponseEntity<List<Funcionarios>> getAllFuncionarios() {
        List<Funcionarios> funcionarios = funcionarioService.getAllFuncionarios();
        if (funcionarios.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);  // Retorna uma lista vazia
        }
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    // Buscar funcionário por CPF
    @GetMapping("/{cpf}")
    public ResponseEntity<Funcionarios> getFuncionarioByCpf(@PathVariable String cpf) {
        Optional<Funcionarios> funcionario = funcionarioService.getFuncionarioByCpf(cpf);
        if (funcionario.isPresent()) {
            return new ResponseEntity<>(funcionario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deletar funcionário
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable String cpf) {
        funcionarioService.deleteFuncionario(cpf);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
