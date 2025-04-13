package notification_service;

public class Notification {
    private String recipient;     // email or phone
    private String subject;       // email subject (can be null for SMS)
    private String messageBody;
    private NotificationType type;

    public enum NotificationType {
        EMAIL,
        SMS
    }

    public Notification(String recipient, String subject, String messageBody, NotificationType type) {
        this.recipient = recipient;
        this.subject = subject;
        this.messageBody = messageBody;
        this.type = type;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public NotificationType getType() {
        return type;
    }
}
