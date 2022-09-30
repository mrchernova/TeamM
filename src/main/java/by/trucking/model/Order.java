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


    public Order(int id, String cargo, float weight, String departure, String destination, float price) {
        this.id = id;
        this.cargo = cargo;
        this.weight = weight;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
       
    }

    public Order(int id, String cargo) {
        this.id = id;
        this.cargo = cargo;
    }
}
