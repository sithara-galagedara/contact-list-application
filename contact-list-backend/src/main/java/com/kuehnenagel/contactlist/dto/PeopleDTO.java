package com.kuehnenagel.contactlist.dto;

public class PeopleDTO {

    private Integer peopleID;
    private String peopleName;
    private String peopleImageURL;

    public Integer getPeopleID() {
        return peopleID;
    }

    public void setPeopleID(Integer peopleID) {
        this.peopleID = peopleID;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleImageURL() {
        return peopleImageURL;
    }

    public void setPeopleImageURL(String peopleImageURL) {
        this.peopleImageURL = peopleImageURL;
    }
}
