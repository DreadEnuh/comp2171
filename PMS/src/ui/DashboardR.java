package ui;

import user_management.Receptionist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DashboardR extends JFrame implements ActionListener {
        private JButton viewDocScheduleBt;
        private JButton manageAppointmentBt;

        public DashboardR(Receptionist r) {
                JPanel footerPanel = new JPanel();
                JPanel menuPanel = new JPanel();
                JLabel idLabel = new JLabel();
                JLabel idText = new JLabel();
                JSeparator jSeparator1 = new JSeparator();
                JLabel sessionLabel = new JLabel();
                JLabel dateLabel = new JLabel();
                JLabel timeLabel = new JLabel();
                JLabel dateLb = new JLabel();
                JLabel timeLb = new JLabel();
                JPanel displayPanel = new JPanel();
                Box.Filler filler1 = new Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
                Box.Filler pageSectionW = new Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
                Box.Filler pageSectionC = new Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
                Box.Filler filler2 = new Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
                JPanel westMenuPanel = new JPanel();
                JLabel patientSectionLabel = new JLabel();
                JButton regPatientBt = new JButton();
                
                JLabel appointmentSectionLabel = new JLabel();
                JButton updatePatientBt = new JButton();
                manageAppointmentBt = new JButton();
                JLabel doctorSectionLabel = new JLabel();
                viewDocScheduleBt = new JButton();
                JSeparator northDivider = new JSeparator();
                JSeparator southDivider = new JSeparator();
                JMenuBar mainMenuBar = new JMenuBar();
                JMenu userMenu = new JMenu("User");
                JMenuItem logoutMenuItem = new JMenuItem();
                JMenu fileMenu = new JMenu("File");
                JMenuItem saveMenuItem = new JMenuItem();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("PAMS - Dashboard");
                setBackground(new java.awt.Color(0, 118, 140));
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                setFont(new java.awt.Font("Century Gothic", 0, 14)); 
                setForeground(new java.awt.Color(0, 0, 0));
                setName("dashboardFrame"); 
                setPreferredSize(new java.awt.Dimension(800, 793));

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
                menuPanel.setFont(new java.awt.Font("Century Gothic", 0, 14)); 

                idLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); 
                idLabel.setForeground(new java.awt.Color(255, 255, 255));
                idLabel.setText("User ID:");

                idText.setFont(new java.awt.Font("Century Gothic", 2, 14)); 
                idText.setText(r.getID());

                jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

                sessionLabel.setFont(new java.awt.Font("Century Gothic", 1, 16)); 
                sessionLabel.setForeground(new java.awt.Color(255, 255, 255));
                sessionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                sessionLabel.setText("Session Details");

                dateLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); 
                dateLabel.setForeground(new java.awt.Color(255, 255, 255));
                dateLabel.setText("Date:");

                timeLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); 
                timeLabel.setForeground(new java.awt.Color(255, 255, 255));
                timeLabel.setText("Time:");

                dateLb.setFont(new java.awt.Font("Century Gothic", 2, 14)); 
                dateLb.setText(LocalDate.now().toString());

                timeLb.setFont(new java.awt.Font("Century Gothic", 2, 14)); 
                timeLb.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                ActionListener updateClockAction = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                        timeLb.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                }
                };
                Timer t = new Timer(1000, updateClockAction);
                t.start();

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
                                                                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(idText)
                                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                                .addGroup(menuPanelLayout.createSequentialGroup()
                                                                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(timeLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGroup(menuPanelLayout.createSequentialGroup()
                                                                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(dateLb, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))))
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
                                        .addGap(0, 695, Short.MAX_VALUE)
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

                patientSectionLabel.setFont(new java.awt.Font("Century Gothic", 1, 16)); 
                patientSectionLabel.setForeground(new java.awt.Color(255, 255, 255));
                patientSectionLabel.setText("Patient Section");

                regPatientBt.setFont(new java.awt.Font("sansserif", 1, 12)); 
                regPatientBt.setForeground(new java.awt.Color(153, 204, 255));
                regPatientBt.setText("Register Patient");
                regPatientBt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
                regPatientBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                regPatientBt.setFocusable(false);
                regPatientBt.setName("Register Patient"); 
                regPatientBt.addActionListener(this);

                

                appointmentSectionLabel.setFont(new java.awt.Font("Century Gothic", 1, 16)); 
                appointmentSectionLabel.setForeground(new java.awt.Color(255, 255, 255));
                appointmentSectionLabel.setText("Appointment Section");

                updatePatientBt.setFont(new java.awt.Font("sansserif", 1, 12)); 
                updatePatientBt.setForeground(new java.awt.Color(153, 204, 255));
                updatePatientBt.setText("Update Patient Details");
                updatePatientBt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
                updatePatientBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                updatePatientBt.setFocusable(false);
                updatePatientBt.setName("Update Patient");
                updatePatientBt.addActionListener(this);


                manageAppointmentBt.setFont(new java.awt.Font("sansserif", 1, 12)); 
                manageAppointmentBt.setForeground(new java.awt.Color(153, 204, 255));
                manageAppointmentBt.setText("Manage Appointment");
                manageAppointmentBt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
                manageAppointmentBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                manageAppointmentBt.setFocusable(false);
                manageAppointmentBt.addActionListener(this);

                doctorSectionLabel.setFont(new java.awt.Font("Century Gothic", 1, 16)); 
                doctorSectionLabel.setForeground(new java.awt.Color(255, 255, 255));
                doctorSectionLabel.setText("Doctor Section");

                viewDocScheduleBt.setFont(new java.awt.Font("sansserif", 1, 12)); 
                viewDocScheduleBt.setForeground(new java.awt.Color(153, 204, 255));
                viewDocScheduleBt.setText("View Doctor Schedule");
                viewDocScheduleBt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
                viewDocScheduleBt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                viewDocScheduleBt.setFocusable(false);
                viewDocScheduleBt.addActionListener(this);

                northDivider.setBackground(new java.awt.Color(255, 255, 255));
                northDivider.setForeground(new java.awt.Color(255, 255, 255));

                southDivider.setBackground(new java.awt.Color(255, 255, 255));
                southDivider.setForeground(new java.awt.Color(255, 255, 255));

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
                                                                .addComponent(regPatientBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                
                                                                
                                                                .addComponent(manageAppointmentBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(viewDocScheduleBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGroup(westMenuPanelLayout.createSequentialGroup()
                                                        .addGroup(westMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(westMenuPanelLayout.createSequentialGroup()
                                                                        .addGap(17, 17, 17)
                                                                        .addComponent(appointmentSectionLabel))
                                                                .addGroup(westMenuPanelLayout.createSequentialGroup()
                                                                        .addGap(43, 43, 43)
                                                                        .addComponent(patientSectionLabel))
                                                                .addGroup(westMenuPanelLayout.createSequentialGroup()
                                                                        .addGap(43, 43, 43)
                                                                        .addComponent(doctorSectionLabel))
                                                                .addGroup(westMenuPanelLayout.createSequentialGroup()
                                                                        .addGap(76, 76, 76)
                                                                        .addComponent(northDivider, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(0, 17, Short.MAX_VALUE)))
                                        .addContainerGap())
                                .addGroup(westMenuPanelLayout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(southDivider, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                westMenuPanelLayout.setVerticalGroup(
                        westMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(westMenuPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(patientSectionLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(regPatientBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(updatePatientBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(northDivider, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(appointmentSectionLabel)
                                        

                                        .addGap(18, 18, 18)
                                        .addComponent(manageAppointmentBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(southDivider, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(doctorSectionLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(viewDocScheduleBt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                mainMenuBar.setFont(new java.awt.Font("Century Gothic", 0, 12)); 

                logoutMenuItem.setText("Logout");
                logoutMenuItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                userMenu.add(logoutMenuItem);
                mainMenuBar.add(userMenu);
                logoutMenuItem.addActionListener(this);


                saveMenuItem.setText("Save");
                saveMenuItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                fileMenu.add(saveMenuItem);
                mainMenuBar.add(fileMenu);
                saveMenuItem.addActionListener(this);

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
                System.out.println("DashboardR Class");
                new DashboardR(new Receptionist("Priscilla", "Annette", "Anderson"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {

                if (e.getSource() instanceof JMenuItem) {
                        JMenuItem clicked = (JMenuItem) e.getSource();
                        if (clicked.getText().equals("Logout")) {
                                int choice = JOptionPane.showConfirmDialog(
                                        this,
                                        "Are you sure you want to log out?",
                                        "Confirm Logout",
                                        JOptionPane.YES_NO_OPTION
                                );

                                if (choice == JOptionPane.YES_OPTION) {
                                        new LoginUI();
                                        dispose(); // close current window
                                }
                        }
                }
                if(e.getSource() == viewDocScheduleBt) {
                        new ViewDoctorSchedule();
                        dispose();
                }
                if(e.getSource() == manageAppointmentBt) {
                        new AppointmentView();
                        dispose();
                }
        }
}