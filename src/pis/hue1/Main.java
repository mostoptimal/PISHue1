package pis.hue1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    /*********************************/
    public static void main(String[] args) {

        String noneSecretText = "i am here texting my terminal";
        String losung = "SCHWARZWALD";
        //fuer die Permutation
        int[] zahlenLosung = new int[losung.length()];
        //Codec codec1= new Wuerfel("","");
        //Codec codec2=new Caesar();

        Wuerfel w1 = new Wuerfel(noneSecretText, losung);
        Wuerfel w2 = new Wuerfel();

        w1.kodiere(noneSecretText, losung);
        System.out.println(noneSecretText);
        System.out.println("w1: " + w1.kodiere(noneSecretText.toString(), losung));

        for (int i = 0; i < losung.length(); i++) {
            System.out.print(losung.charAt(i) + "  ");
            System.out.print("  ");
        }
        System.out.println();
        for (int i = 0; i < losung.length(); i++) {
            System.out.print(w1.lettersPermutationArray[i] + "  ");

        }
        System.out.println();
        System.out.print(w1.arrayOrder);

    }
}
