package by.trucking.model;

public class StatusOrder {
    private int id;
    private String status;

    public StatusOrder(){

    }

    public StatusOrder(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
