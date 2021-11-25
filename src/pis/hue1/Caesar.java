package pis.hue1;

//Algorithmus von:
//https://studyflix.de/informatik/caesar-verschlusselung-1606


public class Caesar implements Codec{
    StringBuilder str= new StringBuilder();
    int key = 3;

    public String kodiere(String klartext,String losung){

        klartext=klartext.toLowerCase();
        for (int i=0; i<klartext.length(); i++){
            char next = klartext.charAt(i);
            str.append(shift(next, key));
        }
        return String.valueOf(str);
    }
    public String dekodiere(String geheimtext){
        for (int i=0; i<geheimtext.length(); i++){
            str.append(geheimtext.charAt(i)-3);
        }
        return String.valueOf(str);
    }
    public String gibLosung(){
        return "";
    }
    public void setzeLosung(String schluessel)throws IllegalArgumentException{

    }
    public static char shift(char letter, int shift){
        //Buchstaben als Zahl behandeln
        if(letter>='a' && letter <='z'){ //Sonderzeichen nicht veraendern
            letter += shift;
            while(letter > 'z'){
                letter -= 26;
            }
        }
        return letter;
    }
}
