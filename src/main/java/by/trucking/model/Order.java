package by.trucking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private int id;
    private String cargo;
    private float weight;
    private String departure;
    private String destination;
    private float price;
    private Client client;
    private Status status;



}
