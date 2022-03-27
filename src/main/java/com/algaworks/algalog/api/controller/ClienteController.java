package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController //
public class ClienteController {

//    // Injeta um EntityManager na varíavel de instancia manager
//    @PersistenceContext
//    // É uma interface do jakarta.persistence que é usada para fazer as operações com as entidades,
//    // que são refletidas depois no banco de dados, inserçes, excões, atualizaçõlusões e etc.
//    private EntityManager manager;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
//        return clienteRepository.findByNomeContaining("a");
        return clienteRepository.findAll();
    }
}
