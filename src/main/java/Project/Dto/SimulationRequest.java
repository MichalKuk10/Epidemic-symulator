package Project.Dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class SimulationRequest {

    private String simulationName;
    private Long populationSize;
    private Long initialPopulationSize;
    private Double markerR;
    private Double deadRate;
    private Integer recoveryTime;
    private Integer daysFromInfectionUntilDead;
    private Integer simulationTime;
}
