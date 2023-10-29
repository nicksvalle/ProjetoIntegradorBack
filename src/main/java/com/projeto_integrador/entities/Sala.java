package com.projeto_integrador.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="TBl_Sala")
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1024, nullable = false, name = "Sala_nome")
    private String nome;

    @Column(length = 1024, nullable = false, name = "Sala_capacidade")
    private String capacidade ;

    @Column(length = 1024, nullable = false, name = "Sala_descricao")
    private String descricao;

        // Getters e Setters
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public String getCapacidade() {
            return capacidade;
        }
    
        public void setCapacidade(String capacidade) {
            this.capacidade = capacidade;
        }

        public String getDescricao() {
            return descricao;
        }
    
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (id ^ (id >>> 32));
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Sala other = (Sala) obj;
            if (id != other.id)
                return false;
            return true;
        }
        
    }
    
    

