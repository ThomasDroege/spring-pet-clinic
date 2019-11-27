package thomas.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import thomas.springframework.springpetclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
