package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping ("/clientes")
public class ClienteController {

//    // Injeta um EntityManager na varíavel de instancia manager
//    @PersistenceContext
//    // É uma interface do jakarta.persistence que é usada para fazer as operações com as entidades,
//    // que são refletidas depois no banco de dados, inserçes, excões, atualizaçõlusões e etc.
//    private EntityManager manager;

//    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar(){
//        return clienteRepository.findByNomeContaining("a");
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
        return clienteRepository.findById(clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

//        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//            if (cliente.isPresent()){
//                return ResponseEntity.ok(cliente.get());
//            }
//            return ResponseEntity.notFound().build();
//        return clienteRepository.findById(clienteId);
    }
}
