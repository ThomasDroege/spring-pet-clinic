package thomas.springframework.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import thomas.springframework.springpetclinic.model.Owner;
import thomas.springframework.springpetclinic.model.Pet;
import thomas.springframework.springpetclinic.model.PetType;
import thomas.springframework.springpetclinic.model.Vet;
import thomas.springframework.springpetclinic.services.OwnerService;
import thomas.springframework.springpetclinic.services.PetTypeService;
import thomas.springframework.springpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private  final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType bird = new PetType();
        bird.setName("Bird");
        PetType savedBirdType = petTypeService.save(bird);

        Owner owner1 = new Owner();
        owner1.setFirstName("Thomas");
        owner1.setLastName("Droege");
        owner1.setAddress("Neuhausweg 50");
        owner1.setCity("Duisburg");
        owner1.setTelephone("0203554433");

        Pet thomasPet = new Pet();
        thomasPet.setPetType(savedDogPetType);
        thomasPet.setOwner(owner1);
        thomasPet.setBirthDate(LocalDate.now());
        thomasPet.setName("Leo");
        owner1.getPets().add(thomasPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Max");
        owner2.setLastName("Mustermann");
        owner2.setAddress("Ofenbank 4");
        owner2.setCity("Essen");
        owner2.setTelephone("0201553322");

        Pet maxPet = new Pet();
        maxPet.setPetType(savedCatPetType);
        maxPet.setOwner(owner2);
        maxPet.setBirthDate(LocalDate.now());
        maxPet.setName("Moritz");
        owner2.getPets().add(maxPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Happy");
        vet2.setLastName("Feet");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
