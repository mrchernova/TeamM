package by.trucking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver {
    private int id;
    private String name;
    private String surname;
    private Organization organization;
    private Status status;

   
}
