package com.example.demo.controller;

import com.example.demo.dto.PersonDTO;
import com.example.demo.entity.Producto;
import com.example.demo.service.PersonService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@Data
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonDTO>> getAll() {
        return new ResponseEntity<>(personService.getPerson(), HttpStatus.OK);
    }

    @PostMapping("/save-all")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePerson(@RequestBody List<PersonDTO> personDTO) {
        personService.savePerson(personDTO);
    }

    @PostMapping("/save")
    public void savePersonId(@RequestBody PersonDTO personDTO){
        personService.savePersonBYId(personDTO);
    }
}

