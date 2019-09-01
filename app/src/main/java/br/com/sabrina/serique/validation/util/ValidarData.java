package br.com.sabrina.serique.validation.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ValidarData {
    public static boolean validar(String dt_nasc){
        int idade;

        int diaN = Integer.valueOf(dt_nasc.substring(0,2));
        int mesN = Integer.valueOf(dt_nasc.substring(3,5));
        int anoN = Integer.valueOf(dt_nasc.substring(6,10));

        GregorianCalendar hoje = new GregorianCalendar();
        int diaH = hoje.get(Calendar.DAY_OF_MONTH);
        int mesH = hoje.get(Calendar.MONTH) + 1;
        int anoH = hoje.get(Calendar.YEAR);


        if(mesN < mesH || (mesN == mesH && diaN <= diaH)){
            idade = anoH - anoN;
        }else{
            idade = (anoH-anoN) - 1;
        }

        if(idade < 18){
            return false;
        }else{
            return true;
        }
    }
}
