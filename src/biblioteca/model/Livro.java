package biblioteca.model;

import java.sql.Date;

public class Livro {

    private int id;
    private String titulo;
    private Date dataPublicacao;
    private int autorId;
    private int quantidadeEstoque;
    private String status;

    public Livro() {
    }

    public Livro(int id, String titulo, Date dataPublicacao, int autorId, int quantidadeEstoque, String status) {
        this.id = id;
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.autorId = autorId;
        this.quantidadeEstoque = quantidadeEstoque;
        this.status = status;
    }
    
    public Livro(String titulo, Date dataPublicacao, int autorId, int quantidadeEstoque, String status) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.autorId = autorId;
        this.quantidadeEstoque = quantidadeEstoque;
        this.status = status;
    }

    public Livro(String titulo, Date dataPublicacao, int autorId) {
    this.titulo = titulo;
    this.dataPublicacao = dataPublicacao;
    this.autorId = autorId;
}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
