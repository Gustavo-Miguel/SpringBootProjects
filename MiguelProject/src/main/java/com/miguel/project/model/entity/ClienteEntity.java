package com.miguel.project.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name="clientes")
public class ClienteEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;

    @Column(name = "nome")
    public String nome;

    @Column(name = "idade")
    public Integer idade;

    public Integer getId() {
        return id;
    }
}
