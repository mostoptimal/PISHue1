package pis.hue1;

public class Wuerfel implements Codec{

    StringBuilder sb1= new StringBuilder();
    private String schluessel;
    String klartext,losung;
    char[][] chArr;
    //fuer die Permutation
    int[] zahlenLosung;


    //Constructors
    public Wuerfel(){
        //
    }
    public Wuerfel(String text,String losung){
        this.klartext=text;
        this.losung=losung;
        //
    }

    public String kodiere(String klartext,String schluessel) {
        klartext = klartext.replaceAll("\s",""); //delete all Spaces: " "
        int[] x= new int[schluessel.length()];
        //sb1.append(klartext); //maybe fault to Convert between String and Stringbuilder
        for (int i=0; i<schluessel.length()-1; i++){
            for (int j=i; j<schluessel.length(); j++){
                if (schluessel.charAt(i)<schluessel.charAt(j)){
                    x[i]++;
                }
            }
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
    void fillAndPrintArray(){
        for (int i=0; i<=schluessel.length(); i++) {
            System.out.print(zahlenLosung[i]+" ");
        }
    }

}

/**
 *         //fill Char Array from Strings
 *         for(int i=0; i<=klartext.length(); i++) {
 *             for (int j=0; j<=schluessel.length(); j++){
 *                 //chArr[i][j]= klartext.charAt(j);
 *                 System.out.print(klartext.charAt(i)+ " ");
 *             }
 *             System.out.print("\n");
 *         }
 *         //**********
 *         for(int i=0; i<=losung.length(); i++) {
 *             for (int j=0; j<=klartext.length(); j++){
 *                 System.out.print(chArr[i][j]+ " ");
 *             }
 *         }
 * */