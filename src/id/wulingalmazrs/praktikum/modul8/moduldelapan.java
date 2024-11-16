package id.wulingalmazrs.praktikum.modul8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class moduldelapan extends Container {
    private JTextField textKel;
    private JTextField textNama;
    private JTextField textNIM;
    private JTextArea textHasil;
    private JButton submitButton;
    private JButton clearButton;
    private JCheckBox boxSyarat;
    private JLabel labelKel;
    private JLabel labelNama;
    private JLabel labelNIM;
    private JPanel panel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProgDas GUI");
        frame.setContentPane(new moduldelapan().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setResizable(true);
    }

    public moduldelapan() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textHasil.setText("Halo, saya Ketua Kelompok " +
                        textKel.getText() + " Panggil saya " +
                        textNama.getText() + " NIM saya " +
                        textNIM.getText() + "\nPercobaan GUI Modul 8 Bahasa Java Kelompok 04");
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textKel.setText("");
                textNama.setText("");
                textNIM.setText("");
                textHasil.setText("");

            }
        });

    }
}
