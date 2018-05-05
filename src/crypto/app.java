/*
 * Created by JFormDesigner on Wed May 02 22:40:19 IST 2018
 */

package crypto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.GroupLayout;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Kamal Pandey
 */
public class app extends JPanel {

    private JFileChooser fileChooser;

    File file;

    public app() {
        initComponents();

        fileChooser = new JFileChooser();

        button_browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browseButtonActionPerformed(e);
            }
        });

        button_encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encryptButtonAction(e);
            }
        });

        button_decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decryptButtonAction(e);
            }
        });



    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kamal Pandey
        button_browse = new JButton();
        textField_key1 = new JTextField();
        button_encrypt = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        textField_key2 = new JTextField();
        button_decrypt = new JButton();
        label3 = new JLabel();
        fileTextField = new JTextField();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- button_browse ----
        button_browse.setText("browse");

        //---- button_encrypt ----
        button_encrypt.setText("encrypt");

        //---- label1 ----
        label1.setText("enter key");

        //---- label2 ----
        label2.setText("enter key");

        //---- button_decrypt ----
        button_decrypt.setText("decrypt");

        //---- label3 ----
        label3.setText("Image Cryptography");
        label3.setFont(new Font("Nimbus Sans L", Font.PLAIN, 20));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(button_decrypt)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(button_browse)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fileTextField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(label2)
                            .addGap(18, 18, 18)
                            .addComponent(textField_key2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(textField_key1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(button_encrypt))
                    .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label3)
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button_browse)
                        .addComponent(fileTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField_key1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(button_encrypt)
                    .addGap(48, 48, 48)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField_key2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(button_decrypt)
                    .addContainerGap(14, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kamal Pandey
    private JButton button_browse;
    private JTextField textField_key1;
    private JButton button_encrypt;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField_key2;
    private JButton button_decrypt;
    private JLabel label3;
    private JTextField fileTextField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void browseButtonActionPerformed(ActionEvent e) {
        // file chooser to select image file
        int fileChoose = fileChooser.showOpenDialog(this);
        if (fileChoose == JFileChooser.APPROVE_OPTION)
        {
            file = fileChooser.getSelectedFile();

            // display file path in text field
            fileTextField.setText(file.getAbsolutePath());

        }
    }

    private void encryptButtonAction(ActionEvent e){
        String key = "qwe rtgfd qwertf";
        File encryptedFile = new File("/home/jwx/Desktop/encrypted.jpg");



        try {
            Crypto.encrypt(key, file, encryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }

    private void decryptButtonAction(ActionEvent e){
        String key = "qwe rtgfd qwertf";
        File encryptedFile = new File("/home/jwx/Desktop/encrypted.jpg");
        File decryptedFile = new File("/home/jwx/Desktop/decrypted.jpg");

        try {
            Crypto.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("app");
        frame.setContentPane(new app());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


class Crypto {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void encrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }

    public static void decrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }

    private static void doCrypto(int cipherMode, String key, File inputFile,
                                 File outputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
}

class CryptoException extends Exception {

    public CryptoException() {
    }

    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}