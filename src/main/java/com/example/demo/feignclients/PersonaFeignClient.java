package com.example.demo.feignclients;

import com.example.demo.dto.PersonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "person.service",url="https://microserviciotest.azurewebsites.net")
public interface PersonaFeignClient {
    @GetMapping(value="/api/v1/persons",consumes = MediaType.APPLICATION_JSON_VALUE)
    List<PersonDTO>getPerson();
    @PostMapping(value="/api/v1/persons",consumes = MediaType.APPLICATION_JSON_VALUE)
    PersonDTO save(@RequestBody PersonDTO personDTO);
    @PostMapping(value="/api/v1/persons",consumes = MediaType.APPLICATION_JSON_VALUE)
    void savePersonByID(@RequestBody  Integer id);


}
