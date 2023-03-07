package es.ordenadores.laptop.services;

import es.ordenadores.laptop.entities.Laptop;
import es.ordenadores.laptop.repositories.LaptopRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LaptopService {
    // crea el repositorio
    @Autowired
    private LaptopRepository laptopRepository;

    // método para obtener todos los laptops
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }
    // metodo para obtener un laptop por su id
    public Laptop findById(Long id){
        return laptopRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el laptop con id: "+ id));
    }
    // metodo para crear un laptop
    public Laptop create(Laptop laptop){
        return laptopRepository.save(laptop);
    }
    // metodo para actualizar un laptop
    public Laptop update(Long id, Laptop laptop) {
        Laptop existingLaptop = findById(id);
        existingLaptop.setName(laptop.getName());
        existingLaptop.setModel(laptop.getModel());
        existingLaptop.setPrice(laptop.getPrice());
        return laptopRepository.save(existingLaptop);
    }
    public void delete(Long id) {
        laptopRepository.deleteById(id);
    }

}
