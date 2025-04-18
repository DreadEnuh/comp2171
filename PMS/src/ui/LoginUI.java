package ui;

import database.DBConnection;
import user_management.AuthService;
import user_management.Doctor;
import user_management.Receptionist;
import user_management.User;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;
import java.util.Objects;

public class LoginUI extends JFrame implements ActionListener {
    private final AuthService authService;
    private JPanel backgroundPanel;
    private  JSeparator baseSeparator;
    private  JLabel confirmPasswordLb;
    private  JPasswordField confirmPasswordField;
    private  JLabel copyrightLb;
    private  JButton createAccountBt;
    private  JLabel iconLb;
    private  JPasswordField passwordField1;
    private  JButton loginBt;
    private  JLabel loginLb;
    private  JPanel loginPn;
    private  JLabel newAccountLb;
    private  JPasswordField passwordField2;
    private  JLabel passwordLb1;
    private  JLabel passwordLb2;
    private  JSeparator topSeparator;
    private  JLabel usernameLb1;
    private  JLabel usernameLb2;
    private  JTextField usernameTf1;
    private  JTextField usernameTf2;
    private  Box.Filler verticalDiv;


    public LoginUI(AuthService authService) {
        initComponents();
        addListeners();
        setVisible(true);
        this.authService = authService;
    }

