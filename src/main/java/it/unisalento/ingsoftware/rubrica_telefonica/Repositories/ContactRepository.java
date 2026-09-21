package it.unisalento.ingsoftware.rubrica_telefonica.Repositories;

import it.unisalento.ingsoftware.rubrica_telefonica.Models.Contact;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Id> {
    Optional<Contact> findById(long id);
    Contact save(Contact contact);
    List<Contact> findAll();
    void deleteById(long Id);
}
