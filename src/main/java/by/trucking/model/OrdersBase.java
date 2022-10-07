package by.trucking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrdersBase {
    private int id;
    private Order order;
    private Driver driver;
    private Transport transport;
    private Organization organization;
    private String description;




}
