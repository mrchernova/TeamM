package by.trucking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {

    private int id;
    private String contact;
    private String title;
    private User user;

    public Client(int id) {
        this.id = id;
    }
    //public Client(String title) {        this.title = title;    } // ??
}
