package arrupe.springdependencyinjection.repository;

import arrupe.springdependencyinjection.model.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {
}
