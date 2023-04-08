package com.contact.contact;

import com.contact.accessingdatamysql.entity.Contact;
import com.contact.accessingdatamysql.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller

@EntityScan("com.contact.accessingdatamysql.entity")
@EnableJpaRepositories("com.contact.accessingdatamysql.repository")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/newContact")
  public String newContact(Model model) {

       model.addAttribute("list",contactRepository.findAll());
        return "/newContact";
    }




    @GetMapping("/contact/{id}")
    public String home ( @PathVariable Long id, Model model){

        Contact c =contactRepository.findById(id).orElse(null);


        if( c != null){
            model.addAttribute("id",c.getId());
            model.addAttribute("firstName",c.getFirstName());
            model.addAttribute("lastName",c.getLastName());
            model.addAttribute("mailAdress",c.getMailAdress());

            return "/updateContact";
        }


        return "/newContact";
    }

    @PostMapping(path="/add")
    public String newContact(
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value ="mailAdress", required= false) String mailAdress,
            Model model) {

        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("mailAdress",mailAdress);
        Contact c = new Contact(firstName,lastName,mailAdress);
        contactRepository.save(c);

        return "/home";
    }


    @GetMapping("/listeContact")
    public String listeContact(Model model) {
        model.addAttribute("list",contactRepository.findAll());

        return "/listeContact";
    }


    @PostMapping(path="/update")
    public String updateContact(
            @RequestParam(value="id",required = false) Long id,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value ="mailAdress", required= false) String mailAdress,
            Model model
    ) {

        Contact c =contactRepository.findById(id).orElse(null);

        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setMailAdress(mailAdress);
        contactRepository.save(c);
        if( c != null){
            model.addAttribute("firstName",firstName);
            model.addAttribute("lastName",lastName);
            model.addAttribute("mailAdress",mailAdress);
        }
        return "/home";
    }



    @GetMapping(path="/all")
    public  String getAllcontact(Model model) {

        List<Contact> contacts = contactRepository.findAll();

        List<Contact> contactList =  new ArrayList<Contact>();;
        for(Contact contact:contacts){
            contactList.add(contact);
        }
        model.addAttribute("contacts",contactList);
        return "/listeContact";

    }
    @GetMapping(path="/home/{id}")
    public String goHome(@PathVariable Long id,Model model){

        Contact c =contactRepository.findById(id).orElse(null);


        if( c != null){
            model.addAttribute("id",c.getId());
            model.addAttribute("firstName",c.getFirstName());
            model.addAttribute("lastName",c.getLastName());
            model.addAttribute("mailAdress",c.getMailAdress());

            return "/home";
        }


        return "/newContact";

    }
}





