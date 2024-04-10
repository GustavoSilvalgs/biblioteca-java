package biblioteca.model;

import java.util.Date;

public class ReservaLivro {

    private int id;
    private int livroId;
    private int usuarioId;
    private Date dataReserva;
    private Date dataDevolucao;
    private boolean preReserva;

    public ReservaLivro() {
    }

    public ReservaLivro(int id, int livroId, int usuarioId, Date dataReserva) {
        this.id = id;
        this.livroId = livroId;
        this.usuarioId = usuarioId;
        this.dataReserva = dataReserva;
    }
   

    public ReservaLivro(int id, int livroId, int usuarioId, Date dataReserva, Date dataDevolucao) {
        this.id = id;
        this.livroId = livroId;
        this.usuarioId = usuarioId;
        this.dataReserva = dataReserva;
        this.dataDevolucao = dataDevolucao;
    }

    public ReservaLivro(int id, int livroId, int usuarioId, Date dataReserva, Date dataDevolucao, boolean preReserva) {
        this.id = id;
        this.livroId = livroId;
        this.usuarioId = usuarioId;
        this.dataReserva = dataReserva;
        this.dataDevolucao = dataDevolucao;
        this.preReserva = preReserva;
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

    public boolean isPreReserva() {
        return preReserva;
    }

    public void setPreReserva(boolean preReserva) {
        this.preReserva = preReserva;
    }
}
