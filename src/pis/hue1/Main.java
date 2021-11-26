package pis.hue1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<WordObject> wordsList= new ArrayList<>();
    /*********************************/
    public static void main(String[] args) {

        String myText ="i am here texting my terminal";
        String losung="SCHWARZWALD";

        //Codec codec1= new Wuerfel("","");
        //Codec codec2=new Caesar();

        Wuerfel w1 = new Wuerfel(myText,losung);
        Wuerfel w2 = new Wuerfel();

        w1.kodiere(myText,losung);
        System.out.println(myText);
        System.out.println("w1: " + w1.kodiere(myText.toString(),losung));


        /** System.out.println(losung);
        System.out.println(sortTextAlphabet(losung));
        creatWordObjectArrayList(myText,losung);

        for (int i=0; i<losung.length();i++){
            System.out.print(wordsList.get(i).getCh());
        }
         */
    }
    public static void creatWordObjectArrayList(String text,String losung){
        for (int i=0; i<losung.length(); i++){
            wordsList.add(new WordObject(text.charAt(i),i));
            //wordsList.add(new WordObject(text.charAt(i),i,losung));
        }
    }

    public void resortWordObject(String text, String losung){
        //Erste Schleife ruft die set Methode für String Section
        for(int i=0; i< losung.length(); i++){
            for (int j=0;j<losung.length(); j++){
                if (wordsList.get(i).equals(str.get(i))){
                    wordsList.get(i).setEncryptedSection(text,losung);
                }
            }
        }
        //die zweite Schleife um die passende (gehoeringe) Nummer zu speichern
        for (int i=0; i<wordsList.size();i++){
            if (wordsList.get(i).getCh()== str.indexOf(i)){
                wordsList.get(i).setNumber(index.get(i));
            }
        }
        System.out.println(wordsList);
    }
    static ArrayList<Integer> index =new ArrayList<>(); //speichert die Nummer von jeder Buchstabe (sortiert)

    static ArrayList<String> str = new ArrayList(); //speihert das Schluesselwort sortiert


    //die Methode sortiert das Losungs-wort nach alphabet
    //und speichert die Nummer (auch sortiert) aufsteigend.
    public static ArrayList<String> sortTextAlphabet(String text){ //Methode sortiert das Schluesselwort aufsteigend

        for (int i=0; i<text.length();i++){
            str.add(String.valueOf(text.charAt(i)));

        }
        Collections.sort(str, String.CASE_INSENSITIVE_ORDER);
        for (int j=0;j<str.size();j++){
            index.add(j+1);
        }
        System.out.println(index);
/*
        for (int i=0; i<=text.length()-1; i++){
            for (int j=i+1;j<=text.length(); j++){
                if (text.charAt(i)<=text.charAt(j)){
                    tmp.append(text.charAt(i));
                }
            }
        }*/
        return str;
    }
}
