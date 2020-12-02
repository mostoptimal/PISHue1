package pis.hue1;


public class Wuerfel implements Codec{
    private StringBuilder geheimtext =new StringBuilder();
    private StringBuilder klartext =new StringBuilder();
    int[] letterNumber;
    private String schluessel;
    private String[][] textInArray;
    private String[] sortedArray;
    int jump,col,row; //springt so lang der Text von Schlüssel


    public String kodiere(String klartext,String schluessel) {

        for (int i=0; i<= schluessel.length(); i++){
            jump=i;
            while(jump <= klartext.length()){
                geheimtext.append(klartext.charAt(jump));
                jump += schluessel.length();
            }
        }
        return String.valueOf(geheimtext);
    }

    public String dekodiere(String geheimtext) {

        int jump;
        for (int i=0; i<losung.length(); i++){
            jump=i;
            while (jump<losung.length()){
                klartext.appendCodePoint(geheimtext.charAt(i));
                sortedArray[i]= String.valueOf(losung.charAt(i));
                jump +=losung.length();
            }

        }

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

    public void sortSchluessel(String losung){
        for (int i=0; i<losung.length(); i++){
            if (losung.charAt(i)>losung.charAt(i+1)){

                letterNumber[i]=i+1;
            }
        }
    }
    public void saveTextInArray(String text,String losung){
        col=losung.length();
        row=(int) (text.length()/losung.length())+1;
        String[][] tmp= new String[row][col];
        for (int i=0; i<text.length(); i++){
            for (int j=0; j<text.length(); j++){
                textInArray[i][j] = String.valueOf(text.charAt(i));
            }

        }

    }

}
