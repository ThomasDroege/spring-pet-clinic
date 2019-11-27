package thomas.springframework.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import thomas.springframework.springpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
