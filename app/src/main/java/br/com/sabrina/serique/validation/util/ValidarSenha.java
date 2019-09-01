package br.com.sabrina.serique.validation.util;

public class ValidarSenha {
    public static boolean validar(String senha, String cpf, String data){

        if(senha.length() != 6
                || hasSequence(senha) || hasCPF(senha, cpf) || hasNasc(senha, data)){
            return false;
        }

        return true;
    }

    //Sequencia
    private static boolean hasSequence(String senha){
        int eqAnteriorAsc, eqPosteriorAsc, eqAnteriorDesc, eqPosteriorDesc;
        int base;

        for(int i = 1; i< senha.length()-1; i++){
            try{
                Long.parseLong(senha.substring(i,i+1));

                eqAnteriorAsc = (senha.charAt(i-1))+1;
                eqPosteriorAsc = (senha.charAt(i+1))-1;
                eqAnteriorDesc = (senha.charAt(i-1))-1;
                eqPosteriorDesc = (senha.charAt(i+1))+1;
                base = senha.charAt(i);

                if(((base == eqAnteriorAsc) && (base == eqPosteriorAsc))
                    || ((base == eqAnteriorDesc) && (base == eqPosteriorDesc))){
                    return true;
                }

            }catch (NumberFormatException e){
                //Digito não é numero
            }
        }

        return false;
    }

    //CPF
    private static boolean hasCPF(String senha, String cpf){
        String sequencia;
        cpf = cpf.replace(".","").replace("-","").trim();

        if((senha.equals(cpf.substring(0,6)))
                || (senha.equals(cpf.substring(5,11)))){
            return true;
        }

        return false;
    }

    //Nascimento
    private static boolean hasNasc (String senha, String nascimento){
        String diaN = nascimento.substring(0,2);
        String mesN = nascimento.substring(3,5);
        String anoN = nascimento.substring(8,10);

        String data = diaN+mesN+anoN;

        if(senha.equals(data)){
            return true;
        }
        return false;
    }
}
