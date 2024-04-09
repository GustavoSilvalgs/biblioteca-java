package biblioteca.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Multa {
    private int id;
    private int reservaId;
    private BigDecimal valor;
    private Timestamp dataAplicacao;

    public Multa() {
    }

    public Multa(int id, int reservaId, BigDecimal valor, Timestamp dataAplicacao) {
        this.id = id;
        this.reservaId = reservaId;
        this.valor = valor;
        this.dataAplicacao = dataAplicacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Timestamp getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(Timestamp dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
}