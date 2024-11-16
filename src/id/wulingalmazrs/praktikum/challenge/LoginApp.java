package id.wulingalmazrs.praktikum.challenge;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;
    private JCheckBox rememberMeCheckBox;

    public LoginApp() {
        frame = new JFrame("JAWA JAWA JAWA JAWA LOGIN WOYY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 1));

        // Username Field
        usernameField = new JTextField();
        frame.add(new JLabel("Username:"));
        frame.add(usernameField);

        // Password Field
        passwordField = new JPasswordField();
        frame.add(new JLabel("Password:"));
        frame.add(passwordField);

        // Remember Me Checkbox
        rememberMeCheckBox = new JCheckBox("Setuju dengan Syarat dan Ketentuan");
        frame.add(rememberMeCheckBox);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginAction());
        frame.add(loginButton);

        // Message Label
        messageLabel = new JLabel("", SwingConstants.CENTER);
        frame.add(messageLabel);

        frame.setVisible(true);
    }

    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (!rememberMeCheckBox.isSelected()) {
                messageLabel.setText("Harap centang 'setuju dengan syarat dan ketentuan' untuk login.");
                return;
            }
            // Hanya mengizinkan akun admin untuk login
            if (username.equals("admin") && password.equals("password")) {
                messageLabel.setText("Login berhasil!");
                // Tampilkan dashboard
                showDashboard();
            } else if (username.equals("user") && password.equals("password")) {
                messageLabel.setText("Hanya akun admin yang bisa login!");
            } else {
                messageLabel.setText("Login tidak sah, coba lagi");
            }
        }
    }

    private void showDashboard() {
        // Tutup halaman login
        frame.setVisible(false);

        JFrame dashboardFrame = new JFrame("Dashboard");
        dashboardFrame.setSize(400, 300);
        dashboardFrame.setLayout(new BorderLayout());

        // Tambahkan label dengan teks "Kami kelompok 04 berhasil"
        JLabel successLabel = new JLabel("mengg", SwingConstants.CENTER);

        // Load image and scale it to fit the dashboard window
        ImageIcon originalIcon = new ImageIcon("src/id/wulingalmazrs/praktikum/challenge/20240415_141555.jpg"); // Ganti dengan path gambar kucing
        Image scaledImage = originalIcon.getImage().getScaledInstance(dashboardFrame.getWidth(), dashboardFrame.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel catImage = new JLabel(scaledIcon);
        dashboardFrame.add(catImage, BorderLayout.CENTER);

        // Tambahkan tombol logout
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            dashboardFrame.dispose();  // Tutup dashboard
            frame.setVisible(true);   // Tampilkan kembali halaman login
        });
        dashboardFrame.add(logoutButton, BorderLayout.SOUTH);

        dashboardFrame.setVisible(true);
        dashboardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Update gambar ketika ukuran jendela berubah
        dashboardFrame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int width = dashboardFrame.getWidth();
                int height = dashboardFrame.getHeight();
                Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                catImage.setIcon(new ImageIcon(resizedImage));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginApp::new);
    }
}

