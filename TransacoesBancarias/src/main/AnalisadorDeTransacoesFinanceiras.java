package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class AnalisadorDeTransacoesFinanceiras {

    public static final String RESOURCES = "TransacoesBancarias/src/main/resources/";
    //final String nomeDoArquivo = "extrato.csv";

    public static void analisar(final String nomeDoArquivo, final ConversorDeExtratoBancario conversorDeExtratoBancario) throws IOException {
        final Path path = Paths.get(RESOURCES + nomeDoArquivo);
        final List<String> linhas = Files.readAllLines(path);
        final List<TransacaoBancaria> transacoesBancarias = conversorDeExtratoBancario.converteLinhasDe(linhas);
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
