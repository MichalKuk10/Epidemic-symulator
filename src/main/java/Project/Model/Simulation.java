package Project.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="simulation")
public class Simulation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name= "id")
    private Long id;
    @Column(name= "simulationName")
    private String simulationName;
    @Column(name= "totalPopulationSize")
    private Integer totalPopulationSize;
    @Column(name= "initialInfectedPopulationSize")
    private Integer initialInfectedPopulationSize;
    @Column(name= "markerR")
    private Double markerR;
    @Column(name= "deadRate")
    private Integer deadRate;
    @Column(name= "recoveryTime")
    private Integer recoveryTime;
    @Column(name= "daysFromInfectionUntilDead")
    private Integer daysFromInfectionUntilDead;
    @Column(name= "simulationTime")
    private Integer simulationTime;





}
