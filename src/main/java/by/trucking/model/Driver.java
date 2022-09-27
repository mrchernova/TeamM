package by.trucking.model;

public class Driver {
    private int id;
    private String name;
    private String surname;
    private Organization organization;
    private Status status;

    public Driver() {
    }

    public Driver(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }


    public Organization getOrganization() {
        return organization;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
