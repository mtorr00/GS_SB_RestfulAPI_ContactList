package org.genspark.martintorrey.Services;

import java.util.List;

import org.genspark.martintorrey.Entity.Contact;

public interface ContactsService {
	List<Contact> getAllContacts();
	Contact getContactById(Long id);
	Contact getContactByName(String name);
	Contact getContactByPhone(String phone);
	Contact getContactByEmail(String email);
	
	Contact addContact(Contact contact);
	Contact updateContact(Contact contact);
	String deleteContactById(Long id);
}
