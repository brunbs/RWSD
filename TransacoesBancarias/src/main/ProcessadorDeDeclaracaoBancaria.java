package main;

import java.time.Month;
import java.util.List;

public class ProcessadorDeDeclaracaoBancaria {

    private final List<TransacaoBancaria> transacoesBancarias;

    public ProcessadorDeDeclaracaoBancaria(List<TransacaoBancaria> transacoesBancarias) {
        this.transacoesBancarias = transacoesBancarias;
    }

    public double calculaValorNoMes(final Month mes) {
        double total = 0;
        for (final TransacaoBancaria transacaoBancaria : transacoesBancarias) {
            if(transacaoBancaria.getData().getMonth() == mes) {
                total += transacaoBancaria.getValor();
            }
        }
        return total;

    }

    public double calculaValorTotal() {
        double total = 0;
        for(final TransacaoBancaria transacaoBancaria : transacoesBancarias) {
            total += transacaoBancaria.getValor();
        }
        return total;
    }

    public double calculaTotalParaCategoria(final String categoria) {
        double total = 0;
        for (final TransacaoBancaria transacaoBancaria : transacoesBancarias) {
            if(transacaoBancaria.getDescricao().equals(categoria)) {
                total += transacaoBancaria.getValor();
            }
        }
        return total;
    }

}
