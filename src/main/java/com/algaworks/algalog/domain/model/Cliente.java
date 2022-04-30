package com.algaworks.algalog.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    @NotBlank impede que o valor do campo seja nulo ou vazio
    @Size define o tamanho máximo de caracteres que o campo pode ter,
          importante colocar do mesmo tamanho da coluna do banco de dados
     */
    @NotBlank
    @Size(max = 60)
    private String nome;

    /*
    @NotBlank impede que o valor do campo seja nulo ou vazio
    @Email valida se a sintaxe do campo email esta correta
    @Size define o tamanho máximo de caracteres que o campo pode ter,
          importante colocar do mesmo tamanho da coluna do banco de dados
     */
    @NotBlank
    @Email
    @Size(max = 60)
    private String email;

    /*
    @NotBlank impede que o valor do campo seja nulo ou vazio
    @Size define o tamanho máximo de caracteres que o campo pode ter,
          importante colocar do mesmo tamanho da coluna do banco de dados
    @Column especifíca o nome da coluna lá no bando de dados
     */
    @NotBlank
    @Size(max = 20)
    @Column(name = "fone")
    private String telefone;

}
