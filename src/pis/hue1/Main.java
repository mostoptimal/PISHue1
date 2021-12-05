package pis.hue1;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class Main {
    /*********************************/
    public static void main(String[] args) {
        Codec codec_1 = new Wuerfel("THM");
        Codec codec_2 = new Wuerfel("Mittelhessen");
        //Codec codec_3 = new Caesar();
        codec_1.setzeLosung("Schwarzwald");
        codec_2.setzeLosung("Schwenningen");
        //assertEquals("rza  me rhoeTiu r yn1471?a gikptvwrsna edcBe,2580Fnjtmoltealt xqruhar 369!", codec_1.kodiere("Franz jagt im komplett verwahrlosten Taxi quer durch Bayern, 12345678910!?"));
        //assertEquals(" ridtr ntelao7r5a3eypBohziaaF !m kcmurT?n0t9e1s8l6r1v,trh4w2e au  nx  gejq", codec_2.kodiere("rza  me rhoeTiu r yn1471?a gikptvwrsna edcBe,2580Fnjtmoltealt xqruhar 369!"));


        String noneSecretText="eintreffendersendungverspaetetneuerterminfolgt";
        String encryptedText="ndeeelmtsvtrngieedffprugnennsefiteereertoarutn";

        String encrypted;
        //encrypted= codec_1.kodiere(noneSecretText);
        //System.out.println("encrypted Text: "+encrypted);
        System.out.println("************************************");
        //String encrypted2;
        //encrypted2= codec_2.kodiere(encrypted);
        codec_2.dekodiere(encryptedText);
        //codec_1.kodiere(codec_1.kodiere(noneSecretText,losung1),losung2);


    }
}
