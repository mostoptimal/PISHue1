package pis.hue1;

public class Caesar implements Codec {
    String str = "";
    private String schluessel;
    int key;

    public Caesar() {
        //Constructor
    }

    public String kodiere(String klartext) {
        //make the Text small letters
        klartext = klartext.toLowerCase();
        String schluessel = gibLosung();
        //key is the integer value ,that how many Characters to shift
        key = schluessel.length();
        //for loop calls the shift function for every letter/Character
        for (int i = 0; i < klartext.length(); i++) {
            //make every letter a Character variable
            char next = klartext.charAt(i);
            //then make shift
            str += (shift(next, key));
        }
        //
        return String.valueOf(str);
    }
    //make the same Thing from above ,but with 2 Paramemters
    public String kodiere(String klartext, String losung) {
        // key is integer Value ,contains how many Characters to shift
        setzeLosung(losung);
        key = schluessel.length();
        klartext = klartext.toLowerCase();
        //making the for loop shift for every Character
        for (int i = 0; i < klartext.length(); i++) {
            char next = klartext.charAt(i);
            str += (shift(next, key));
        }
        return String.valueOf(str);
    }

    public String dekodiere(String geheimtext) {
        key=gibLosung().length();
        // prepairing decoded String to contain the Result
        String decoded = "";
        char thisChar;
        for(int i=0; i<geheimtext.length(); i++){
            thisChar= geheimtext.charAt(i);
            //shift every letter (26 - key) positions
            //adding the Result Character to the new String
            decoded += shift(thisChar, 26 - key);
        }
        return decoded;
    }
    //getter Function
    public String gibLosung() {
        return this.schluessel;
    }
    //setter Function
    public void setzeLosung(String schluessel) throws IllegalArgumentException {
        if (!(schluessel == null || schluessel.length() == 0)) {
            this.schluessel = schluessel;
        } else
            throw new IllegalArgumentException("Losungswort nicht erlaubt!");
    }
    //the Function shift changes every Character (shifts) but in the Alphabetic Range (between a and z (Capital or small Letters))
    char shift(char letter, int shift) {
        //we can compare letter from ASCII Table as letters
        //we don't change the Special Letters
        if (letter >= 'a' && letter <= 'z') {
            letter += shift;
            //after shifting test if the Letter stays in the Range
            // If not ,then go back (letter - 26)
            while (letter > 'z') {
                letter -= 26;
            }
        }
        //also shifting with Capital letters
        if (letter >= 'A' && letter <= 'Z' ) {
            letter += shift;
            while (letter > 'Z'){
                letter-=26;
            }
        }
        return letter;
    }
}
