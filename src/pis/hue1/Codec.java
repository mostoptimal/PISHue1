package pis.hue1;

public interface Codec{
    public String kodiere(String klartext,String losung);
    public String dekodiere(String geheimtext);
    public String gibLosung();
    public void setzeLosung(String schluessel)throws IllegalArgumentException; // bei ungeeignetem Schlüssel!
}
