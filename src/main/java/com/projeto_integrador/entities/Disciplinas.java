package com.projeto_integrador.entities;

public class Disciplinas {
   

    public class Diciplinas {
        private int id;
        private String nome;
        private String descricao;
        private int duracaoSemestres;
    
        public Diciplinas(int id, String nome, String descricao, int duracaoSemestres) {
            this.id = id;
            this.nome = nome;
            this.descricao = descricao;
            this.duracaoSemestres = duracaoSemestres;
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
    
        public String getDescricao() {
            return descricao;
        }
    
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
    
        public int getDuracaoSemestres() {
            return duracaoSemestres;
        }
    
        public void setDuracaoSemestres(int duracaoSemestres) {
            this.duracaoSemestres = duracaoSemestres;
        }
    }
    


}
