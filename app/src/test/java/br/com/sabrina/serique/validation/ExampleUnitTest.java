package br.com.sabrina.serique.validation;

import org.junit.Test;

import br.com.sabrina.serique.validation.util.ValidarCPF;
import br.com.sabrina.serique.validation.util.ValidarData;
import br.com.sabrina.serique.validation.util.ValidarSenha;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void cpfErradoMenor11(){
        assertEquals(false, ValidarCPF.validar("123.456.78"));
    }

    @Test
    public void cpfErradoSeq(){
        assertEquals(false, ValidarCPF.validar("111.111.111-11"));
    }

    @Test
    public void cpfErradoVerificacao(){
        assertEquals(false, ValidarCPF.validar("140.385.785-54"));
    }

    @Test
    public void cpfCorreto(){
        assertEquals(true, ValidarCPF.validar("537.186.600-08"));
    }

    @Test
    public void dataErradaMenor18(){
        assertEquals(false, ValidarData.validar("10/05/2019"));
    }

    @Test
    public void dataErradaMenor18Mes(){
        assertEquals(false, ValidarData.validar("10/12/2001"));
    }

    @Test
    public void dataCerta(){
        assertEquals(true, ValidarData.validar("10/08/1990"));
    }

    @Test
    public void senhaErradaSeq(){
        assertEquals(false, ValidarSenha.validar("123456","537.186.600-08","10/08/1990"));
    }

    @Test
    public void senhaErradaCPF(){
        assertEquals(false, ValidarSenha.validar("537186","537.186.600-08","10/08/1990"));
    }

    @Test
    public void senhaErradaNasc(){
        assertEquals(false, ValidarSenha.validar("100890","537.186.600-08","10/08/1990"));
    }

    @Test
    public void senhaCorreta(){
        assertEquals(true, ValidarSenha.validar("864jlm","537.186.600-08","10/08/1990"));
    }

}