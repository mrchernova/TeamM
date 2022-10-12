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

    public Order(int id, String description, float weight, String departure, String destination, float price, Status status) {
        this.id = id;
        this.description = description;
        this.weight = weight;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.status = status;
    }

    public Order(String description, float weight, String departure, String destination, float price, Client client, Status status) {
        this.description = description;
        this.weight = weight;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.client = client;
        this.status = status;
    }

 /*оставить из-за CreateOrder*/
    public Order(String description, float weight, String departure, String destination, float price) {
        this.description = description;
        this.weight = weight;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
    }
    /*оставить из-за UpdateOrder*/
    public Order(int id, String description, float weight, String departure, String destination, float price) {
        this.id = id;
        this.description = description;
        this.weight = weight;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
    }
}
