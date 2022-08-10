package com.kuehnenagel.contactlist.serviceimpl;

import com.kuehnenagel.contactlist.dto.PeopleDTO;
import com.kuehnenagel.contactlist.entity.PeopleEntity;
import com.kuehnenagel.contactlist.service.PeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
public class PeopleServiceImpl implements PeopleService {

    private final Logger logger = LoggerFactory.getLogger(PeopleServiceImpl.class);

    @Override
    public ResponseEntity<List<PeopleDTO>> getPersonList() {
        List<PeopleDTO> peopleDTOList = readCSVFile(null);
        return new ResponseEntity<>(peopleDTOList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PeopleDTO>> searchPersonList(String personNameSearchParam) {
        List<PeopleDTO> peopleDTOList = readCSVFile(personNameSearchParam);
        return new ResponseEntity<>(peopleDTOList, HttpStatus.OK);
    }

    public List<PeopleDTO> readCSVFile(String personNameSearchParam) {
        List<PeopleDTO> peopleDTOList = new ArrayList<>();
        try {
            File file = ResourceUtils.getFile("classpath:people.csv");
            Scanner sc = new Scanner(file);
            sc.useDelimiter("\n");
            int idCounter = 0;

            /* Avoid first row */
            if (sc.hasNext()) {
                sc.next();
            }

            while (sc.hasNext()) {

                String row = sc.next();
                String[] columns = row.split(",");
                String personName = columns[0];
                String personUrl = columns[1].trim();

                if (personNameSearchParam != null && !personNameSearchParam.isEmpty()) {
                    if (personName.toLowerCase().contains(personNameSearchParam.toLowerCase())) {
                        idCounter++;
                        peopleDTOList.add(getPersonDTO(idCounter, personName, personUrl));
                    }
                } else {
                    idCounter++;
                    peopleDTOList.add(getPersonDTO(idCounter, personName, personUrl));
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            logger.error(ex.getMessage());

        }

        return peopleDTOList;
    }

    private PeopleDTO getPersonDTO(Integer idCounter, String personName, String personUrl) {
        PeopleEntity peopleEntity = new PeopleEntity();
        peopleEntity.setPeopleID(idCounter);
        peopleEntity.setPeopleName(personName);
        peopleEntity.setPeopleImageURL(personUrl);

        PeopleDTO peopleDTO = new PeopleDTO();
        BeanUtils.copyProperties(peopleEntity, peopleDTO);

        return peopleDTO;
    }
}
