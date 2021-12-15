package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class AnalisadorDeTransacoesFinanceiras {

    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final ConversorDeCSV conversorDeCSV = new ConversorDeCSV();

        final String nomeDoArquivo = "extrato.csv";
        final Path path = Paths.get(RESOURCES + nomeDoArquivo);
        final List<String> linhas = Files.readAllLines(path);

        final List<TransacaoBancaria> transacoesBancarias = conversorDeCSV.converteLinhaDoCSV(linhas);

        final ProcessadorDeDeclaracaoBancaria processadorDeDeclaracaoBancaria= new ProcessadorDeDeclaracaoBancaria(transacoesBancarias);
        geraRelatorio(processadorDeDeclaracaoBancaria);

    }

    private static void geraRelatorio(final ProcessadorDeDeclaracaoBancaria processadorDeDeclaracaoBancaria) {
        System.out.println("O total das transações é de: " + processadorDeDeclaracaoBancaria.calculaValorTotal());
        System.out.println("O total das transações de Janeiro é de: " + processadorDeDeclaracaoBancaria.calculaValorNoMes(Month.JANUARY));
        System.out.println("O total das transações de Fevereiro é de: " + processadorDeDeclaracaoBancaria.calculaValorNoMes(Month.FEBRUARY));
        System.out.println("O salário total recebido é: " + processadorDeDeclaracaoBancaria.calculaTotalParaCategoria("salario"));


    }


}
