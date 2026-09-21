package it.unisalento.ingsoftware.rubrica_telefonica.ServiceImpls;

import it.unisalento.ingsoftware.rubrica_telefonica.Models.Contact;
import it.unisalento.ingsoftware.rubrica_telefonica.Repositories.ContactRepository;
import it.unisalento.ingsoftware.rubrica_telefonica.Services.IContactsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactsService implements IContactsService {

    @Autowired
    private final ContactRepository contactRepository;

    public ContactsService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Optional<Contact> getContact(long id) {
        return contactRepository.findById(id);
    }

    public List<Contact> getAllContacts () {
        List<Contact> contacts = contactRepository.findAll();
        return contacts;
    }

    public Contact updateContact(long id, Contact updatedContact) {
        Optional<Contact> existingContact = contactRepository.findById(id);
        if (existingContact.isPresent()) {
            Contact contact = existingContact.get();
            contact.setFirstName(updatedContact.getFirstName());
            contact.setLastName(updatedContact.getLastName());
            contact.setPhone(updatedContact.getPhone());
            contact.setEmail(updatedContact.getEmail());
            return contactRepository.save(contact);
        } else {
            throw new RuntimeException("Contatto non trovato");
        }
    }

    public void deleteContact(long id) {
        Optional<Contact> existingContact = contactRepository.findById(id);
        if (existingContact.isPresent()) {
            contactRepository.deleteById(id);
        } else {
            throw new RuntimeException("Contatto non trovato");
        }
    }
}
