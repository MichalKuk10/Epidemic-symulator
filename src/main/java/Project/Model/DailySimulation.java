package Project.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="dailySimulation")
public class DailySimulation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name= "id")
    private Long id;
    @Column(name= "infected")
    private Integer infected;
    @Column(name= "healthyPopulation")
    private Integer healthyPopulation;
    @Column(name= "death")
    private Integer death;
    @Column(name= "recoveryPopulation")
    private Integer recoveryPopulation;


}
