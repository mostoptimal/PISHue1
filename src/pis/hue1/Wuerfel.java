package pis.hue1;

import java.util.*;

public class Wuerfel implements Codec {

    StringBuilder encryptedText = new StringBuilder();
    Map<Integer, Character> arrayOrder = new HashMap<>();
    private String schluessel;
    String klartext, losung;


    //Constructors
    public Wuerfel(String text) {
        this.klartext=text;
    }

    public Wuerfel(String text, String losung) {
        this.klartext = text;
        this.losung = losung;
        //
    }

    public String kodiere(String klartext, String schluessel) {
        //delete all Spaces: " "
        klartext = klartext.replaceAll("\s", "");

        //calling function that give every Letter number of order
        nummerizeKey(schluessel);
        System.out.println(klartext);
        //then a function that responsable to encyrpt the Text after the generated order
        //

        return klartext;
    }

    public String dekodiere(String geheimtext) {
        //first Thing representing the Text as 2 Demintional Array and as long as the 2nd key
        //saving the key now vertically ,then do the same process after that with the first key
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
        StringBuilder resultText= new StringBuilder();
        //schlussel in andere array speichern
        //aufsteigend nummerieren und in neue Map speichern
        //encryptionKey: { S=0, C=1, H=2, W=3, A=4, R=5, Z=6, W=7, A=8, L=9, D=10 } j
        //sortedKey:     { 0=a, 1=a, 2=c, 3=d, 4=h, 5=l, 6=r, 7=s, 8=w, 9=w, 10=z } i
        encryptionKey = encryptionKey.toLowerCase();
        int size = encryptionKey.length();
        char[] sortedKey;
        sortedKey = encryptionKey.toCharArray();
        Arrays.sort(sortedKey);
        for (int i = 0; i < size; i++) {
            arrayOrder.put(i, sortedKey[i]);
        }
        //Now: search for the real position in witch Charackter and append the Column (letter by letter) in new StringBuilder
        //System.out.println("Encryption Key: " + s);
        System.out.println(arrayOrder);
        encode(encryptionKey,resultText);
    }
    void encode(String encryptionKey, StringBuilder sb) {
        System.out.println(encryptionKey);
        //arrayOrder:    { 0=a, 1=a, 2=c, 3=d, 4=h, 5=l, 6=r, 7=s, 8=w, 9=w, 10=z } i
        //encryptionKey: { S=0, C=1, H=2, W=3, A=4, R=5, Z=6, W=7, A=8, L=9, D=10 } j
        int size = encryptionKey.length();
        int jump=0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i!=j && encryptionKey.charAt(j) == arrayOrder.get(i)) {
                    jump=j;
                    System.out.print("* "+arrayOrder.get(i)+" ");
                    while(jump<klartext.length()){
                        sb.append(klartext.charAt(jump));
                        jump += size;
                    }
                }
            }
        }
        System.out.println();
        System.out.println("SB: "+sb);

        //if (encryptionKey.charAt(j) == arrayOrder.get(i)) {
        //  for (jump = encryptionKey.indexOf(i); jump <= klartext.length(); jump += size) {ss.append(klartext.charAt(jump));}}
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