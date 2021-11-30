package pis.hue1;

import java.util.*;

public class Wuerfel implements Codec {

    StringBuilder sb1 = new StringBuilder();
    Map<Integer ,Character> arrayOrder=new HashMap<>();
    private String schluessel;
    String klartext, losung;
    char[] xxx;


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
        //schlussel in andere array speichern
        //aufsteigend nummerieren und in neue integer array spreichern
        //dann die plaetze umsortieren wo sie sein sollen
        // { S C H W A R Z W A L D }
        // { A A C D H L R S W W Z }
        encryptionKey = encryptionKey.toLowerCase();
        int size = encryptionKey.length();
        char[] sortedKey = new char[size];
        sortedKey = encryptionKey.toCharArray();
        Arrays.sort(sortedKey);
        for (int i = 0; i < size; i++) {
            arrayOrder.put(i,sortedKey[i]);
        }
    }
}