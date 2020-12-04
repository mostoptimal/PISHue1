package pis.hue1;


public class Wuerfel implements Codec{
    private StringBuilder geheimtext =new StringBuilder();
    private StringBuilder klartext =new StringBuilder();
    private String schluessel;

    public String kodiere(String klartext,String schluessel) {


        return String.valueOf(geheimtext);
    }

    public String dekodiere(String geheimtext) {


        return String.valueOf(klartext);
    }

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
