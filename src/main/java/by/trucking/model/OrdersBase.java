package by.trucking.model;

public class OrdersBase {
    private int id;
    private Order order;
    private Driver driver;
    private Transport transport;
    private Organization organization;
    private String description;

    public OrdersBase() {
    }

    public OrdersBase(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Driver getDriver() {
        return driver;
    }

    public Transport getTransport() {
        return transport;
    }

    public Organization getOrganization() {
        return organization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
