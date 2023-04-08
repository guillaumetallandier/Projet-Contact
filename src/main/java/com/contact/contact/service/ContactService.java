package com.contact.contact.service;

import com.contact.accessingdatamysql.entity.Contact;
import com.contact.accessingdatamysql.repository.ContactRepository;
import com.contact.accessingdatamysql.config.ContactConfig;
import org.springframework.stereotype.Service;


@Service
public class ContactService {


    public static Contact addContact( String firstName, String lastName,String mailAdress){
        ContactRepository contactRepository = ContactConfig.contactRepository();
        Contact c = new Contact(firstName,lastName,mailAdress);
        contactRepository.save(c);
        return c;
    }

}
