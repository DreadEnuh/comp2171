package ui;

import user_management.Doctor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DashboardD extends JFrame {
    private javax.swing.JLabel appointmentSectionLabel;
    private javax.swing.JLabel aptLb;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateLb;
    private javax.swing.JPanel displayPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idText;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu logoutMenuBt;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel nextAptLb;
    private javax.swing.JSeparator northDivider;
    private javax.swing.Box.Filler pageSectionC;
    private javax.swing.Box.Filler pageSectionW;
    private javax.swing.JLabel patientSectionLabel;
    private javax.swing.JMenu saveMenuBt;
    private javax.swing.JLabel sessionLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel timeLb;
    private javax.swing.JButton updatePatientBt;
    private javax.swing.JButton viewDocScheduleBt;
    private javax.swing.JButton viewPatientHstryBt;
    private javax.swing.JPanel westMenuPanel;

    public DashboardD(Doctor d) {
        footerPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        idText = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        sessionLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        dateLb = new javax.swing.JLabel();
        timeLb = new javax.swing.JLabel();
        nextAptLb = new javax.swing.JLabel();
        aptLb = new javax.swing.JLabel();
        displayPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        pageSectionW = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        pageSectionC = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        westMenuPanel = new javax.swing.JPanel();
        patientSectionLabel = new javax.swing.JLabel();
        viewPatientHstryBt = new javax.swing.JButton();
        appointmentSectionLabel = new javax.swing.JLabel();
        updatePatientBt = new javax.swing.JButton();
        viewDocScheduleBt = new javax.swing.JButton();
        northDivider = new javax.swing.JSeparator();
        mainMenuBar = new javax.swing.JMenuBar();
        logoutMenuBt = new javax.swing.JMenu();
        saveMenuBt = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PAMS - Dashboard");
        setBackground(new java.awt.Color(0, 118, 140));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        setForeground(new java.awt.Color(0, 0, 0));
        setName("dashboardFrame"); // NOI18N

        footerPanel.setBackground(new java.awt.Color(164, 194, 244));

        javax.swing.GroupLayout footerPanelLayout = new javax.swing.GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
                footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        footerPanelLayout.setVerticalGroup(
                footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 36, Short.MAX_VALUE)
        );

        menuPanel.setBackground(new java.awt.Color(153, 204, 255));
        menuPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        menuPanel.setForeground(new java.awt.Color(255, 255, 255));
        menuPanel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        idLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(255, 255, 255));
        idLabel.setText("User ID:");

        idText.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        idText.setText(d.getID());

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        sessionLabel.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        sessionLabel.setForeground(new java.awt.Color(255, 255, 255));
        sessionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sessionLabel.setText("Session Details");

        dateLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setText("Date:");

        timeLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 255, 255));
        timeLabel.setText("Time:");

        dateLb.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        dateLb.setText(LocalDate.now().toString());

        timeLb.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        timeLb.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        ActionListener updateClockAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLb.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            }
        };
        Timer t = new Timer(1000, updateClockAction);
        t.start();

        nextAptLb.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nextAptLb.setForeground(new java.awt.Color(255, 255, 255));
        nextAptLb.setText("Next Appointment:");

        aptLb.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        aptLb.setText("Here");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSeparator1))
                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(timeLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(dateLb, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(menuPanelLayout.createSequentialGroup()
                                                                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(idText))
                                                                .addComponent(nextAptLb)
                                                                .addComponent(aptLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(sessionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sessionLabel)
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(idLabel)
                                        .addComponent(idText))
                                .addGap(18, 18, 18)
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLabel)
                                        .addComponent(dateLb))
                                .addGap(18, 18, 18)
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(timeLabel)
                                        .addComponent(timeLb))
                                .addGap(18, 18, 18)
                                .addComponent(nextAptLb)
                                .addGap(18, 18, 18)
                                .addComponent(aptLb)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        displayPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        displayPanel.setForeground(new java.awt.Color(153, 204, 255));

        pageSectionW.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 194, 244)));

        pageSectionC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 194, 244)));

        filler2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(164, 194, 244)));

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
                displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(displayPanelLayout.createSequentialGroup()
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 705, Short.MAX_VALUE)
                                .addComponent(pageSectionW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(pageSectionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        displayPanelLayout.setVerticalGroup(
                displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pageSectionW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pageSectionC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(displayPanelLayout.createSequentialGroup()
                                .addContainerGap(424, Short.MAX_VALUE)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        westMenuPanel.setBackground(new java.awt.Color(153, 204, 255));
        westMenuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        patientSectionLabel.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        patientSectionLabel.setForeground(new java.awt.Color(255, 255, 255));
        patientSectionLabel.setText("Personal Section");

        viewPatientHstryBt.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        viewPatientHstryBt.setForeground(new java.awt.Color(153, 204, 255));
        viewPatientHstryBt.setText("View Patient History");
        viewPatientHstryBt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        viewPatientHstryBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewPatientHstryBt.setName("Register Patient"); // NOI18N

        appointmentSectionLabel.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        appointmentSectionLabel.setForeground(new java.awt.Color(255, 255, 255));
        appointmentSectionLabel.setText("Patient Section");

        updatePatientBt.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        updatePatientBt.setForeground(new java.awt.Color(153, 204, 255));
        updatePatientBt.setText("Update Patient Medical Rec");
        updatePatientBt.setActionCommand("");
        updatePatientBt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        updatePatientBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatePatientBt.setName("Update Patient"); // NOI18N

        viewDocScheduleBt.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        viewDocScheduleBt.setForeground(new java.awt.Color(153, 204, 255));
        viewDocScheduleBt.setText("View My Schedule");
        viewDocScheduleBt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        viewDocScheduleBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        northDivider.setBackground(new java.awt.Color(255, 255, 255));
        northDivider.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout westMenuPanelLayout = new javax.swing.GroupLayout(westMenuPanel);
        westMenuPanel.setLayout(westMenuPanelLayout);
        westMenuPanelLayout.setHorizontalGroup(
                westMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(westMenuPanelLayout.createSequentialGroup()
                                .addGroup(westMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(westMenuPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(westMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(updatePatientBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(viewPatientHstryBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(viewDocScheduleBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(westMenuPanelLayout.createSequentialGroup()
                                                .addGroup(westMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(westMenuPanelLayout.createSequentialGroup()
                                                                .addGap(43, 43, 43)
                                                                .addComponent(patientSectionLabel))
                                                        .addGroup(westMenuPanelLayout.createSequentialGroup()
                                                                .addGap(71, 71, 71)
                                                                .addComponent(northDivider, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 17, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(westMenuPanelLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(appointmentSectionLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        westMenuPanelLayout.setVerticalGroup(
                westMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(westMenuPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(patientSectionLabel)
                                .addGap(18, 18, 18)
                                .addComponent(viewDocScheduleBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(northDivider, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(appointmentSectionLabel)
                                .addGap(18, 18, 18)
                                .addComponent(updatePatientBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(viewPatientHstryBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainMenuBar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        logoutMenuBt.setText("Logout");
        logoutMenuBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mainMenuBar.add(logoutMenuBt);

        saveMenuBt.setText("Save");
        saveMenuBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mainMenuBar.add(saveMenuBt);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(footerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(westMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(westMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(footerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("DashboardD Class");
        Doctor thisDoc = new Doctor("Sydney", "S", "Pollack", "Urology");
        new DashboardD(thisDoc);
    }
}
