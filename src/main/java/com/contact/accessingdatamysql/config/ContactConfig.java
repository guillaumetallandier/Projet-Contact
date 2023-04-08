package com.contact.accessingdatamysql.config;

import com.contact.accessingdatamysql.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactConfig {
    @Autowired
    static
    ContactRepository contactRepository;
    @Bean
    public static ContactRepository contactRepository(){


        return contactRepository;
    }

}
