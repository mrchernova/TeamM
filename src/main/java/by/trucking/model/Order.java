package by.trucking.model;

public class Order {
    private int id;
    private String cargo;
    private float weight;
    private String departure;
    private String destination;
    private float price;
    private Client client;
    private StatusOrder statusOrder;

    public Order() {
    }

    public Order(int id, String cargo, float weight, String departure, String destination, float price/*, Client client, StatusOrder statusOrder*/) {
        this.id = id;
        this.cargo = cargo;
        this.weight = weight;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
       // this.client = client;
       // this.statusOrder = statusOrder;
        
    }

    public int getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cargo='" + cargo + '\'' +
                ", weight=" + weight +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", client=" + client +
                ", statusOrder=" + statusOrder +
                '}';
    }
}
