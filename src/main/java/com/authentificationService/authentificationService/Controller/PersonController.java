package com.authentificationService.authentificationService.Controller;

import com.authentificationService.authentificationService.Model.Person;
import com.authentificationService.authentificationService.Repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Data
@Controller
@RequestMapping(value = "/login")
public class PersonController {


    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public String getLogin(Model model) {
        model.addAttribute("people", this.personRepository.findAll());
        model.addAttribute("person", new Person());
        return "login";
    }

    @PostMapping
    public String createUser(Person person, Model model) {

        person.setId((int) (this.personRepository.count() + 1L));
        this.personRepository.save(person);

        return "redirect:/login";
    }
}
