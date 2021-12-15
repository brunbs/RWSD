package main;

import java.time.LocalDate;
import java.util.Objects;

public class TransacaoBancaria {

    private final LocalDate data;
    private final double valor;
    private final String descricao;

    public TransacaoBancaria(LocalDate data, double quantidade, String descricao) {
        this.data = data;
        this.valor = quantidade;
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "TransacaoBancaria{" +
                "data=" + data +
                ", quantidade=" + valor +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoBancaria that = (TransacaoBancaria) o;
        return Double.compare(that.valor, valor) == 0 && Objects.equals(data, that.data) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, valor, descricao);
    }



}
