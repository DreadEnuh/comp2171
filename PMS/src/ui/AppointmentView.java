package ui;

import appointment_management.Appointment;
import appointment_management.Schedule;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AppointmentView extends JFrame {
    private JPanel sidebarPanel;
    private JPanel calendarPanel;
    private JPanel rightSidebar;
    private JPanel headerPanel;
    private JLabel monthLabel;
    private JButton prevMonthButton;
    private JButton nextMonthButton;
    private LocalDate currentDate;
    private List<Appointment> appointments = new ArrayList<>();
    private Schedule schedule;

    public AppointmentView() {
        setTitle("Appointment View");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        currentDate = LocalDate.now();

        schedule = new Schedule("D001", currentDate, 30, LocalTime.of(9, 0), LocalTime.of(17, 0));

        // Sidebar with buttons
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new GridLayout(3, 1, 10, 10));
        sidebarPanel.setBackground(new Color(30, 30, 30));
        sidebarPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton addButton = new JButton("Add Appointment");
        addButton.addActionListener(e -> addAppointment());
        sidebarPanel.add(styleButton(addButton));

        JButton cancelButton = new JButton("Cancel Appointment");
        cancelButton.addActionListener(e -> cancelAppointment());
        sidebarPanel.add(styleButton(cancelButton));

        JButton rescheduleButton = new JButton("Reschedule Appointment");
        rescheduleButton.addActionListener(e -> rescheduleAppointment());
        sidebarPanel.add(styleButton(rescheduleButton));

        add(sidebarPanel, BorderLayout.WEST);

        // Right sidebar for appointment list
        rightSidebar = new JPanel();
        rightSidebar.setLayout(new BoxLayout(rightSidebar, BoxLayout.Y_AXIS));
        rightSidebar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        rightSidebar.setBackground(new Color(245, 245, 245));
        add(new JScrollPane(rightSidebar), BorderLayout.EAST);

        // Header panel with navigation
        headerPanel = new JPanel(new BorderLayout());
        monthLabel = new JLabel("", SwingConstants.CENTER);
        monthLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        prevMonthButton = new JButton("<");
        prevMonthButton.addActionListener(e -> {
            currentDate = currentDate.minusMonths(1);
            populateCalendar(currentDate);
        });

        nextMonthButton = new JButton(">");
        nextMonthButton.addActionListener(e -> {
            currentDate = currentDate.plusMonths(1);
            populateCalendar(currentDate);
        });

        headerPanel.add(prevMonthButton, BorderLayout.WEST);
        headerPanel.add(monthLabel, BorderLayout.CENTER);
        headerPanel.add(nextMonthButton, BorderLayout.EAST);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(headerPanel, BorderLayout.NORTH);

        // Calendar Panel
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new GridLayout(0, 7, 10, 10));
        calendarPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        calendarPanel.setBackground(Color.WHITE);

        generateTestAppointments();
        populateCalendar(currentDate);

        add(calendarPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton styleButton(JButton button) {
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        return button;
    }

    private void generateTestAppointments() {
        schedule.addAppointment(currentDate.withDayOfMonth(5), 30, LocalTime.of(10, 0), "P001", "D001");
        schedule.addAppointment(currentDate.withDayOfMonth(12), 45, LocalTime.of(11, 30), "P002", "D002");
        schedule.addAppointment(currentDate.withDayOfMonth(12), 60, LocalTime.of(14, 0), "P003", "D003");
        schedule.addAppointment(currentDate.withDayOfMonth(22), 30, LocalTime.of(9, 0), "P004", "D004");

        updateAppointmentViews();
    }

    private void populateCalendar(LocalDate date) {
        calendarPanel.removeAll();

        YearMonth yearMonth = YearMonth.from(date);
        monthLabel.setText(yearMonth.getMonth() + " " + yearMonth.getYear());

        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : days) {
            JLabel lbl = new JLabel(day, SwingConstants.CENTER);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
            lbl.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            lbl.setOpaque(true);
            lbl.setBackground(new Color(220, 220, 220));
            calendarPanel.add(lbl);
        }

        LocalDate firstDay = yearMonth.atDay(1);
        int dayOfWeek = firstDay.getDayOfWeek().getValue() % 7;

        for (int i = 0; i < dayOfWeek; i++) {
            JPanel emptyPanel = new JPanel();
            emptyPanel.setBackground(Color.WHITE);
            calendarPanel.add(emptyPanel);
        }

        int daysInMonth = yearMonth.lengthOfMonth();
        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate current = yearMonth.atDay(day);
            JPanel dayPanel = new JPanel();
            dayPanel.setLayout(new BorderLayout());
            dayPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            dayPanel.setBackground(Color.WHITE);

            JPanel borderedPanel = new JPanel(new BorderLayout());
            borderedPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            borderedPanel.setBackground(Color.WHITE);

            JLabel dayLabel = new JLabel(String.valueOf(day));
            dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
            borderedPanel.add(dayLabel, BorderLayout.NORTH);

            JPanel apptBoxPanel = new JPanel();
            apptBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 3));
            apptBoxPanel.setOpaque(false);

            for (Appointment appt : appointments) {
                if (appt.getDate().equals(current)) {
                    JButton apptIndicator = new JButton();
                    apptIndicator.setBackground(new Color(135, 206, 250));
                    apptIndicator.setPreferredSize(new Dimension(10, 10));
                    apptIndicator.setMaximumSize(new Dimension(10, 10));
                    apptIndicator.setBorderPainted(false);
                    apptIndicator.setToolTipText("Appointment at " + appt.getStartTime());
                    apptIndicator.addActionListener(e -> showAppointmentDetails(appt));
                    apptBoxPanel.add(apptIndicator);
                }
            }

            borderedPanel.add(apptBoxPanel, BorderLayout.CENTER);
            dayPanel.add(borderedPanel, BorderLayout.CENTER);
            calendarPanel.add(dayPanel);
        }

        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    private void showAppointmentDetails(Appointment appt) {
        JOptionPane.showMessageDialog(this,
            "Appointment ID: " + appt.getAppointmentID() +
            "\nDate: " + appt.getDate() +
            "\nTime: " + appt.getStartTime() +
            "\nDuration: " + appt.getDuration() + " minutes" +
            "\nPatient ID: " + appt.getPatientID() +
            "\nDoctor ID: " + appt.getDoctorID(),
            "Appointment Details",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void addAppointment() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JTextField patientField = new JTextField();
        JTextField doctorField = new JTextField();
        JTextField dateField = new JTextField("yyyy-MM-dd");
        JTextField timeField = new JTextField("HH:mm");
        JTextField durationField = new JTextField();

        panel.add(new JLabel("Patient ID:"));
        panel.add(patientField);
        panel.add(new JLabel("Doctor ID:"));
        panel.add(doctorField);
        panel.add(new JLabel("Date (yyyy-MM-dd):"));
        panel.add(dateField);
        panel.add(new JLabel("Start Time (HH:mm):"));
        panel.add(timeField);
        panel.add(new JLabel("Duration (minutes):"));
        panel.add(durationField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Add Appointment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String patientID = patientField.getText();
                String doctorID = doctorField.getText();
                LocalDate date = LocalDate.parse(dateField.getText());
                LocalTime time = LocalTime.parse(timeField.getText());
                int duration = Integer.parseInt(durationField.getText());

                schedule.setDate(date);

                boolean success = schedule.addAppointment(date, duration, time, patientID, doctorID);
                if (success) {
                    updateAppointmentViews();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to add appointment.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cancelAppointment() {
        String appointmentID = JOptionPane.showInputDialog(this, "Enter Appointment ID to cancel:");
        if (appointmentID != null && !appointmentID.isEmpty()) {
            boolean removed = schedule.removeAppointment(appointmentID);
            if (removed) {
                updateAppointmentViews();
                JOptionPane.showMessageDialog(this, "Appointment canceled successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Appointment ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void rescheduleAppointment() {
        // Step 1: Ask for the appointment ID
        String appointmentID = JOptionPane.showInputDialog(this, "Enter Appointment ID to reschedule:");
        
        if (appointmentID == null || appointmentID.isEmpty()) {
            return;  // If user cancels or enters nothing, return
        }
    
        // Step 2: Create a panel for user input
        JPanel panel = new JPanel(new GridLayout(0, 1));
    
        JTextField dateField = new JTextField("yyyy-MM-dd");
        JTextField timeField = new JTextField("HH:mm");
        JTextField durationField = new JTextField();
    
        panel.add(new JLabel("New Date (yyyy-MM-dd):"));
        panel.add(dateField);
        panel.add(new JLabel("New Start Time (HH:mm):"));
        panel.add(timeField);
        panel.add(new JLabel("New Duration (minutes):"));
        panel.add(durationField);
    
        // Step 3: Show input dialog with the created panel
        int result = JOptionPane.showConfirmDialog(this, panel, "Reschedule Appointment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
        // Step 4: Handle the input
        if (result == JOptionPane.OK_OPTION) {
            try {
                LocalDate newDate = LocalDate.parse(dateField.getText());
                LocalTime newStartTime = LocalTime.parse(timeField.getText());
                int newDuration = Integer.parseInt(durationField.getText());
    
                // Call the rescheduleAppointment method
                boolean success = schedule.rescheduleAppointment(appointmentID, newDate, newStartTime, newDuration);
                if (success) {
                    updateAppointmentViews();
                    JOptionPane.showMessageDialog(this, "Appointment rescheduled successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to reschedule appointment. Check if the slot is available.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    

    private void updateAppointmentViews() {
        appointments = schedule.getAppointments();
        populateCalendar(currentDate);
        rightSidebar.removeAll();
        appointments.sort(Comparator.comparing(Appointment::getDate).thenComparing(Appointment::getStartTime));
        for (Appointment appt : appointments) {
            JButton apptButton = new JButton(appt.getDate() + " - ID: " + appt.getAppointmentID());
            apptButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            apptButton.addActionListener(e -> showAppointmentDetails(appt));
            rightSidebar.add(apptButton);
        }
        rightSidebar.revalidate();
        rightSidebar.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppointmentView::new);
    }
}
