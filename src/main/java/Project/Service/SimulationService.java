package Project.Service;

import Project.Dto.SimulationRequest;
import Project.Mapper.SimulationRequestMapper;
import Project.Repo.SimulationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SimulationService {

    private final SimulationRepository simulationRepository;
    private final SimulationRequestMapper simulationRequestMapper;

    public SimulationService(SimulationRepository simulationRepository, SimulationRequestMapper simulationRequestMapper) {
        this.simulationRepository = simulationRepository;
        this.simulationRequestMapper = simulationRequestMapper;
    }


    public void calculateSimulation(SimulationRequest simulationRequest){

        simulationRepository.save(simulationRequestMapper.toEntity(simulationRequest));
    }




}
