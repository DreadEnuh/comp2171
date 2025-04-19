package ui;

import database.DBConnection;
import user_management.AuthService;
import user_management.Doctor;
import user_management.Receptionist;
import user_management.User;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class LoginUI extends JFrame implements ActionListener {
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JSeparator baseSeparator;
    private javax.swing.JButton changePasswordBt;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLb;
    private javax.swing.JLabel copyrightLb;
    private javax.swing.JPasswordField currPasswordField;
    private javax.swing.JLabel currPasswordLb;
    private javax.swing.JLabel iconLb;
    private javax.swing.JButton loginBt;
    private javax.swing.JLabel loginLb;
    private javax.swing.JPasswordField loginPasswordField;
    private javax.swing.JPanel loginPn;
    private javax.swing.JLabel newAccountLb;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JLabel newPasswordLb;
    private javax.swing.JLabel passwordLb1;
    private javax.swing.JSeparator topSeparator;
    private javax.swing.JLabel userIDLb1;
    private javax.swing.JLabel userIDLb2;
    private javax.swing.JTextField userIDTf;
    private javax.swing.JTextField userIDTf2;
    private javax.swing.Box.Filler verticalDiv;


    public LoginUI() {
        initComponents();
        addListeners();
        setVisible(true);
    }

    public void initComponents() {
        backgroundPanel = new JPanel();
        loginPn = new JPanel();
        currPasswordField = new javax.swing.JPasswordField();
        newPasswordField = new javax.swing.JPasswordField();
        userIDTf = new javax.swing.JTextField();
        userIDTf2 = new JTextField();
        loginPasswordField = new javax.swing.JPasswordField();
        loginLb = new javax.swing.JLabel();
        newAccountLb = new javax.swing.JLabel();
        userIDLb1 = new javax.swing.JLabel();
        passwordLb1 = new javax.swing.JLabel();
        topSeparator = new javax.swing.JSeparator();
        userIDLb2 = new javax.swing.JLabel();
        currPasswordLb = new javax.swing.JLabel();
        newPasswordLb = new javax.swing.JLabel();
        baseSeparator = new javax.swing.JSeparator();
        loginBt = new javax.swing.JButton();
        changePasswordBt = new javax.swing.JButton();
        confirmPasswordLb = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        verticalDiv = new javax.swing.Box.Filler(new java.awt.Dimension(0, 15), new java.awt.Dimension(0, 15), new java.awt.Dimension(32767, 15));
        iconLb = new javax.swing.JLabel();
        copyrightLb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Management System (PAMS) - Login");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 51, 51));
        setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));

        backgroundPanel.setBackground(new java.awt.Color(164, 194, 244));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(600, 600));

        loginPn.setBackground(new java.awt.Color(255, 255, 255));
        loginPn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        userIDTf2.setText("Enter user ID");

        currPasswordField.setMinimumSize(new java.awt.Dimension(110, 22));
        currPasswordField.setPreferredSize(new java.awt.Dimension(110, 22));

        newPasswordField.setMinimumSize(new java.awt.Dimension(110, 22));
        newPasswordField.setPreferredSize(new java.awt.Dimension(110, 22));

        userIDTf.setText("Enter user ID");

        loginPasswordField.setMinimumSize(new java.awt.Dimension(110, 22));
        loginPasswordField.setPreferredSize(new java.awt.Dimension(110, 22));

        loginLb.setBackground(new java.awt.Color(0, 0, 0));
        loginLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        loginLb.setForeground(new java.awt.Color(164, 194, 244));
        loginLb.setLabelFor(userIDTf);
        loginLb.setText("Login");

        newAccountLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        newAccountLb.setForeground(new java.awt.Color(164, 194, 244));
        newAccountLb.setText("Change Password");

        userIDLb1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        userIDLb1.setText("User ID:");

        passwordLb1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        passwordLb1.setText("Password:");

        topSeparator.setBackground(new java.awt.Color(204, 255, 255));

        userIDLb2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        userIDLb2.setText("User ID:");

        currPasswordLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        currPasswordLb.setText("Current Password:");

        newPasswordLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        newPasswordLb.setText("New Password:");
        newPasswordLb.setIconTextGap(0);

        baseSeparator.setBackground(new java.awt.Color(204, 255, 255));

        loginBt.setBackground(new java.awt.Color(164, 194, 244));
        loginBt.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        loginBt.setForeground(new java.awt.Color(255, 255, 255));
        loginBt.setText("Login");
        loginBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBt.setFocusable(false);

        changePasswordBt.setBackground(new java.awt.Color(164, 194, 244));
        changePasswordBt.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        changePasswordBt.setForeground(new java.awt.Color(255, 255, 255));
        changePasswordBt.setText("Confirm Change");
        changePasswordBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changePasswordBt.setFocusable(false);

        confirmPasswordLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        confirmPasswordLb.setText("Confirm Password:");
        confirmPasswordLb.setIconTextGap(0);

        confirmPasswordField.setMinimumSize(new java.awt.Dimension(110, 22));
        confirmPasswordField.setPreferredSize(new java.awt.Dimension(110, 22));

        verticalDiv.setBackground(new java.awt.Color(204, 204, 204));
        verticalDiv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout loginPnLayout = new javax.swing.GroupLayout(loginPn);
        loginPn.setLayout(loginPnLayout);
        loginPnLayout.setHorizontalGroup(
                loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPnLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPnLayout.createSequentialGroup()
                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(userIDLb1)
                                                        .addComponent(passwordLb1))
                                                .addGap(10, 10, 10)
                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(loginPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(userIDTf))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(verticalDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                                                .addComponent(userIDLb2)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(userIDTf2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                                                .addComponent(currPasswordLb)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(currPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(confirmPasswordLb, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(newPasswordLb, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(34, 34, 34))
                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addComponent(loginLb, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                                                .addComponent(newAccountLb)
                                                .addGap(91, 91, 91))))
                        .addComponent(topSeparator)
                        .addComponent(baseSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(loginPnLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(loginBt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(changePasswordBt)
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
                                                        .addComponent(userIDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(userIDTf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(userIDLb1)
                                                        .addComponent(userIDLb2))
                                                .addGap(35, 35, 35)
                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(currPasswordLb)
                                                        .addComponent(currPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordLb1)
                                                        .addComponent(loginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(newPasswordLb)
                                                        .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(confirmPasswordLb)))
                                        .addGroup(loginPnLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(verticalDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(baseSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(loginPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(loginBt)
                                        .addComponent(changePasswordBt))
                                .addGap(7, 7, 7))
        );

        iconLb.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        iconLb.setForeground(new java.awt.Color(255, 255, 255));
        iconLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("PMS_Login_Icon.png"))); // NOI18N
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
                                                .addGap(197, 197, 197)
                                                .addComponent(iconLb, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                                .addGap(269, 269, 269)
                                                .addComponent(copyrightLb, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(loginPn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
                backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(iconLb)
                                .addGap(18, 18, 18)
                                .addComponent(loginPn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(copyrightLb)
                                .addContainerGap())
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
        userIDTf.addFocusListener(new MyFocusListener());
        loginPasswordField.addActionListener(this);

        userIDTf2.addFocusListener(new MyFocusListener());
        currPasswordField.addActionListener(this);
        newPasswordField.addActionListener(this);
        confirmPasswordField.addActionListener(this);
        
        loginBt.addActionListener(this);
        changePasswordBt.addActionListener(this);

        userIDTf.addKeyListener(new MyKeyListener());
        userIDTf2.addKeyListener(new MyKeyListener());
    }

    private class MyKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            JTextField component = (JTextField) e.getSource();

            int pos = component.getCaretPosition();
            int location = e.getKeyLocation();
            component.setText(component.getText().toUpperCase());
            component.setCaretPosition(pos);

            if (!component.getText().isEmpty()) {
                if (component.getText().charAt(0) == 'D') {
                    if ((pos == 2) && (location == KeyEvent.KEY_LOCATION_STANDARD)) {
                        component.setText(component.getText() + "-");
                    } else if ( (pos == 3) && (e.getKeyCode() == 8) ) {
                        component.setText(component.getText().substring(0, 2));
                    }
                } else if (component.getText().charAt(0) == 'R') {
                    if ( (pos == 2) && (location == KeyEvent.KEY_LOCATION_STANDARD) && !(e.getKeyCode() == 8) ) {
                        component.setText(component.getText().replaceFirst("R", "R-"));
                    } else if ( (pos == 2) && (e.getKeyCode() == 8) ) {
                        component.setText(component.getText().substring(0, 1));
                    }
                }
            }
        }
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
        if (e.getSource()==userIDTf) {
            System.out.println(1);
        }
        else if (e.getSource()==userIDTf2) {
            System.out.println(2);
        }
        else if (e.getSource()==loginPasswordField) {
            System.out.println("p1");
        }
        else if (e.getSource()==currPasswordField) {
            System.out.println("p2");
        }
        else if (e.getSource()==confirmPasswordField) {
            System.out.println("p3");
        }
        else if (e.getSource()==loginBt) {
            System.out.println("Login pressed");
            loginBtAction();
        }
        else if (e.getSource()==changePasswordBt) {
            System.out.println("Create account pressed");
        }
    }

    public void loginBtAction() {
        String userIDIn = userIDTf.getText();
        String arrayString = Arrays.toString(loginPasswordField.getPassword()).replaceAll(", ", "");
        String passwordIn = arrayString.replace("[", "").replace("]", "");

        if (userIDIn.isEmpty()) {
            userIDTf.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Please enter a username!";
            String error = "No username provided";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
        } else if (!AuthService.validateUserIDFormat(userIDIn)) {
            userIDTf.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Username has invalid format!";
            String error = "Invalid format";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
        } else if (passwordIn.isEmpty()) {
            loginPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Please enter a password!";
            String error = "No password provided";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
        } else if (!AuthService.validatePasswordFormat(passwordIn)) {
            loginPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Password has invalid format!";
            String error = "Invalid format";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
            loginPasswordField.setText("");
        } else if ( (!AuthService.verifyUserID(userIDIn)) || (!AuthService.verifyPassphrase(userIDIn, passwordIn)) ) {
            String msg = "One or both of the provided credentials is incorrect!";
            String error = "Incorrect credential(s)";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
            userIDTf.setText("");
            loginPasswordField.setText("");
        } else if ( (AuthService.verifyUserID(userIDIn)) || (AuthService.verifyPassphrase(userIDIn, passwordIn)) ) {
            System.out.println("Verification Success"); // Debug
            User user = DBConnection.loadUser(userIDIn);
            assert(user != null);
            String sessionID = user.getID();
            if (sessionID.charAt(0) == 'D') {
                Doctor d = AuthService.getDdb().getDoctorByID(sessionID);
                new DashboardD(d);
                dispose();
            } else if (sessionID.charAt(0) == 'R') {
                Receptionist r = AuthService.getRdb().getReceptionistByID(sessionID);
                new DashboardR(r);
                dispose();
            }
        }

    }

    public void createAccountBtAction() {
        String userIDIn = userIDTf2.getText();
        String currentPasswordIn = Arrays.toString(currPasswordField.getPassword()).replaceAll(", ", "").replace("[", "").replace("]", "");
        String newPasswordIn = Arrays.toString(newPasswordField.getPassword());
        String newConfirmedPasswordIn = Arrays.toString(confirmPasswordField.getPassword());

        if (userIDIn.isEmpty()) {
            userIDTf2.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Please enter a username!";
            String error = "No username provided";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
        } else if (!AuthService.validateUserIDFormat(userIDIn)) {
            userIDTf2.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Username has invalid format!";
            String error = "Invalid format";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
        } else if (currentPasswordIn.isEmpty()) {
            loginPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Please enter a password!";
            String error = "No password provided";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
        } else if (!AuthService.validatePasswordFormat(currentPasswordIn)) {
            loginPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Password has invalid format!";
            String error = "Invalid format";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
            loginPasswordField.setText("");
        } else if (newPasswordIn.isEmpty()) {
            newPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Please enter a new password!";
            String error = "No new password provided";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
        } else if (newConfirmedPasswordIn.isEmpty()) {
            confirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Please enter your new password again!";
            String error = "No confirmation password provided";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
        } else if (!AuthService.validatePasswordFormat(newPasswordIn)) {
            newPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "New password has invalid format!";
            String error = "Invalid format";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
            newPasswordField.setText("");
        } else if (!newPasswordIn.equals(newConfirmedPasswordIn)) {
            newPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            confirmPasswordField.setBorder(BorderFactory.createLineBorder(Color.RED));
            String msg = "Passwords do not match!";
            String error = "Passwords mismatch";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
            confirmPasswordField.setText("");
            newPasswordField.setText("");
        } else if ( (!AuthService.verifyUserID(userIDIn)) || (!AuthService.verifyPassphrase(userIDIn, currentPasswordIn)) ) {
            String msg = "One or both of the provided credentials is incorrect!";
            String error = "Incorrect credential(s)";
            JOptionPane.showMessageDialog(this, msg, error, JOptionPane.ERROR_MESSAGE);
            userIDTf2.setText("");
            loginPasswordField.setText("");
        } else if ( (AuthService.verifyUserID(userIDIn)) && (AuthService.verifyPassphrase(userIDIn, currentPasswordIn)) ) {
            User user = DBConnection.loadUser(userIDIn);
            int option = JOptionPane.showConfirmDialog(this, "Would you like to save the changes?", "Save new password", JOptionPane.YES_NO_OPTION);
            System.out.println(option); //cDebug

            AuthService.updateUser(user.getID(), user.getID(), newPasswordIn);
            JOptionPane.showConfirmDialog(this, "Would you like to login?", "Continue login", JOptionPane.YES_NO_OPTION);
        }
    }

    public static void main(String[] args) {
        System.out.println("LoginUI");
    }
}