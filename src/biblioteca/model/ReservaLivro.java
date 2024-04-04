package biblioteca.model;

import java.util.Date;

public class ReservaLivro {
    private int id;
    private int livroId;
    private int usuarioId;
    private Date dataReserva;
    private Date dataDevolucao;

    public ReservaLivro() {
    }

    public ReservaLivro(int id, int livroId, int usuarioId, Date dataReserva, Date dataDevolucao) {
        this.id = id;
        this.livroId = livroId;
        this.usuarioId = usuarioId;
        this.dataReserva = dataReserva;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}