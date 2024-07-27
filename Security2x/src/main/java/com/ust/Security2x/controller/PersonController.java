package com.ust.Security2x.controller;

import com.ust.Security2x.common.PersonConstant;
import com.ust.Security2x.model.Person;
import com.ust.Security2x.repo.PersonRepository;
import com.ust.Security2x.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/regivter")
    public String registerperson(@RequestBody Person person){
        person.setRoles(PersonConstant.DEFAULT_ROLE);
        String encodedpassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedpassword);
        personRepository.save(person);
        return "person registered successfully -> "+ person.getUsername();
    }

}
