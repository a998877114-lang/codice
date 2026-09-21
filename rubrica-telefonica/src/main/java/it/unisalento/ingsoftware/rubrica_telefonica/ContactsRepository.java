package it.unisalento.ingsoftware.rubrica_telefonica;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ContactsRepository {
    private final JdbcTemplate jdbcTemplate;

    public ContactsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Contact> findById(UUID id) {
        String sql = "select * from contacts where idContacts = ?";
        try {
            return Optional.ofNullable(
                        jdbcTemplate.queryForObject(sql, new ContactRowMapper(), id.toString()));
        } catch (IncorrectResultSizeDataAccessException e) {
            System.out.println(e.getActualSize());
            return Optional.empty();
        }
    }

    public Contact save(Contact contact) {
        String sql = "insert into contacts (idContacts, firstName, lastName, phone, email) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, contact.getId().toString(), contact.getFirstName(), contact.getLastName(), contact.getPhone(), contact.getEmail());
        return contact;
    }

    static class ContactRowMapper extends BeanPropertyRowMapper<Contact> {
        public ContactRowMapper() {
            super(Contact.class);
        }
    }
}
