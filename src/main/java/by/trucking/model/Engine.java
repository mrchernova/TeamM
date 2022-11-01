package by.trucking.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "engines")
public class Engine {

    @Id
    @Column (name = "model")
    private String model;
    @Column (name = "power")
    private int power;
}
