package thomas.springframework.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import thomas.springframework.springpetclinic.model.*;
import thomas.springframework.springpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType bird = new PetType();
        bird.setName("Bird");
        PetType savedBirdType = petTypeService.save(bird);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

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

        Visit catVisit= new Visit();
        catVisit.setPet(maxPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Happy");
        vet2.setLastName("Feet");
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
