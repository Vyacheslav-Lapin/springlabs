package lab.mvc;

import lab.model.simple.Contact;
import lab.model.simple.Contacts;
import lab.service.ContactService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @ResponseBody
    @PostMapping("/listdata")
    public Contacts listData() {
        return new Contacts(contactService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Contact findContactById(@PathVariable Long id) {
        return contactService.findByid(id);
    }

    @PostMapping("/")
    @ResponseBody
    public Contact create(@RequestBody Contact contact) {
        log.info("Creating contact: {}", contact);
        contactService.save(contact);
        log.info("Contact created successfully with info: {}", contact);
        return contact;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public void update(@RequestBody Contact contact, @PathVariable Long id) {
        log.info("Updating contact: {}", contact);
        contactService.save(contact);
        log.info("Contact updated successfully wi th info: {}", contact);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id) {
        log.info("Deleting contact with id: {}", id);
        Contact contact = contactService.findByid(id);
        contactService.delete(contact);
        log.info("Contact deleted successfully");
    }
}
