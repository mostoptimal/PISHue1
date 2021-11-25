package pis.hue1;


import java.util.ArrayList;

public class Wuerfel implements Codec{

    StringBuilder sb1= new StringBuilder();

    private String schluessel;

    public Wuerfel(){
        //
    }

    public Wuerfel(String text,String losung){
        //
    }

    public String kodiere(String klartext,String schluessel) {
        klartext = klartext.replaceAll("\s","");
        //sb1.append(klartext); //maybe fault to Convert between String and Strinngbuilder
        for(int i=0; i<=sb1.length(); i++) {

        }
        return klartext;
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
