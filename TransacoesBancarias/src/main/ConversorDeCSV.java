package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConversorDeCSV {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    // Pega uma linha do CSV e transforma em objeto TransacaoBancaria
    private TransacaoBancaria converteDeCSV(final String linha) {
        final String[] colunas = linha.split(",");

        final LocalDate data = LocalDate.parse(colunas[0], DATE_PATTERN);
        final double valor = Double.parseDouble(colunas[1]);
        final String descricao = colunas[2];

        return new TransacaoBancaria(data, valor, descricao);
    }


    // Recebe uma lista de linhas Devolve uma lista de objetos TransacaoBancaria, para cada linha chama a função que
    // converte a linha em objeto
    public List<TransacaoBancaria> converteLinhaDoCSV(final List<String> linhas) {
        final List<TransacaoBancaria> transacoesBancarias = new ArrayList<>();
        for (final String linha : linhas) {
            transacoesBancarias.add(converteDeCSV(linha));
        }

        return transacoesBancarias;

    }



}
