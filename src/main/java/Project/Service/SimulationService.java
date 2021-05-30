package Project.Service;

import Project.Model.DailySimulation;
import Project.Model.Simulation;
import Project.Repo.DailySimulationRepository;
import Project.Repo.SimulationRepository;
import org.springframework.stereotype.Service;


@Service
public class SimulationService {


    private final SimulationRepository simulationRepository;
    private final DailySimulationRepository dailySimulationRepository;
  //  private final SimulationRequestMapper simulationRequestMapper;

    public SimulationService(SimulationRepository simulationRepository, DailySimulationRepository dailySimulationRepository) {
        this.simulationRepository = simulationRepository;
        this.dailySimulationRepository = dailySimulationRepository;
    }


    public void calculateSimulation(Simulation simulationRequest){
        DailySimulation firstSimulation = new DailySimulation();

        dailySimulationRepository.save(setInitialSimulationValue(simulationRequest, firstSimulation));
        DailySimulation dailySimulation = new DailySimulation();
        setInitialSimulationValue(simulationRequest, dailySimulation);

        for(int i = 1; i < simulationRequest.getSimulationTime()+1; i++){
            dailySimulation.setInfected(setInfectedPeople(simulationRequest));
            dailySimulation.setDeath(calculateHowManyPeopleHaveDied(i,
                    dailySimulation, simulationRequest));
            dailySimulation.setRecoveryPopulation(setPeopleWhoRecoveredFromInfection(i,
                    dailySimulation, simulationRequest));
            dailySimulation.setHealthyPopulation(setTotalPopulationSize(i, simulationRequest, dailySimulation));
            System.out.println(dailySimulation);

            dailySimulationRepository.save(dailySimulation);

        }

    }

    private DailySimulation setInitialSimulationValue(Simulation simulation, DailySimulation dailySimulation){
        dailySimulation.setSimulationName(simulation.getSimulationName());
        dailySimulation.setHealthyPopulation(simulation.getTotalPopulationSize());
        dailySimulation.setInfected(simulation.getInitialInfectedPopulationSize());
        dailySimulation.setDeath(0);
        dailySimulation.setRecoveryPopulation(0);
        return dailySimulation;
    }

    private int calculateHowManyPeopleHaveDied(int days, DailySimulation dailySimulation, Simulation simulation){
       if(days % simulation.getDaysFromInfectionUntilDead() == 0)  {
           dailySimulation.setDeath(dailySimulation.getDeath() +  simulation.getDeadRate());
           return dailySimulation.getDeath();
       }
       return dailySimulation.getDeath();
    }

    private int setPeopleWhoRecoveredFromInfection(int days, DailySimulation dailySimulation, Simulation simulation){
        if(days % simulation.getRecoveryTime() == 0){
            dailySimulation.setRecoveryPopulation(dailySimulation.getRecoveryPopulation() + simulation.getInitialInfectedPopulationSize());
        }
        return dailySimulation.getRecoveryPopulation();

    }
    private int setTotalPopulationSize(int days, Simulation simulation, DailySimulation dailySimulation){
        return simulation.getTotalPopulationSize() - setPeopleWhoRecoveredFromInfection(days, dailySimulation, simulation) - setInfectedPeople(simulation) - dailySimulation.getDeath();

    }

    private int setInfectedPeople(Simulation simulation){
        return (int) (simulation.getInitialInfectedPopulationSize() * simulation.getMarkerR());

    }




}
