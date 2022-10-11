package by.trucking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private int id;
    private String description;
    private float weight;
    private String departure;
    private String destination;
    private float price;
    private Client client;
    private Status status;

    public Order(String description, float weight) {
        this.description = description;
        this.weight = weight;
    }

    public Order(String description, float weight, String departure, String destination, float price) {
        this.description = description;
        this.weight = weight;
        this.departure = departure;
        this.destination = destination;
        this.price = price;

    }


}
