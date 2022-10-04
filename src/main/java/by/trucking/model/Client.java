package by.trucking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {

    private int id;
    private String title;
    private String contact;
    private User user;

    public Client(int id) {
        this.id = id;
    }
}
