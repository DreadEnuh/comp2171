import ui.LoginUI;
import user_management.AuthService;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        new LoginUI(authService);
    }
}
