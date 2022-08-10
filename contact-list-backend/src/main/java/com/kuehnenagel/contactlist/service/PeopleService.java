package com.kuehnenagel.contactlist.service;

import com.kuehnenagel.contactlist.dto.PeopleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface PeopleService {

    ResponseEntity<List<PeopleDTO>> getPersonList();

    ResponseEntity<List<PeopleDTO>> searchPersonList(String personNameSearchParam);
}
