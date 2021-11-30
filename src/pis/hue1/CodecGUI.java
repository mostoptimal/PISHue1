package pis.hue1;

import java.awt.*;
import javax.swing.*;

public class CodecGUI extends JFrame {
    public static void main(String[] args) {
        JFrame fenster = new JFrame();
        fenster.setTitle("Mein erstes Swing-Fenster");
        fenster.setSize(640,480);
        fenster.setVisible(true);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel text1,text2;

        //fenster.add(text1,BorderLayout.NORTH);
        Color hell =   new Color(200,200,200);
        Font mono = new Font("monospaced",Font.BOLD+Font.ITALIC,30);
    }

}
