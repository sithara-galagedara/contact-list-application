package com.kuehnenagel.contactlist.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contact_list_person")
public class PeopleEntity extends SharedEntity{
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeopleEntity that = (PeopleEntity) o;
        return Objects.equals(peopleID, that.peopleID) && Objects.equals(peopleName, that.peopleName) && Objects.equals(peopleImageURL, that.peopleImageURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peopleID, peopleName, peopleImageURL);
    }
}
