package pis.hue1;

import java.util.*;

public class Wuerfel implements Codec {
    Map<Integer, Character> arrayOrder = new HashMap<>();
    private String schluessel;
    String klartext, losung;

    /**Constructors
     1.             */
    public Wuerfel(String losung) {
        setzeLosung(losung);
    }
    /** 2.         */
    public Wuerfel(String text, String losung) {
        this.klartext = text;
        setzeLosung(losung);
    }

    public String kodiere(String klartext) {
        String result;
        String schluessel = gibLosung();


        result=encrypt(klartext,schluessel);
        System.out.println("Encryption Key: " + schluessel);
        System.out.println("Original Text: " + klartext);
        System.out.println("after encryption: " + encrypt(klartext, schluessel));
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        return result;

    }

    public String kodiere(String klartext, String schluessel) {

        //encrypt(klartext,schluessel);
        System.out.println("Encryption Key: " + schluessel);
        System.out.println("Original Text: " + klartext);
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("after encryption: " + encrypt(klartext, schluessel));
        String resultEncryption;
        resultEncryption=encrypt(klartext, schluessel);
        //then a function that responsable to encyrpt the Text after the generated order
        //
        return resultEncryption;
    }

    public String dekodiere(String geheimtext) {

        return "";
    }

    /**
     * Setter und Getter
     */
    public String gibLosung() {
        return this.losung;
    }

    public void setzeLosung(String losung) throws IllegalArgumentException {
        for (int i = 0; i < losung.length(); i++) {
            if (Character.isDigit(losung.charAt(i))){
                throw new IllegalArgumentException("Keyword allowed just Alphabet Letters , Numbers & Special Characters are not allowed!");
            }
        }
        if (!(losung == null || losung.length() == 0)) {
            this.losung = losung.toLowerCase();
            System.out.println("losung gesetzt!= "+losung);
        } else
            throw new IllegalArgumentException("Keyword allowed just Alphabet Letters , Numbers & Special Characters are not allowed!");
    }

    int[] nummerizeKey(String encryptionKey) {
        // Array enthält den Rang der spalten
        int size= encryptionKey.length();
        int[] nummerizedColumn = new int[size];
        for (int i = 0; i < encryptionKey.length(); i++) {
            // Rang des i. Elements ermitteln
            nummerizedColumn[i] = 0;
            for (int j = 0; j < encryptionKey.length(); j++) {
                if (encryptionKey.charAt(j) < encryptionKey.charAt(i) || (encryptionKey.charAt(j) == encryptionKey.charAt(i) && j < i))
                    nummerizedColumn[i]++;
            }
        }
        return nummerizedColumn;
    }
    int[] reOrder(int[] perm) {
        // vertauscht Index und Wert eines Arrays
        int[] p = new int[perm.length];
        for (int i = 0; i < p.length; i++)
            p[perm[i]] = i;
        return p;
    }
    String encrypt(String encryptionText, String encryptionkey) {
        int encryptionKeySize = encryptionkey.length();
        int encryptionTextSize = encryptionText.length();
        int linesSize = (int) Math.ceil(encryptionTextSize / encryptionKeySize);

        // Alle Spalten leer, cause I don't want to add over letter with null
        String[] cols = new String[encryptionKeySize];
        for (int i = 0; i < encryptionKeySize; i++) {
            cols[i] = "";
        }
        // Alle Spalten füllen
        for (int i = 0; i < encryptionTextSize; i++) {
            int col = i % encryptionKeySize;
            cols[col] += encryptionText.charAt(i);
        }
        // Alle Spalten permutiert zusammenbauen
        String text = "";
        for (int i = 0; i < cols.length; i++) {
            int j = reOrder(nummerizeKey(encryptionkey))[i];
            text += cols[j];
        }
        return text;
    }

    void decrypt(String secretText) {
        String losung= gibLosung();
        int size = secretText.length();


    }
}