    public void initComponents() {
        backgroundPanel = new  JPanel();
        loginPn = new  JPanel();
        usernameTf2 = new  JTextField();
        passwordField2 = new  JPasswordField();
        confirmPasswordField = new  JPasswordField();
        usernameTf1 = new  JTextField();
        passwordField1 = new  JPasswordField();
        loginLb = new  JLabel();
        newAccountLb = new  JLabel();
        usernameLb1 = new  JLabel();
        passwordLb1 = new  JLabel();
        topSeparator = new  JSeparator();
        usernameLb2 = new  JLabel();
        passwordLb2 = new  JLabel();
        confirmPasswordLb = new  JLabel();
        baseSeparator = new  JSeparator();
        loginBt = new  JButton();
        createAccountBt = new  JButton();
        verticalDiv = new  Box.Filler(new java.awt.Dimension(0, 50), new java.awt.Dimension(0, 50), new java.awt.Dimension(32767, 50));
        iconLb = new  JLabel();
        copyrightLb = new  JLabel();

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Management System (PAMS) - Login");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 51, 51));
        setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));

        backgroundPanel.setBackground(new java.awt.Color(164, 194, 244));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        loginPn.setBackground(new java.awt.Color(255, 255, 255));
        loginPn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        usernameTf2.setText("");

        passwordField2.setMinimumSize(new java.awt.Dimension(110, 22));
        passwordField2.setPreferredSize(new java.awt.Dimension(110, 22));

        confirmPasswordField.setMinimumSize(new java.awt.Dimension(110, 22));
        confirmPasswordField.setPreferredSize(new java.awt.Dimension(110, 22));

        usernameTf1.setText("");

        passwordField1.setMinimumSize(new java.awt.Dimension(110, 22));
        passwordField1.setPreferredSize(new java.awt.Dimension(110, 22));


        loginLb.setBackground(new java.awt.Color(0, 0, 0));
        loginLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        loginLb.setForeground(new java.awt.Color(164, 194, 244));
        loginLb.setLabelFor(usernameTf1);
        loginLb.setHorizontalAlignment(SwingConstants.CENTER);
        loginLb.setBounds(100, 10, 200, 30);
        loginLb.setText("Login");

        newAccountLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        newAccountLb.setForeground(new java.awt.Color(164, 194, 244));
        newAccountLb.setHorizontalAlignment(SwingConstants.CENTER);
        newAccountLb.setBounds(100, 250, 200, 30);
        newAccountLb.setText("New Account");

        usernameLb1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        usernameLb1.setText("Username:");

        passwordLb1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        passwordLb1.setText("Password:");

        topSeparator.setBackground(new java.awt.Color(204, 255, 255));

        usernameLb2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        usernameLb2.setText("Username:");

        passwordLb2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        passwordLb2.setText("Password:");

        confirmPasswordLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        confirmPasswordLb.setText("Confirm Password:");
        confirmPasswordLb.setIconTextGap(0);

        baseSeparator.setBackground(new java.awt.Color(204, 255, 255));

        loginBt.setBackground(new java.awt.Color(164, 194, 244));
        loginBt.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        loginBt.setForeground(new Color(33, 33, 33));
        loginBt.setText("Login");
        loginBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBt.setFocusable(false);


        createAccountBt.setBackground(new java.awt.Color(164, 194, 244));
        createAccountBt.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        createAccountBt.setForeground(new Color(33, 33, 33));
        createAccountBt.setText("Create Account");
        createAccountBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createAccountBt.setFocusable(false);

        verticalDiv.setBackground(new java.awt.Color(204, 204, 204));
        verticalDiv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        javax.swing.GroupLayout loginPnLayout = new javax.swing.GroupLayout(loginPn);
        loginPn.setLayout(loginPnLayout);
        loginPnLayout.setHorizontalGroup(
                loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPnLayout.createSequentialGroup()
                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(usernameLb1)
                                                        .addComponent(passwordLb1))
                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(confirmPasswordLb)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(58, 58, 58))
                                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(usernameTf1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(verticalDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                                                .addComponent(usernameLb2)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(usernameTf2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                                                .addComponent(passwordLb2)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addContainerGap())
                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addComponent(loginLb, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(newAccountLb)
                                                .addGap(91, 91, 91))))
                        .addComponent(topSeparator)
                        .addComponent(baseSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(loginPnLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(loginBt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createAccountBt)
                                .addGap(86, 86, 86))
        );
        loginPnLayout.setVerticalGroup(
                loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPnLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newAccountLb, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(loginLb, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(topSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(usernameTf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(usernameTf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(usernameLb1)
                                                        .addComponent(usernameLb2))
                                                .addGap(35, 35, 35)
                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(passwordLb2)
                                                        .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordLb1)
                                                        .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(confirmPasswordLb)
                                                        .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(85, 85, 85))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPnLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(verticalDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(baseSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginBt)
                                        .addComponent(createAccountBt))
                                .addGap(7, 7, 7))
        );

        iconLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        iconLb.setForeground(new java.awt.Color(255, 255, 255));
        iconLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLb.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("PMS_Login_Icon.png")))); // NOI18N
        iconLb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        iconLb.setFocusable(false);
        iconLb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        copyrightLb.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        copyrightLb.setText("Copyright 2025");

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
                backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                                .addGap(259, 259, 259)
                                                .addComponent(copyrightLb, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(loginPn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                                .addGap(199, 199, 199)
                                                .addComponent(iconLb, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(41, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
                backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(iconLb, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(loginPn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(copyrightLb)
                                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        backgroundPanel.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void addListeners() {
        usernameTf1.addFocusListener(new MyFocusListener());
        usernameTf2.addFocusListener(new MyFocusListener());
        passwordField1.addActionListener(this);
        passwordField2.addActionListener(this);
        confirmPasswordField.addActionListener(this);
        createAccountBt.addActionListener(this);
        loginBt.addActionListener(this);
    }

    private class MyFocusListener extends FocusAdapter {
        @Override
        public void focusGained(FocusEvent e) {
            JTextComponent component = (JTextComponent) e.getSource();
            component.selectAll();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==usernameTf1) {
            System.out.println(1);
        }
        else if (e.getSource()==usernameTf2) {
            System.out.println(2);
        }
        else if (e.getSource()==passwordField1) {
            System.out.println("p1");
        }
        else if (e.getSource()==passwordField2) {
            System.out.println("p2");
        }
        else if (e.getSource()==confirmPasswordField) {
            System.out.println("p3");
        }
        else if (e.getSource()==loginBt) {
            System.out.println("Login pressed");
            loginBtAction();

        }
        else if (e.getSource()==createAccountBt) {
            System.out.println("Create account pressed");
        }
    }

    public void loginBtAction() {
        String usernameIn = usernameTf1.getText();
        String passwordIn = Arrays.toString(passwordField1.getPassword());

        if (usernameIn.isEmpty()) {
            usernameTf1.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Please enter a username!";
            String error = "No username provided";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
        } else if (!AuthService.validateUsernameFormat(usernameIn)) {
            usernameTf1.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Username has invalid format!";
            String error = "Invalid format";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
        } else if (passwordIn.isEmpty()) {
            passwordField1.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Please enter a password!";
            String error = "No password provided";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
        } else if (!AuthService.validatePasswordFormat(passwordIn)) {
            passwordField1.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Password has invalid format!";
            String error = "Invalid format";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
            passwordField1.setText("");
        } else if ( (!authService.verifyUsername(usernameIn)) || (!authService.verifyPassphrase(usernameIn, passwordIn)) ) {
            String msg = "One or both of the provided credentials is incorrect!";
            String error = "Incorrect credential(s)";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
            usernameTf1.setText("");
            passwordField1.setText("");
        } else if ( (authService.verifyUsername(usernameIn)) || (authService.verifyPassphrase(usernameIn, passwordIn)) ) {
            System.out.println("Verification Success"); // Debug
            User user = DBConnection.loadUser(usernameIn);
            String sessionID = user.getID();
            if (sessionID.charAt(0) == 'D') {
                Doctor d = authService.getDdb().getDoctorByID(sessionID);
                new DashboardD(authService, d);
                dispose();
            } else if (sessionID.charAt(0) == 'R') {
                Receptionist r = authService.getRdb().getReceptionistByID(sessionID);
                new DashboardR(authService, r);
                dispose();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("LoginUI");
        AuthService authService = new AuthService();
        new LoginUI(authService);
    }
}