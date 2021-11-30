package pis.hue1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class CodecGUI extends JFrame {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        Panel panelButtons = new Panel();
        Panel panelTextArea = new Panel();
        Panel panelWeird = new Panel();
        mainFrame.setTitle("Mein erstes Swing-Fenster");
        mainFrame.setSize(640,480);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Window Elements
        Button btnWuerfel = new Button("Doppel Wuerfel encrypt");
        Button btnCaeser = new Button("Caeser");
        Button btnExit = new Button("Exit");
        btnExit.setPreferredSize(new Dimension(60,30));
        TextField tfWuerfel = new TextField("Text here to encrypt with Doppel Wuerfel");
        TextField tfCaeser = new TextField("Text here to encrypt with Caeser");


        //btnWuerfel.setPreferredSize(new Dimension(80,50));
        //btnCaeser.setPreferredSize(new Dimension(70,50));

        panelButtons.add(btnWuerfel);
        panelButtons.add(btnCaeser);
        panelWeird.add(btnExit);
        panelTextArea.add(tfWuerfel);
        panelTextArea.add(tfCaeser);

        mainFrame.getContentPane().add(BorderLayout.NORTH,panelButtons);
        mainFrame.getContentPane().add(BorderLayout.CENTER,panelTextArea);
        mainFrame.getContentPane().add(BorderLayout.SOUTH,panelWeird);

        Color hell =   new Color(200,200,200);
        Font mono = new Font("monospaced",Font.BOLD+Font.ITALIC,30);

        btnExit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


}

/**

 */