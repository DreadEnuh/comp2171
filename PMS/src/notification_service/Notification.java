package notification_service;

public class Notification {
    public void sendNotification(String contact, String message) {
        // Implement the logic to send notifications to patients via SMS or email
        System.out.println("Sending reminder to " + contact + ": " + message);
    }
}
