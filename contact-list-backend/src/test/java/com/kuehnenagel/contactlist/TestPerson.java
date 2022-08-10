package com.kuehnenagel.contactlist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuehnenagel.contactlist.controller.PeopleController;
import com.kuehnenagel.contactlist.dto.PeopleDTO;
import com.kuehnenagel.contactlist.serviceimpl.PeopleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestPerson {

    @LocalServerPort
    int randomServerPort;

    final private PeopleController peopleController;
    final private PeopleServiceImpl peopleServiceImpl;
    final private TestRestTemplate restTemplate;

    @Autowired
    TestPerson(PeopleController peopleController, PeopleServiceImpl peopleServiceImpl,
               TestRestTemplate restTemplate) {
        this.peopleController = peopleController;
        this.peopleServiceImpl = peopleServiceImpl;
        this.restTemplate = restTemplate;
    }

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(peopleController);
        Assertions.assertNotNull(peopleServiceImpl);
        Assertions.assertNotNull(restTemplate);
    }

    @Test
    void TestLoadAllContacts() {
        ResponseEntity<List<PeopleDTO>> responseEntity = peopleController.person();
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assertions.assertTrue((Objects.requireNonNull(responseEntity.getBody()).size() > 0),
                "All people data should be greater than Zero");
    }

    @Test
    void TestSearchContacts() {
        ResponseEntity<List<PeopleDTO>> responseEntity = peopleController.searchPerson("Homer");
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assertions.assertTrue((Objects.requireNonNull(responseEntity.getBody()).size() > 0),
                "Searched people data should be greater than Zero");
    }

    @Test
    void TestCSVReader() {
        List<PeopleDTO> peopleDTOList = peopleServiceImpl.readCSVFile(null);
        Assertions.assertTrue((peopleDTOList.size() > 0),
                "Searched people data should be greater than Zero");
    }

    @Test
    public void testGetAllPeople() throws JsonProcessingException {
        String responseEntity = this.restTemplate.getForObject("http://localhost:"+randomServerPort+"/people",
                String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<PeopleDTO> peopleDTOList = objectMapper.readValue(responseEntity, new TypeReference<List<PeopleDTO>>() {
        });

        Assertions.assertTrue((peopleDTOList.size() > 0),
                "GET response data should be greater than Zero");
    }

    @Test
    public void testGetSearchPeople() throws JsonProcessingException {
        String responseEntity = this.restTemplate.getForObject("http://localhost:"+randomServerPort+"/people/search?personName=Moe Szyslak",
                String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<PeopleDTO> peopleDTOList = objectMapper.readValue(responseEntity, new TypeReference<List<PeopleDTO>>() {
        });

        Assertions.assertTrue((peopleDTOList.size() > 0),
                "GET response data should be greater than Zero");
    }
}
