package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDoctorSchedule extends JFrame implements ActionListener {
    private JPanel backgroundPanel;
    private JLabel titleLb;
    private JLabel doctorNameLb;
    private JTextField doctorNameTf;
    private JButton searchBt;
    private JTable scheduleTable;
    private JScrollPane tableScrollPane;

    public ViewDoctorSchedule() {
        initComponents();
        setVisible(true);
    }

    public void initComponents() {
        backgroundPanel = new JPanel();
        titleLb = new JLabel("View Doctor's Schedule");
        doctorNameLb = new JLabel("Enter Doctor's Name:");
        doctorNameTf = new JTextField();
        searchBt = new JButton("Search");
        scheduleTable = new JTable();
        tableScrollPane = new JScrollPane(scheduleTable);



        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Management System (PAMS) - View Schedule");
        setAlwaysOnTop(true);
        setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12)); 
        setForeground(new Color(255, 255, 255));

        backgroundPanel.setBackground(new Color(164, 194, 244));
        backgroundPanel.setPreferredSize(new Dimension(600, 600));

        titleLb.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
        titleLb.setForeground(new Color(0, 0, 0)); // Dark text for better visibility
        titleLb.setHorizontalAlignment(SwingConstants.CENTER);

        doctorNameLb.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
        doctorNameLb.setForeground(new Color(0, 0, 0)); // Dark text for better visibility

        searchBt.setBackground(new java.awt.Color(0, 0, 0));
        searchBt.setForeground(new java.awt.Color(164, 194, 244));

        doctorNameTf.setPreferredSize(new Dimension(250, 30));
        doctorNameTf.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));

        // Adjust the button size to match the input field
        searchBt.setPreferredSize(new Dimension(250, 40));
        searchBt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14)); 
        searchBt.setBackground(new java.awt.Color(0, 0, 0));
        searchBt.setForeground(new java.awt.Color(0,0, 0));
        searchBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchBt.setFocusable(false);
        searchBt.addActionListener(this);

        scheduleTable.setModel(new DefaultTableModel(
                new Object [][] {},
                new String [] {"Time", "Patient Name"}
        ));
        scheduleTable.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
        scheduleTable.setSelectionBackground(new Color(204, 204, 204));
        scheduleTable.setSelectionForeground(new Color(0, 0, 0));
        tableScrollPane.setPreferredSize(new Dimension(500, 200));

        GroupLayout layout = new GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(titleLb, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(doctorNameLb)
                            .addGap(18, 18, 18)
                            .addComponent(doctorNameTf, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                        .addComponent(searchBt, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tableScrollPane, GroupLayout.Alignment.CENTER, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(titleLb)
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(doctorNameLb)
                        .addComponent(doctorNameTf, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addComponent(searchBt)
                    .addGap(40, 40, 40)
                    .addComponent(tableScrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30))
        );

        getContentPane().add(backgroundPanel);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBt) {
            String doctorName = doctorNameTf.getText();
            if (doctorName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a doctor's name.");
            } else {
                // Here you would query the doctor schedule based on the entered name
                // Sample data is added to demonstrate functionality
                DefaultTableModel model = (DefaultTableModel) scheduleTable.getModel();
                model.setRowCount(0);  // Clear existing data

                // Sample data for the table
                model.addRow(new Object[]{"10:00 AM", "John Doe"});
                model.addRow(new Object[]{"11:00 AM", "Jane Smith"});
                model.addRow(new Object[]{"1:00 PM", "Michael Johnson"});
            }
        }
    }

    public static void main(String[] args) {
        new ViewDoctorSchedule();
    }
}
