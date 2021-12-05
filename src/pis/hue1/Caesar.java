package pis.hue1;

//Algorithmus von:
//https://studyflix.de/informatik/caesar-verschlusselung-1606


public class Caesar implements Codec {
    String str = "";
    private String schluessel;
    int key = 3;

    public Caesar() {
        //this.schluessel=gibLosung();
    }

    public String kodiere(String klartext) {
        klartext = klartext.toLowerCase();
        String schluessel = gibLosung();
        key = schluessel.length();
        for (int i = 0; i < klartext.length(); i++) {
            char next = klartext.charAt(i);
            str +=(shift(next, key));
        }
        return String.valueOf(str);
    }

    public String kodiere(String klartext, String losung) {
        String schluessel = gibLosung();
        key = schluessel.length();
        klartext = klartext.toLowerCase();
        for (int i = 0; i < klartext.length(); i++) {
            char next = klartext.charAt(i);
            str += (shift(next, key));
        }
        return String.valueOf(str);
    }

    public String dekodiere(String geheimtext) {
        int key = gibLosung().length();
        for (int i = 0; i < geheimtext.length(); i++) {
            str += (geheimtext.charAt(i) - key);
        }
        return str;
    }

    public String gibLosung() {
        return this.schluessel;
    }

    public void setzeLosung(String schluessel) throws IllegalArgumentException {
        if (!(schluessel == null || schluessel.length() == 0)) {
            this.schluessel = schluessel;
        } else
            throw new IllegalArgumentException("Losungswort nicht erlaubt!");
    }

    char shift(char letter, int shift) {
        //Buchstaben als Zahl behandeln
        if (letter >= 'a' && letter <= 'z') { //Sonderzeichen nicht veraendern
            letter += shift;
            while (letter > 'z') {
                letter -= 26;
            }
        }
        return letter;
    }
}
