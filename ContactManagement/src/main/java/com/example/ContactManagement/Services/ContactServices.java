package com.example.ContactManagement.Services;


import com.example.ContactManagement.Entity.ContactEntity;
import com.example.ContactManagement.Repository.ContactRepository;
import com.example.ContactManagement.Specification.ContactSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServices {


    @Autowired
    public ContactRepository contactRepository;

    @Autowired
    public ContactSpecification contactSpecification;

    public ContactEntity saveContact(ContactEntity contact) {
        return contactRepository.save(contact);
        }

    public List<ContactEntity> getAllContact() {

        return contactRepository.findAll();
    }


    public ContactEntity getContactById(Long id) {

        return contactRepository.findById(id).get();
    }

    public boolean deleteContact(Long id) {
        ContactEntity contact = contactRepository.findById(id).get();
        contactRepository.delete(contact);
        return false;
    }

    public ContactEntity updateContact(ContactEntity contact) {

        ContactEntity contactEntity = contactRepository.findById(contact.getId()).get();
        contactEntity.setFirstName(contact.getFirstName());
        contactEntity.setLastName(contact.getLastName());
        contactEntity.setEmail(contact.getEmail());
        contactEntity.setPhone(contact.getPhone());
        contactRepository.save(contactEntity);
        return contact;

    }

    public List<ContactEntity> searchContact(ContactEntity contact) {
        System.out.println("In Service"+ contact.getFirstName());

        List<ContactEntity> contactEntity= contactRepository.findAll(contactSpecification.getContacts(contact));
        System.out.println(contactEntity);
        return contactEntity;
    }
}
