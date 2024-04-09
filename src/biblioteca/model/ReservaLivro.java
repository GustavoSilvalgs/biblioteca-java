package biblioteca.model;

import java.time.LocalDate;

public class ReservaLivro {

    private int id;
    private int livroId;
    private int usuarioId;
    private LocalDate dataReserva;
    private LocalDate dataDevolucao;
    private boolean preReserva;

    public ReservaLivro() {
    }

    public ReservaLivro(int id, int livroId, int usuarioId, LocalDate dataReserva) {
        this.id = id;
        this.livroId = livroId;
        this.usuarioId = usuarioId;
        this.dataReserva = dataReserva;
    }
   

    public ReservaLivro(int id, int livroId, int usuarioId, LocalDate dataReserva, LocalDate dataDevolucao) {
        this.id = id;
        this.livroId = livroId;
        this.usuarioId = usuarioId;
        this.dataReserva = dataReserva;
        this.dataDevolucao = dataDevolucao;
    }

    public ReservaLivro(int id, int livroId, int usuarioId, LocalDate dataReserva, LocalDate dataDevolucao, boolean preReserva) {
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

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isPreReserva() {
        return preReserva;
    }

    public void setPreReserva(boolean preReserva) {
        this.preReserva = preReserva;
    }
}
