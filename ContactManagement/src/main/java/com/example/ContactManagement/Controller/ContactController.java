package com.example.ContactManagement.Controller;


import com.example.ContactManagement.Entity.ContactEntity;
import com.example.ContactManagement.Services.ContactServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class ContactController {


    @Autowired
    public ContactServices contactServices;

    @PostMapping("/saveContact")
    public ContactEntity saveContact(@RequestBody ContactEntity contact) {
        return contactServices.saveContact(contact);
    }

    @GetMapping("/getAllContact")
    public List<ContactEntity> getAllContact(){
        return contactServices.getAllContact();
    }

    @GetMapping("getContactById")
    public ResponseEntity<ContactEntity> fetchContactById(@RequestParam("id") Long id) {
        ContactEntity contact =  contactServices.getContactById(id);
        return ResponseEntity.ok(contact);
    }

    @DeleteMapping("deleteContactById")
    public ResponseEntity<Map<String, Boolean>> deleteContact(@RequestParam("id") Long id) {
        boolean deleted = false;
        deleted = contactServices.deleteContact(id);
        Map<String,Boolean > response = new HashMap<>();
        response.put("Contact deleted successfully", deleted = true);
        return ResponseEntity.ok(response);
    }

    @PutMapping("updateContact")
    public ResponseEntity<ContactEntity> updateContact(@RequestBody ContactEntity contact){
        contact = contactServices.updateContact(contact);
        return ResponseEntity.ok(contact);
    }

    @GetMapping("searchContact")
    public List<ContactEntity> searchContact(@RequestParam(required = false) String firstName,
                                                       @RequestParam(required = false) String lastName,
                                                       @RequestParam(required = false) String email){
        ContactEntity contact= new ContactEntity();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setEmail(email);
        System.out.println("In controller"+ firstName);
        return contactServices.searchContact(contact);
    }
}
