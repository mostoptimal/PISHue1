package pis.hue1;

//Algorithmus von:
//https://studyflix.de/informatik/caesar-verschlusselung-1606


public class Caesar implements Codec {
    String str = "";
    private String schluessel;
    int key;

    public Caesar() {

    }

    public String kodiere(String klartext) {
        klartext = klartext.toLowerCase();
        String schluessel = gibLosung();
        key = schluessel.length();
        for (int i = 0; i < klartext.length(); i++) {
            char next = klartext.charAt(i);
            str += (shift(next, key));
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
        key=gibLosung().length();
        String decoded = "";
        char thisChar;
        for(int i=0; i<geheimtext.length(); i++){
            thisChar= geheimtext.charAt(i);
            //Jeden Buchstaben verschieben und zwar um (26-Schluessel(key)) Stellen
            //und an entschluesselten Text anhaengen
            decoded += shift(thisChar, 26 - key);
        }
        return decoded;
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
        if (letter >= 'A' && letter <= 'Z' ) {
            letter += shift;
            while (letter > 'Z'){
                letter-=26;
            }
        }
        return letter;
    }
}
