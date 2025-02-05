package br.com.livraria.Class;

public class Livro {
    private String titulo;
    private String autor;
    private String id;
    private String editora;

    public Livro(){

    }

    public Livro(String titulo, String autor, String id, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.editora = editora;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getId() {
        return id;
    }

    public String getEditora() {
        return editora;
    }

}
