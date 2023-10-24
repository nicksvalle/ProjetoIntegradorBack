package com.projeto_integrador.entities;

public class Sala {
    
        private int id;
        private String nome;
        private int capacidade;
        private String descricao;
    
        public Sala(int id, String nome, int capacidade, String descricao) {
            this.id = id;
            this.nome = nome;
            this.capacidade = capacidade;
            this.descricao = descricao;
        }
    
        // Getters e Setters
    
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public int getCapacidade() {
            return capacidade;
        }
    
        public void setCapacidade(int capacidade) {
            this.capacidade = capacidade;
        }
    
        public String getDescricao() {
            return descricao;
        }
    
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    }
    