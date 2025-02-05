package br.com.livraria.Class;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private String editora;

    public Livro(){

    }

    public Livro(String titulo, String autor, String isbn, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.editora = editora;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String getIsbn() {
        return isbn;
    }

    public String getEditora() {
        return editora;
    }

}
