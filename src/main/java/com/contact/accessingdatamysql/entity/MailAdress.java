package com.contact.accessingdatamysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MailAdress {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long contactId;

    private String email;

    public MailAdress(Long contactId,String email){
        this.contactId = contactId;
        this.email=email;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContactId() {
        return contactId;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
