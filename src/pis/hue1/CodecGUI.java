package pis.hue1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EncryptionDecryption extends JFrame implements ActionListener {
    Codec codec1;
    Codec codec2;
    Codec codecCs;
    JFrame mainFrame;
    FlowLayout mainLayout;
    Button btnEncrypt;
    Button btnDecrypt;
    ButtonGroup btnEncryptGrp;
    JRadioButton JradioWuerfel;
    JRadioButton JradioCaeser;
    JLabel JschluesselLabel1;
    TextField JschluesselTA1;
    JLabel JschluesselLabel2;
    TextField JschluesselTA2;
    JLabel JLIntput;
    TextArea taInput;
    JLabel JLOutput;
    TextArea taOutput;


    /**
     *
     */
    public EncryptionDecryption() {

        mainLayout = new FlowLayout();
        mainFrame = new JFrame();

        Panel panelButtons = new Panel();
        Panel panelTextField = new Panel();
        Panel panelRadioButtons = new Panel();
        Panel panelSchluessel = new Panel();


        //Window Elements
        btnEncrypt = new Button("Encrypt");
        btnDecrypt = new Button("Decrypt");

        btnEncryptGrp = new ButtonGroup();
        JradioWuerfel = new JRadioButton("Wuerfel");
        JradioWuerfel.setSelected(true);
        JradioCaeser = new JRadioButton("Caeser");
        btnEncryptGrp.add(JradioCaeser);
        btnEncryptGrp.add(JradioWuerfel);

        JschluesselLabel1 = new JLabel("Schluessel 1");
        JschluesselTA1 = new TextField("");
        JschluesselTA1.setPreferredSize(new Dimension(120, 20));

        JschluesselLabel2 = new JLabel("Schluessel 2");
        JschluesselTA2 = new TextField("");
        JschluesselTA2.setPreferredSize(new Dimension(120, 20));

        JLIntput = new JLabel("Input Text");
        taInput = new TextArea();
        JLOutput = new JLabel("output Text");
        taOutput = new TextArea();


        panelButtons.add(btnEncrypt);
        panelButtons.add(btnDecrypt);

        panelRadioButtons.add(JradioWuerfel);
        panelRadioButtons.add(JradioCaeser);

        panelTextField.add(JLIntput);
        panelTextField.add(taInput);
        panelTextField.add(JLOutput);
        panelTextField.add(taOutput);
        //
        panelSchluessel.add(JschluesselLabel1);
        panelSchluessel.add(JschluesselTA1);
        panelSchluessel.add(JschluesselLabel2);
        panelSchluessel.add(JschluesselTA2);
        //
        mainFrame.getContentPane().add(panelButtons);
        mainFrame.getContentPane().add(panelRadioButtons);
        mainFrame.getContentPane().add(panelSchluessel);
        mainFrame.getContentPane().add(panelTextField);

        mainFrame.setTitle("Codec App");
        mainFrame.setLayout(mainLayout);
        mainFrame.setSize(1200, 300);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnEncrypt.addActionListener(this);
        btnDecrypt.addActionListener(this);
    }

    /**
     * @param e is an Event that be performed when the user clicks the Encrypt/Decrypt Buttons and clicks the Radio Buttons
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String textToEncode = taInput.getText();
        String textToDecode = taInput.getText();
        String keyFirst = JschluesselTA1.getText().toLowerCase();
        String keySecond = JschluesselTA2.getText().toLowerCase();
        //Encrypt Action
        if (e.getSource() == btnEncrypt) {
            if (JradioWuerfel.isSelected()) {
                String encodedText;
                if (textToEncode.equals("") || keyFirst.equals("") || keySecond.equals("")) {
                    JOptionPane.showMessageDialog(this, "please Fill FirstKey, Last Key and Input Area!", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    codec1 = new Wuerfel(keyFirst);
                    codec2 = new Wuerfel(keySecond);
                    encodedText = codec1.kodiere(textToEncode, keyFirst);
                    encodedText = codec2.kodiere(encodedText, keySecond);
                    taOutput.setText(encodedText);
                }
            } else {
                if (JradioCaeser.isSelected()) {
                    if (textToEncode.equals("")) {
                        JOptionPane.showMessageDialog(this, "Please Fill the Input text");
                    } else {
                        String encodedText;
                        codecCs = new Caesar();
                        encodedText = codecCs.kodiere(textToEncode, keyFirst);
                        taOutput.setText(encodedText);
                    }
                }
            }
        }
        //Decrypt Action
        if (e.getSource() == btnDecrypt) {
            if (JradioCaeser.isSelected()) {
                codecCs = new Caesar();
                if (textToDecode.equals("") || keyFirst.equals("")) {
                    JOptionPane.showMessageDialog(this, "please write the Text you want to Decode and FirstKey !");
                } else {
                    String decodedCSText = "";
                    codecCs.setzeLosung(keyFirst);
                    decodedCSText = codecCs.dekodiere(textToDecode);
                    taOutput.setText(decodedCSText);
                }
            } else if (JradioWuerfel.isSelected()) {
                if (textToDecode.equals("") || keySecond.equals("") || keyFirst.equals("")) {
                    JOptionPane.showMessageDialog(this, "Please Fill The Keys and the Input Text!");
                } else {
                    String decodedText;
                    decodedText = codec2.dekodiere(textToDecode);
                    decodedText = codec1.dekodiere(decodedText);
                    taOutput.setText(decodedText);
                }
            }
        }
    }

    /**
     * @param args just normal main method argument that I have never used
     *             It is a Joke :P
     */
    public static void main(String[] args) {
        EncryptionDecryption mainFrame = new EncryptionDecryption();
    }
}