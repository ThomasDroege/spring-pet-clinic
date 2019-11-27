package thomas.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import thomas.springframework.springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
