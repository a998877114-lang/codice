package it.unisalento.ingsoftware.rubrica_telefonica;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
    private final ContactsService contactsService;

    public ContactsController(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping("/new")
    public ModelAndView newContactForm() {
        return new ModelAndView("contact-form")
                .addObject(new ContactForm());
    }

    @PostMapping("/new")
    public ModelAndView handleNewContactSubmission(@ModelAttribute @Valid ContactForm contactForm, Errors errors) {
        if (errors.hasErrors()) {
            return new ModelAndView("contact-form");
        }
        Contact contact = contactsService.saveContact(contactForm);
        return new ModelAndView("redirect:/contacts?id=" + contact.getId());

        //return new ModelAndView("contact-details")
        //        .addObject("contact", contactForm);
    }

    @GetMapping
    public ModelAndView contactDetails(@RequestParam("id") UUID contactId) {
        return contactsService.getContact(contactId)
                .map(c -> new ModelAndView("contact-details")
                        .addObject("contact", c))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}