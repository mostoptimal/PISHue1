package pis.hue1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /*********************************/
    public static void main(String[] args) {

        String noneSecretText = "eintreffendersendungverspaetetneuerterminfolgt";
        String losung = "SCHWARZWALD";
        //fuer die Permutation
        int[] zahlenLosung = new int[losung.length()];
        //Codec codec1= new Wuerfel("","");
        //Codec codec2=new Caesar();

        Wuerfel w1 = new Wuerfel(noneSecretText, losung);
        //Wuerfel w2 = new Wuerfel();

        for (int i = 0; i < losung.length(); i++) {
            System.out.print(losung.charAt(i) + "  ");
        }
        System.out.println();
        w1.kodiere(noneSecretText, losung);
        //System.out.println("w1: " + w1.kodiere(noneSecretText.toString(), losung));

    }
}
