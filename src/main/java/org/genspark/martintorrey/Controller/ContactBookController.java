package org.genspark.martintorrey.Controller;

import java.util.List;

import org.genspark.martintorrey.Entity.Contact;
import org.genspark.martintorrey.Services.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactBookController {
	
	@Autowired
	private ContactsService contactsService;
	
	@GetMapping("/")
	public String home() {
		return "<HTML><h1>Contact Book</h1></HTML>";
	}
	
	@GetMapping("/contacts")
	public List<Contact> getContacts(){
		return this.contactsService.getAllContacts();
	}
	
	@GetMapping("/contacts/search/{name}")
	public Contact getContactName(@PathVariable String name) {
		return this.contactsService.getContactByName(name);
	}
	
	@GetMapping("/contacts/search/{phone}")
	public Contact getContactPhone(@PathVariable String phone) {
		return this.contactsService.getContactByPhone(phone);
	}
	
	@GetMapping("/contacts/search/{email}")
	public Contact getContactEmail(@PathVariable String email) {
		return this.contactsService.getContactByEmail(email);
	}
	
	@PostMapping("/contacts")
	public Contact addContact(@RequestBody Contact contact) {
		return this.contactsService.addContact(contact);
	}
	
	@PutMapping("/contacts")
	public Contact updateContact(@RequestBody Contact contact) {
		return this.contactsService.updateContact(contact);
	}
	
	@DeleteMapping("/contacts/delete/{id}")
	public String deleteContact(@PathVariable String id) {
		return this.contactsService.deleteContactById(Long.parseLong(id));
	}
}
