package pis.hue1;

import java.util.*;

public class Wuerfel implements Codec {
    String klartext, losung;
    //the Char Array is to contain the Characters (after encrypting / decrypting) Letter by Letter
    char[] resultCharArray;


    /**
     * @param losung
     *
     *      * Constructors
     *      * 1. First one with just key Parameter
     *
     */
    public Wuerfel(String losung) {
        setzeLosung(losung);
    }


    /**
     * @param text
     * @param losung
     * 2. Second one with 2 params ,the text to encode/decode and keyword
     */
    public Wuerfel(String text, String losung) {
        this.klartext = text;
        setzeLosung(losung);
    }

    /**
     * @param klartext
     * @return
     */
    public String kodiere(String klartext) {
        String result;
        String schluessel = gibLosung().toLowerCase();
        result = encrypt(klartext, schluessel);
        return result;
    }

    /**
     * @param klartext
     * @param schluessel
     * @return
     */
    public String kodiere(String klartext, String schluessel) {
        String resultEncryption;

        //the Operations are contained in the encrypt Function
        resultEncryption = encrypt(klartext, schluessel);
        return resultEncryption;
    }

    /**
     * @param geheimtext
     * @return
     */
    public String dekodiere(String geheimtext) {
        String result;
        //decrypt Function makes the operations of decoding
        result = decrypt(geheimtext);
        return result;
    }


    /**
     * @return
     * Getter
     */
    public String gibLosung() {
        return this.losung;
    }

    /**
     * @param losung
     * @throws IllegalArgumentException
     * Setter
     */
    public void setzeLosung(String losung) throws IllegalArgumentException {
        //for loop to test if every Character is Digit (Integer Value)
        for (int i = 0; i < losung.length(); i++) {
            if (!(Character.isLetter(losung.charAt(i)))) {
                throw new IllegalArgumentException("Keyword allowed just Alphabet Letters , Numbers & Special Characters are not allowed!");
            }
        }
        // and the key is not allowed to be Empty
        if (!(losung == null || losung.length() == 0)) {
            this.losung = losung;
            System.out.println("losung gesetzt!= " + losung);
        } else
            throw new IllegalArgumentException("Keyword allowed just Alphabet Letters , Numbers & Special Characters are not allowed!");
    }


    /**
     * @param encryptionKey
     * @return
     * nummerizeKey is to give back permutations of letters of keyword
     */
    int[] nummerizeKey(String encryptionKey) {

        int size = encryptionKey.length();
        //preparing the empty array of integer
        int[] nummerizedColumn = new int[size];
        for (int i = 0; i < encryptionKey.length(); i++) {
            //initializing with 0 Value
            nummerizedColumn[i] = 0;
            for (int j = 0; j < encryptionKey.length(); j++) {
                //calculating the permutation for every Character
                //adding 1 if we find smaller/or same Character and if second loop Variable
                if (encryptionKey.charAt(j) < encryptionKey.charAt(i) || (encryptionKey.charAt(j) == encryptionKey.charAt(i) && j < i))
                    nummerizedColumn[i]++;
            }
        }
        return nummerizedColumn;
    }


    /**
     * @param anyPermutationArray
     * @return
     * reOrder Function is to reSort the permutation array ascending
     */
    int[] reOrder(int[] anyPermutationArray) {
        int[] sortedIntAscending = new int[anyPermutationArray.length];
        for (int i = 0; i < sortedIntAscending.length; i++) {
            //sort the Array ascending (by taing the Value from i Counter)
            sortedIntAscending[anyPermutationArray[i]] = i;
        }
        return sortedIntAscending;
    }

    /**
     * @param encryptionText
     * @param encryptionkey
     * @return
     */
    String encrypt(String encryptionText, String encryptionkey) {
        int encryptionKeySize = encryptionkey.length();
        int encryptionTextSize = encryptionText.length();
        // emptying the Array, cause I don't want to add letter over null
        String[] subStrings = new String[encryptionKeySize];
        for (int i = 0; i < encryptionKeySize; i++) {
            subStrings[i] = "";
        }
        // now fill all Columns with Characters
        for (int i = 0; i < encryptionTextSize; i++) {
            int col = i % encryptionKeySize;
            subStrings[col] += encryptionText.charAt(i);
        }
        // after filling the Array (of String) using reOrder to shuffel the Strings in new Order (relied on keyword alphabetic)
        String encryptedText = "";
        for (int i = 0; i < subStrings.length; i++) {
            //calling the reOrder Function and nummerizeKey
            int j = reOrder(nummerizeKey(encryptionkey))[i];
            //adding the (resulted Substring) to the Text
            encryptedText += subStrings[j];
        }
        return encryptedText;
    }


    /**
     * @param secretText
     * @return
     * decrypt makes the reverse of encrypt
     */
    String decrypt(String secretText) {
        String losung = gibLosung().toLowerCase();
        int secretTextSize = secretText.length();
        int losungSize = losung.length();
        //calculating how many lines (how many Times I have to jump)
        int linesSize = (int) Math.ceil(secretTextSize / losungSize);
        // now initializing the Character array
        resultCharArray = new char[secretTextSize];
        //generate Permutation array
        int[] pib = nummerizeKey(losung);
        //reSort/reOrder it ascending
        pib=reOrder(pib);
        String resultText = "";
        //position to send Characters there (the Original Places in Text)
        int position;
        int secretTextLengthCounter = 0;
        for (int i = 0; i < losungSize; i++) {
            //repositioning
            position = pib[i];
            for (int j = 0; j < linesSize; j++) {
                while (position < secretTextSize && secretTextLengthCounter <= secretTextSize) {
                    //taking the encrypted Character to new (Original) Place
                    resultCharArray[position] = secretText.charAt(secretTextLengthCounter);
                    //then jump to new Line
                    position += losungSize;
                    //going to next Character
                    secretTextLengthCounter++;
                }
            }
        }
        //change the Char Array to String
        for (char c : resultCharArray) {
            resultText+=c;
            System.out.print(" " + c);
        }
        return resultText;
    }
}
