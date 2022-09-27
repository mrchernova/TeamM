package by.trucking.model;

public class Organization {

    private int id;
    private String title;
    private User user;

    public Organization(){

    }

    public Organization(int id, String title, User user) {
        this.id = id;
        this.title = title;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

}
