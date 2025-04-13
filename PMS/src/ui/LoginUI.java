package ui;

import javax.swing.*;
import java.util.Objects;

public class LoginUI extends JFrame {

    public LoginUI() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Management System (PAMS) - Login");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 51, 51));
        setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));

        JPanel backgroundPanel = new javax.swing.JPanel();
        backgroundPanel.setBackground(new java.awt.Color(164, 194, 244));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        
        JPanel loginPn = new javax.swing.JPanel();
        loginPn.setBackground(new java.awt.Color(255, 255, 255));
        loginPn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.lightGray));

        JLabel iconLb = new javax.swing.JLabel();
        iconLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        iconLb.setForeground(new java.awt.Color(255, 255, 255));
        iconLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLb.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/ui/PMS_Login_Icon.png")))); // NOI18N
        iconLb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        iconLb.setFocusable(false);
        iconLb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        JLabel loginLb = new javax.swing.JLabel();
        loginLb.setBackground(new java.awt.Color(0, 0, 0));
        loginLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        loginLb.setForeground(new java.awt.Color(164, 194, 244));
        loginLb.setText("Login");

        JLabel newAccountLb = new javax.swing.JLabel();
        newAccountLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        newAccountLb.setForeground(new java.awt.Color(164, 194, 244));
        newAccountLb.setText("New Account");

        JSeparator topSeparator = new javax.swing.JSeparator();
        topSeparator.setBackground(new java.awt.Color(204, 255, 255));

        JLabel usernameLb1 = new javax.swing.JLabel();
        usernameLb1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        usernameLb1.setText("Username:");

        JTextField usernameTf1 = new javax.swing.JTextField("Enter username");
        usernameLb1.setLabelFor(usernameTf1);

        JLabel usernameLb2 = new javax.swing.JLabel();
        usernameLb2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        usernameLb2.setText("Username:");

        JTextField usernameTf2 = new javax.swing.JTextField("Enter username");
        usernameLb2.setLabelFor(usernameTf2);

        JLabel passwordLb1 = new javax.swing.JLabel();
        passwordLb1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        passwordLb1.setText("Password:");

        JPasswordField passwordField1 = new javax.swing.JPasswordField();
        passwordField1.setMinimumSize(new java.awt.Dimension(110, 22));
        passwordField1.setPreferredSize(new java.awt.Dimension(110, 22));
        passwordLb1.setLabelFor(passwordField1);

        JLabel passwordLb2 = new javax.swing.JLabel();
        passwordLb2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        passwordLb2.setText("Password:");

        JPasswordField passwordField2 = new javax.swing.JPasswordField();
        passwordField2.setMinimumSize(new java.awt.Dimension(110, 22));
        passwordField2.setPreferredSize(new java.awt.Dimension(110, 22));
        passwordLb2.setLabelFor(passwordField2);

        JLabel confirmPasswordLb = new javax.swing.JLabel();
        confirmPasswordLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        confirmPasswordLb.setText("Confirm Password:");
        confirmPasswordLb.setIconTextGap(0);

        JPasswordField confirmPasswordField = new javax.swing.JPasswordField();
        confirmPasswordField.setMinimumSize(new java.awt.Dimension(110, 22));
        confirmPasswordField.setPreferredSize(new java.awt.Dimension(110, 22));
        confirmPasswordLb.setLabelFor(confirmPasswordField);

        JSeparator baseSeparator = new javax.swing.JSeparator();
        baseSeparator.setBackground(new java.awt.Color(204, 255, 255));

        JButton loginBt = new javax.swing.JButton();
        loginBt.setBackground(new java.awt.Color(164, 194, 244));
        loginBt.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        loginBt.setForeground(new java.awt.Color(255, 255, 255));
        loginBt.setText("Login");
        loginBt.setFocusable(false);

        JButton createAccountBt = new javax.swing.JButton();
        createAccountBt.setBackground(new java.awt.Color(164, 194, 244));
        createAccountBt.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        createAccountBt.setForeground(new java.awt.Color(255, 255, 255));
        createAccountBt.setText("Create Account");
        createAccountBt.setFocusable(false);

        JLabel copyrightLb = new javax.swing.JLabel();
        copyrightLb.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        copyrightLb.setText("Copyright 2025");

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
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
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
                                .addGap(85, 85, 85)
                                .addComponent(baseSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginBt)
                                        .addComponent(createAccountBt))
                                .addGap(7, 7, 7))
        );

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
                                                .addGap(236, 236, 236)
                                                .addComponent(iconLb, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(41, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
                backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(iconLb, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(loginPn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(copyrightLb)
                                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("LoginUI");
        new LoginUI();
    }
}
