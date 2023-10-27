package com.projeto_integrador.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="TBl_Disciplinas")
public class Disciplinas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1024, nullable = false, name = "Disciplina_nome")
    private String nome;

    @Column(length = 1024, nullable = false, name = "Disciplina_descricao")
    private String descricao;

    @Column(length = 1024, nullable = false, name = "Diciplina_duracaoSemestre")
    private String duracaoSemestres;

    
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
    
        public String getDescricao() {
            return descricao;
        }
    
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    
        public String getDuracaoSemestres() {
            return duracaoSemestres;
        }
    
        public void setDuracaoSemestres(String duracaoSemestres) {
            this.duracaoSemestres = duracaoSemestres;
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
            Disciplinas other = (Disciplinas) obj;
            if (id != other.id)
                return false;
            return true;
        }
        
    }
    
    



