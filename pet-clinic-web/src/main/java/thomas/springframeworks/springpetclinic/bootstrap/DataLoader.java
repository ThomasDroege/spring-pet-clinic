package thomas.springframeworks.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import thomas.springframework.springpetclinic.model.Owner;
import thomas.springframework.springpetclinic.model.Vet;
import thomas.springframework.springpetclinic.services.OwnerService;
import thomas.springframework.springpetclinic.services.VetService;
import thomas.springframework.springpetclinic.services.map.OwnerServiceMap;
import thomas.springframework.springpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Thomas");
        owner1.setLastName("Droege");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Max");
        owner2.setLastName("Mustermann");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Happy");
        vet2.setLastName("Feet");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
