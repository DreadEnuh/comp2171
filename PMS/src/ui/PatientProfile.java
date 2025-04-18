package ui;

import database.DBConnection;
import patient_management.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PatientProfile extends JFrame implements ActionListener {

    private JTextField nameField;
    private JButton searchButton, homeButton;
    private JPanel infoPanel;
    private JLabel statusLabel;
    private ArrayList<patient_management.Patient> patientsList = new ArrayList<>();

    private Map<String, Patient> patientDatabase;//Yes

    public PatientProfile() {
        patientsList = DBConnection.loadPatients();
        setTitle("Patient Information Lookup");
        setSize(500, 470);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center window
        setLayout(new BorderLayout(15, 15));
        getContentPane().setBackground(new Color(245, 248, 250));

        populateMockDatabase();

        // Header
        JLabel header = new JLabel("Search Patient Information", JLabel.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 20));
        header.setForeground(new Color(50, 50, 50));
        add(header, BorderLayout.NORTH);

        // Top bar with home button
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(245, 248, 250));
        homeButton = new JButton("Home");
        homeButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        homeButton.setFocusable(false);
        // Add action later for home navigation
        topPanel.add(homeButton, BorderLayout.WEST);
        add(topPanel, BorderLayout.BEFORE_FIRST_LINE);

        // Search area
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.setBackground(new Color(245, 248, 250));
        nameField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        searchPanel.add(new JLabel("Enter Patient Name:"));
        searchPanel.add(nameField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.CENTER);

        // Info panel
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Patient Details"));
        infoPanel.setBackground(Color.WHITE);

        // Status label
        statusLabel = new JLabel(" ");
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));
        statusLabel.setForeground(Color.GRAY);

        // South section
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBackground(new Color(245, 248, 250));
        southPanel.add(statusLabel, BorderLayout.NORTH);
        southPanel.add(infoPanel, BorderLayout.CENTER);

        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void populateMockDatabase() {
        patientDatabase = new HashMap<>();
        for (Patient p:patientsList) {
            String pid = p.getPatientID();
            String fN = p.getFName();
            String mN = p.getMName();
            String lN = p.getLName();
            String gender = p.getGender();
            LocalDate dob = p.getDob();
            String email = p.getEmailAddress();
            String contact = p.getContactNo();
            String addy = p.getAddress();

            patientDatabase.put(fN, new Patient(pid, fN, mN, lN, gender, dob, email, contact, addy));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton)
            displayPatientInfo(nameField.getText().trim().toLowerCase());
    }

    private void displayPatientInfo(String name) {
        infoPanel.removeAll();

        if (patientDatabase.containsKey(name)) {
            Patient p = patientDatabase.get(name);
            infoPanel.add(createInfoLabel("First Name: " + p.getFName()));
            infoPanel.add(createInfoLabel("Middle Name: " + p.getMName()));
            infoPanel.add(createInfoLabel("Last Name: " + p.getLName()));
            infoPanel.add(createInfoLabel("Date of Birth: " + p.getDob()));
            infoPanel.add(createInfoLabel("Gender: " + p.getGender()));
            infoPanel.add(createInfoLabel("Email Address: " + p.getEmailAddress()));
            infoPanel.add(createInfoLabel("Contact Number: " + p.getContactNo()));
            infoPanel.add(createInfoLabel("Address: " + p.getAddress()));
            infoPanel.add(createInfoLabel("Number of Visits: " + p.getNumVisits()));

            infoPanel.add(createInfoLabel("Previous Visit: " + p.getMedicalHistory().getLastVisitDate()));

            statusLabel.setText("Patient information loaded successfully.");
        } else {
            statusLabel.setText("Patient not found.");
        }

        infoPanel.revalidate();
        infoPanel.repaint();
    }

    private JLabel createInfoLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PatientProfile::new);
    }
}
