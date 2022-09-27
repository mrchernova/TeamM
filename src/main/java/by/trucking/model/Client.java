package by.trucking.model;

public class Client {

    private int id;
    private String title;
    private String contact;
    private User user;

    public Client() {
    }

    public Client(int id, String title, String contact) {
        this.id = id;
        this.title = title;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public User getUser() {
        return user;
    }
}
