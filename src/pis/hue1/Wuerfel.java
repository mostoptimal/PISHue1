package pis.hue1;

import java.util.*;

public class Wuerfel implements Codec {

    StringBuilder encyptedText = new StringBuilder();
    Map<Integer, Character> arrayOrder = new HashMap<>();
    private String schluessel;
    String klartext, losung;


    //Constructors
    public Wuerfel() {
        //
    }

    public Wuerfel(String text, String losung) {
        this.klartext = text;
        this.losung = losung;
        //
    }

    public String kodiere(String klartext, String schluessel) {
        //delete all Spaces: " "
        klartext = klartext.replaceAll("\s", "");
        nummerizeKey(schluessel);
        return klartext;
    }

    public String dekodiere(String geheimtext) {
        //first Thing representing the Text as 2 Demintional Array and as long as the 2nd key
        //saving the key now verticcaly ,then do the same process after that with the first key
        return "";
    }


    /**
     * Setter und Getter
     */
    public String gibLosung() {

        return this.schluessel;
    }

    public void setzeLosung(String schluessel) throws IllegalArgumentException {
        if (!(schluessel == null || schluessel.length() == 0)) {
            this.schluessel = schluessel;
        } else
            throw new IllegalArgumentException("Losungswort nicht erlaubt!");
    }

    void nummerizeKey(String encryptionKey) {
        StringBuilder s = new StringBuilder(encryptionKey);
        //schlussel in andere array speichern
        //aufsteigend nummerieren und in neue Map speichern
        // { S C H W A R Z W A L D }
        // {0=a, 1=a, 2=c, 3=d, 4=h, 5=l, 6=r, 7=s, 8=w, 9=w, 10=z}
        encryptionKey = encryptionKey.toLowerCase();
        int size = encryptionKey.length();
        char[] sortedKey = new char[size];
        sortedKey = encryptionKey.toCharArray();
        Arrays.sort(sortedKey);
        for (int i = 0; i < size; i++) {
            arrayOrder.put(i, sortedKey[i]);
        }
        //Now: search for the real position in witch Charackter and append the Column (letter by letter) in new StringBuilder
        int jump = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (encryptionKey.charAt(j) == arrayOrder.get(i)) {
                    jump = encryptionKey.indexOf(i);
                    while (jump <= klartext.length()) {
                        s.append(klartext.charAt(jump));
                        jump += size;
                    }
                }
            }
        }
        System.out.print("Encrypted Text: " + s);
    }
}
/**
 * int jumpingFactor;
 * for (int i = 0; i < size; i++) {
 * if (encryptionKey.charAt(i) == arrayOrder.get(i)) {
 * jumpingFactor = encryptionKey.indexOf(encryptionKey.charAt(i));
 * while (jumpingFactor < klartext.length()) {
 * s.append(klartext.charAt(jumpingFactor));
 * jumpingFactor += size;
 * }
 * }
 * }
 * System.out.println("Encrypted Text: " + s);
 */