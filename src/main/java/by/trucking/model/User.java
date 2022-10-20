package by.trucking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int id;
    private String login;
    private String password;
    private Role role;

    public User(int id) {
        this.id = id;
    }
    public User(int id, String password) {
        this.id = id;
        this.password = password;
    }

   //constructor for UserCreate
    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public User(String login, String password) {
        this.login = login;
        this.password = password;

    }
}
