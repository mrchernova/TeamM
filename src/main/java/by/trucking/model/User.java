package by.trucking.model;

public class User {
    private int id;
    private String login;
    private String password;
    private Role role;



    public User(){
    }

    User (int id, String login, String password){
        this.id = id;
        this.login = login;
        this.password = password;
    }


    public int getId(){
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
