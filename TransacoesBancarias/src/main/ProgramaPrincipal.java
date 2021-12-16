package main;

import java.io.IOException;

public class ProgramaPrincipal {

    public static void main(String[] args) throws IOException {

        final AnalisadorDeTransacoesFinanceiras analisadorDeTransacoesFinanceiras = new AnalisadorDeTransacoesFinanceiras();
        final ConversorDeExtratoBancario conversorDeExtratoBancario = new ConversorDeCSV();

        analisadorDeTransacoesFinanceiras.analisar("extrato.csv", conversorDeExtratoBancario);

    }


}
