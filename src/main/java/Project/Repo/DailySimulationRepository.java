package Project.Repo;

import Project.Model.DailySimulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailySimulationRepository extends JpaRepository<DailySimulation, Long> {
}
