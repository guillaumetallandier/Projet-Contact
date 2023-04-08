package com.contact.accessingdatamysql.repository;

import java.util.List;

import com.contact.accessingdatamysql.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface ContactRepository extends JpaRepository<Contact, Long> {

    //@Query("SELECT * FROM Contact")
    //public List<Contact> findAll();

    @Query("SELECT e FROM Contact e WHERE e.id >= :id")
    public List<Contact> findById(@Param("id")long id);

    @Query("SELECT e FROM Contact e WHERE e.firstName >= :firstName")
    public List<Contact> findByFirstName(@Param("firstName")String firstName);




}