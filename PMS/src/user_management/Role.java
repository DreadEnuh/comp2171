package user_management;

public class Role {
    private String title;

    public Role() {}
    public Role(String title) {
        this.title = title;
    }

    // Getters

    public String getTitle() {
        return title;
    }

    // Setters

    public void setTitle(String title) {
        this.title = title;
    }
}
