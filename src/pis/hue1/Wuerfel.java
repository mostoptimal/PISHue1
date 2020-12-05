package pis.hue1;


import java.util.ArrayList;

public class Wuerfel implements Codec{


    private String schluessel;

    public Wuerfel(String text,String losung){

    }
    public String kodiere(String klartext,String schluessel) {

        return "";
    }
    public String dekodiere(String geheimtext) {

        return "";
    }


    /**Setter und Getter*/
    public String gibLosung() {

        return this.schluessel;
    }
    public void setzeLosung(String schluessel) throws IllegalArgumentException {
        if (!(schluessel==null ||schluessel.length()==0)){
            this.schluessel=schluessel;
        }else
         throw new IllegalArgumentException("Losungswort nicht erlaubt!");
    }


}
