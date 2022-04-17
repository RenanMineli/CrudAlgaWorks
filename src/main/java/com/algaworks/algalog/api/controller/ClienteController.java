package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping ("/clientes")
public class ClienteController {
    /*
     Injeta um EntityManager na varíavel de instancia manager
     */
//    @PersistenceContext

    /*
    É uma interface do jakarta.persistence que é usada para fazer as operações com as entidades,
    que são refletidas depois no banco de dados, inserçes, excões, atualizaçõlusões e etc.
     */
//    private EntityManager manager;

//    @Autowired
    private ClienteRepository clienteRepository;

    //@GetMapping
    @GetMapping
    public List<Cliente> listar(){
//        return clienteRepository.findByNomeContaining("a");
        return clienteRepository.findAll();
    }

    /*
    @GetMapping significa que o tipo de requisição é para fazer uma consulta no banco de dados
    @PathVariable vincula o parametro do método "Long clienteId" a variavel "{clienteId}" do caminho
     */
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
        return clienteRepository.findById(clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    /*
    Outra maneira de fazer a requisição só que mais simples
    O Optional significa que ele pode retornar com algo ou vazio
     */
//    Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//        if (cliente.isPresent()){
//          return ResponseEntity.ok(cliente.get());
//        }
//        return ResponseEntity.notFound().build();
//    return clienteRepository.findById(clienteId);
    }

    /*
    @PostMapping significa que o tipo de requisição criara algo, por exemplo salvar algo no banco de dados
    @ResponseStatus muda o status na resposta da requisição, por exemplo ao inves de "200 ok" mostra "201 Created"
    @RequestBody vincula o parametro do método no caso "Cliente cliente",
    ao corpo da requisição (o que vier na requisição)
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    /*
    @PutMapping significa que o tipo da requisição é para editar alguém dentro do banco de dados
    @PathVariable vincula o parametro "Long clienteId" do método a variavel "{clienteId}" do caminho
    @RequestBody vincula o parametro do método no caso "Cliente cliente",
    ao corpo da requisição (o que vier na requisição)
     */
    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente cliente){
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    /*
    @DeleteMapping significa que eu vou deletar alguma coisa que esteja no banco de dados
    ResponseEntity<Void> como esta sendo excluido um cliente, o corpo da resposta não precisa existir
    @PathVariable vincula o parametro "Long clienteId" do método a variavel "{clienteId}" do caminho
    ResponseEntity.noContent() utiliza-se quando não esta retornando um corpo na resposta
     */
    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> deletar(@PathVariable Long clienteId){
        if(!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }
}

