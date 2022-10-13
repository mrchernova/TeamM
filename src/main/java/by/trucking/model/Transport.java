package by.trucking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transport {
    private int id;
    private String model;
    private VehicleType vehicle_type;
    private String carrying_capacity;
    private String number_plate;
    private Status status;

    
 


}
