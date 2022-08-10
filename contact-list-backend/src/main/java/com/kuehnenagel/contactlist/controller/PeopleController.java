package com.kuehnenagel.contactlist.controller;

import com.kuehnenagel.contactlist.dto.PeopleDTO;
import com.kuehnenagel.contactlist.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("people")
public class PeopleController {

    final private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public ResponseEntity<List<PeopleDTO>> person() {
        return peopleService.getPersonList();
    }

    @GetMapping("search")
    public ResponseEntity<List<PeopleDTO>> searchPerson(@RequestParam("personName") String personName) {
        return peopleService.searchPersonList(personName);
    }

}
