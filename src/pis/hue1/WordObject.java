package pis.hue1;

public class WordObject {
    private char ch;
    private int number;
    private StringBuilder sb;
    private String encryptedSection;

    public WordObject(char ch, int num,String st){
        setCh(ch);
        setNumber(num);
        setEncryptedSection(st);
    }










    /**setters und getters*/
    public void setCh(char ch){
        this.ch=ch;
    }
    public char getCh(){
        return this.ch;
    }
    public void setNumber(int number){
        this.number=number;
    }
    public int getNumber(){
        return this.number;
    }
    public void setEncryptedSection(String textToEncrypt,String losung){
        int jump;
        for (int i=0; i<textToEncrypt.length(); i++){
            jump=i+1;

            while(jump<=textToEncrypt.length()){
                sb.append(textToEncrypt.charAt(jump));
                jump +=losung.length();
            }
            this.encryptedSection=String.valueOf(sb);
        }


        this.encryptedSection=textToEncrypt;
    }
    public String getEncryptedSection(){
        return this.encryptedSection;
    }
}