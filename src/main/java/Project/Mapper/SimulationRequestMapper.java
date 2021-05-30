package Project.Mapper;

import Project.Dto.SimulationRequest;
import Project.Model.Simulation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimulationRequestMapper {

    Simulation toEntity(SimulationRequest simulationRequest);

}
