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
    @Column(name= "populationSize")
    private Long populationSize;
    @Column(name= "initialPopulationSize")
    private Long initialPopulationSize;
    @Column(name= "markerR")
    private Double markerR;
    @Column(name= "deadRate")
    private Double deadRate;
    @Column(name= "recoveryTime")
    private Integer recoveryTime;
    @Column(name= "daysFromInfectionUntilDead")
    private Integer daysFromInfectionUntilDead;
    @Column(name= "simulationTime")
    private Integer simulationTime;





}
