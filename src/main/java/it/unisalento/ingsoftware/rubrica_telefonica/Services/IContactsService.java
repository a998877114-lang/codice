package it.unisalento.ingsoftware.rubrica_telefonica.Services;

import it.unisalento.ingsoftware.rubrica_telefonica.Models.Contact;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface IContactsService {

    Contact saveContact(Contact contact);
    Optional<Contact> getContact(long id);
    List<Contact> getAllContacts ();
    Contact updateContact(long id, Contact updatedContact);
    void deleteContact(long id);
}
