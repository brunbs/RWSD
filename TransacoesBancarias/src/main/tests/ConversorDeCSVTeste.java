package main.tests;

import main.ConversorDeCSV;
import main.ConversorDeExtratoBancario;
import main.TransacaoBancaria;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class ConversorDeCSVTeste {

    private final ConversorDeExtratoBancario conversorDeExtratoBancario = new ConversorDeCSV();

    @Test
    public void DeveriaConverterUmaLinhaCorretamente() throws Exception {
        final String linha = "30-01-2021,-100,ifood";
        final TransacaoBancaria resultado = conversorDeExtratoBancario.converteDe(linha);

        final TransacaoBancaria esperado = new TransacaoBancaria(LocalDate.of(2021, Month.JANUARY, 30), -100, "ifood");
        final double tolerancia = 0.0d;

        Assert.assertEquals(esperado.getData(), resultado.getData());
        Assert.assertEquals(esperado.getValor(), resultado.getValor(), tolerancia);
        Assert.assertEquals(esperado.getDescricao(), resultado.getDescricao());
    }


}
