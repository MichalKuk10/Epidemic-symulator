package Project.Controller;


import Project.Dto.SimulationRequest;
import Project.Service.SimulationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RestController
@RequestMapping("/api/simulation")
@CrossOrigin
public class SimulationController {

    private final SimulationService simulationService;

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }


    @PostMapping
    @ResponseBody
    public void simulateSimulation(@RequestBody SimulationRequest simulation){
        simulationService.calculateSimulation(simulation);
    }
}