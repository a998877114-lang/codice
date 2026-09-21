package it.unisalento.ingsoftware.rubrica_telefonica.Controllers;

import it.unisalento.ingsoftware.rubrica_telefonica.Services.IContactsService;
import it.unisalento.ingsoftware.rubrica_telefonica.Models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phonebook/v1")
public class ContactsController {

    @Autowired
    private final IContactsService contactsService;

    public ContactsController(IContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        Contact newContact = contactsService.saveContact(contact);
        return ResponseEntity.ok(newContact);
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactsService.getAllContacts();
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> getContactsById(@PathVariable long id) {
        Optional<Contact> contact = contactsService.getContact(id);
        if (contact.isPresent()) {
            return ResponseEntity.ok(contact.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/contacts/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable long id, @RequestBody Contact contact) {
        Contact updatedContact = contactsService.updateContact(id, contact);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/contacts/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable long id) {
        contactsService.deleteContact(id);
        return ResponseEntity.ok("Contatto cancellato con successo");
    }
}