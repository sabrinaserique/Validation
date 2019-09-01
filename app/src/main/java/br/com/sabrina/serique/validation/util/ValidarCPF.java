package br.com.sabrina.serique.validation.util;

public class ValidarCPF {
    public static boolean validar(String cpf){
        cpf = cpf.replace(".","").replace("-","").trim();

        if(cpf == null || cpf.length() != 11 || isSequence(cpf)){
            return false;
        }

        try {
            Long.parseLong(cpf);
        } catch (NumberFormatException e) { // CPF não possui somente números
            return false;
        }

        return calcularDigitoVerificador(cpf.substring(0, 9)).equals(cpf.substring(9, 11));
    }

    private static boolean isSequence(String cpf){
        if(cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999")){
            return true;
        }else{
            return false;
        }
    }

    private static String calcularDigitoVerificador(String numero) {
        Integer primDig, segDig;
        int soma = 0, peso = 10;

        //Primeiro Digito Verificador
        for (int i = 0; i < numero.length(); i++) {
            soma += Integer.parseInt(numero.substring(i, i + 1)) * peso--;
        }

        if (soma % 11 == 0 | soma % 11 == 1) {
            primDig = new Integer(0);
        }
        else {
            primDig = new Integer(11 - (soma % 11));
        }

        //Segundo Digito Verificador
        soma = 0;
        peso = 11;

        for (int i = 0; i < numero.length(); i++) {
            soma += Integer.parseInt(numero.substring(i, i + 1)) * peso--;
        }

        soma += primDig.intValue() * 2;

        if (soma % 11 == 0 | soma % 11 == 1) {
            segDig = new Integer(0);
        }
        else {
            segDig = new Integer(11 - (soma % 11));
        }

        return primDig.toString() + segDig.toString();
    }
}
