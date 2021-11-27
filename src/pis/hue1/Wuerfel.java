package pis.hue1;

public class Wuerfel implements Codec{

    StringBuilder sb1= new StringBuilder();
    private String schluessel;
    String klartext,losung;
    int[] lettersPermutationArray;



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
        //delete all Spaces: " "
        klartext = klartext.replaceAll("\s","");
        lettersPermutationArray = new int[schluessel.length()];
        losungNummerieren(schluessel,lettersPermutationArray);
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

    void losungNummerieren(String schluessel , int[] x){

        for (int i=0; i<schluessel.length(); i++){
            for (int j=0; j<schluessel.length(); j++){
                if ((schluessel.charAt(i)>=schluessel.charAt(j)) && (j != i)){
                    x[i]+=1;
                }
            }
        }
    }


    void fillAndPrintArray(int[] zahlenLosung){
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