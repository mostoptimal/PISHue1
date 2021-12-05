package pis.hue1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EncryptionDecryption extends JFrame implements ActionListener{
    Codec codec1;
    Codec codec2;
    Codec codecCs;

    public EncryptionDecryption(){
        Container ct;
        ct= getContentPane();
        SpringLayout mainLayout = new SpringLayout();
        ct.setLayout(mainLayout);
        ct.setBackground(Color.BLUE);
        JFrame mainFrame = new JFrame();

        Panel panelButtons = new Panel();
        Panel panelTextField = new Panel();
        Panel panelWeird = new Panel();
        Panel panelRadioButtons = new Panel();
        Panel panelSchluessel = new Panel();

        panelButtons.setLayout(new CardLayout());
        panelTextField.setLayout(new CardLayout());
        panelRadioButtons.setLayout(new CardLayout());
        panelSchluessel.setLayout(new CardLayout());
        panelWeird.setLayout(new CardLayout());


        mainFrame.setTitle("Codec App");
        mainFrame.setSize(640,480);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Window Elements
        Button btnEncrypt = new Button("Encrypt");
        Button btnDecrypt = new Button("Decrypt");

        JRadioButton JradioWuerfel = new JRadioButton("Wuerfel");
        JRadioButton JradioCaeser = new JRadioButton("Caeser");

        TextArea taInput = new TextArea("Input Text");
        TextArea taOutput = new TextArea("Output Text");
        JLabel JschluesselLabel1 =new JLabel("Schluessel 1");
        TextField JschluesselTA1 =new TextField("");
        JLabel JschluesselLabel2 =new JLabel("Schluessel 2");
        TextField JschluesselTA2 =new TextField("");

        panelButtons.add(btnEncrypt);
        panelButtons.add(btnDecrypt);

        panelRadioButtons.add(JradioWuerfel);
        panelRadioButtons.add(JradioCaeser);
        panelTextField.add(taInput);
        panelTextField.add(taOutput);
        //
        panelSchluessel.add(JschluesselLabel1);
        panelSchluessel.add(JschluesselTA1);
        panelSchluessel.add(JschluesselLabel2);
        panelSchluessel.add(JschluesselTA2);
        //
        mainFrame.getContentPane().add(BorderLayout.NORTH,panelButtons);
        mainFrame.getContentPane().add(BorderLayout.CENTER,panelRadioButtons);
        mainFrame.getContentPane().add(BorderLayout.CENTER,panelSchluessel);
        mainFrame.getContentPane().add(BorderLayout.SOUTH,panelTextField);

        //mainFrame.getContentPane().add(BorderLayout.SOUTH,panelWeird);

        Color hell =   new Color(200,200,200);
        Font mono = new Font("monospaced",Font.BOLD+Font.ITALIC,30);

        btnEncrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


public class CodecGUI{
    public static void main(String[] args) {
        EncryptionDecryption mainFrame = new EncryptionDecryption();
        Codec codec_1=new Wuerfel("THM");
        Codec codec_2=new Wuerfel("Mittelhessen");
        Codec codec_3=new Caesar();

    }


}

/**

 */