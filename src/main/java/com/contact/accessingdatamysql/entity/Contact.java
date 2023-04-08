package com.contact.accessingdatamysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

import java.util.ArrayList;


@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    private String postalAdress;

    private String mailAdress;

  //  private ArrayList<Contact> ContactList;


    public Contact(){};
    public Contact(String firstName, String lastName, String mailAdress) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAdress = mailAdress;
    }



    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.lastName=name;
    }

    public void setPostalAdress(String postalAdress) {
        this.postalAdress = postalAdress;
    }

   // public ArrayList<Contact> getContactList() {
     //   return ContactList;
    //}

    public String getMailAdress() {
        return mailAdress;
    }

  //  public void setContactList(ArrayList<Contact> contactList) {
   //     ContactList = contactList;
   // }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPostalAdress() {
        return postalAdress;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }



}