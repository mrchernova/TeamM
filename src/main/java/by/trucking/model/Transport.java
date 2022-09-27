package by.trucking.model;

public class Transport {
    private int id;
    private String model;
    private String vehicle_type;
    private String carrying_capacity;
    private String number_plate;
    private Status status;
    private Organization organization;

    public Transport() {
    }

    public Transport(int id, String model, String vehicle_type, String carrying_capacity, String number_plate) {
        this.id = id;
        this.model = model;
        this.vehicle_type = vehicle_type;
        this.carrying_capacity = carrying_capacity;
        this.number_plate = number_plate;
    }

    public int getId() {
        return id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getCarrying_capacity() {
        return carrying_capacity;
    }

    public void setCarrying_capacity(String carrying_capacity) {
        this.carrying_capacity = carrying_capacity;
    }

    public String getNumber_plate() {
        return number_plate;
    }

    public void setNumber_plate(String number_plate) {
        this.number_plate = number_plate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Organization getOrganization() {
        return organization;
    }


}
