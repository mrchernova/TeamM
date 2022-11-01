package by.trucking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User_old {
    private int id;
    private String login;
    private String password;
    private Role role;

    public User_old(int id) {
        this.id = id;
    }
    public User_old(int id, String password) {
        this.id = id;
        this.password = password;
    }

   //constructor for UserCreate
    public User_old(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public User_old(String login, String password) {
        this.login = login;
        this.password = password;

    }
}
