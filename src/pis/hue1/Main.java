package pis.hue1;

public class Main {

    public static void main(String[] args) {

        String myText;
        String keyString;
        Codec codec1= new Wuerfel();
        Codec codec2=new Caesar();
        myText="i am here texting my terminal";
        keyString="here";
        for(int i=0; i<myText.length(); i++){
            for (int j=0; j<myText.length(); j++){
                codec1.saveTextInArray(myText,keyString);
            }
        }
    }
}
