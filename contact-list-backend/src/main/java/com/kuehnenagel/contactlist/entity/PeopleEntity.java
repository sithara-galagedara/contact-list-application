package com.kuehnenagel.contactlist.entity;

import javax.persistence.*;

@Entity
@Table(name = "contact_list_person")
public class PeopleEntity {
    private Integer peopleID;
    private String peopleName;
    private String peopleImageURL;

    @Id
    @Column(name = "person_id", nullable = false, unique = true)
    public Integer getPeopleID() {
        return peopleID;
    }

    public void setPeopleID(Integer peopleID) {
        this.peopleID = peopleID;
    }

    @Basic
    @Column(name = "person_name")
    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    @Basic
    @Column(name = "person_image_url")
    public String getPeopleImageURL() {
        return peopleImageURL;
    }

    public void setPeopleImageURL(String peopleImageURL) {
        this.peopleImageURL = peopleImageURL;
    }
}
