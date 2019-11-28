package thomas.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import thomas.springframework.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

}
