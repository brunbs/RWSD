package main;

import java.util.List;

public interface ConversorDeExtratoBancario {

    TransacaoBancaria converteDe(String linha);
    List<TransacaoBancaria> converteLinhasDe(List<String> linhas);

}
