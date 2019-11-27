package thomas.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import thomas.springframework.springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
