package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaMD5 {

    private static MessageDigest md = null;

    static{
        // Códgio responsavel por gerar o algoritimo MD5
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
    }

    //Metodo responsavel gerar a chave a partir do texto inserido.
    private static char[] hexCodes(byte[] text){
        char[] entrada = new char[text.length *2];
        String stringGerada;

        for(int i=0; i<text.length; i++){
            stringGerada = "00" + Integer.toHexString(text[i]);
            stringGerada.toUpperCase().getChars(stringGerada.length() -2, stringGerada.length(), entrada, i*2);
        }

        return entrada;
    }

    //Metodo responsavel por criptografar
    public static String criptografar(String senha){
        String textoCriptografado = null;

        if(md != null){
            textoCriptografado = new String(hexCodes(md.digest(senha.getBytes())));
        }

        return textoCriptografado;
    }
}
