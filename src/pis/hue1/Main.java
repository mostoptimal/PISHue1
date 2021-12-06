package pis.hue1;

public class Main {
    public static void main(String[] args) {
        //
        String s="";
        Codec codec3=new Caesar();
        codec3.setzeLosung("Mittelhessen");
        s=codec3.dekodiere("Rdmzl vmsf uy waybxqff hqdimtdxaefqz Fmju cgqd pgdot Nmkqdz, 12345678910!?");
        System.out.println("decoded: "+s);
    }
}
