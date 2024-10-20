package com.example.demo.service;


import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.Persona;
import com.example.demo.entity.Producto;
import com.example.demo.feignclients.PersonaFeignClient;
import com.example.demo.repository.PersonRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonaFeignClient client;
    private final PersonRepository personRepository;


    public PersonService(PersonaFeignClient client, PersonRepository personRepository) {
        this.client = client;
        this.personRepository = personRepository;
    }

    public List<PersonDTO> getPerson() {
        List<PersonDTO> response = client.getPerson();
        return response;
    }

    public Optional<Persona> getPerson1(Integer id) {
        return personRepository.findById(id);
    }

    public void savePerson(List<PersonDTO> personDTOList) {
        List<PersonDTO> listServicePerson = client.getPerson();
        Persona persona = new Persona();
        for (PersonDTO personService : listServicePerson) {
            for (PersonDTO personParam : personDTOList) {
                persona.setIdPersona(personService.getIdPersona());
                persona.setName(personService.getName());
                if (personParam.getIdPersona() == personService.getIdPersona()) {
                    persona.setIdCard(personParam.getIdCard());
                }
                personRepository.save(persona);
            }
        }

    }


    public void savePersonBYId(PersonDTO personDTO) {
        Persona personaTwo = new Persona();
        if (getPerson1(personDTO.getIdPersona()).isEmpty()) {
            personaTwo.setIdPersona(personDTO.getIdPersona());
            personaTwo.setIdCard(personDTO.getIdCard());
            personaTwo.setName(personDTO.getName());
            personRepository.save(personaTwo);
        } else {
            System.out.println("Ya existe ese registro de persona por tal motivo no se ouede guardar");
        }

    }


}
