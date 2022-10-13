package by.trucking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Organization {

    private int id;
    private String title;
    private Contact contact;
    private Driver driver;
    private Transport transport;
    private User user;

  
}
