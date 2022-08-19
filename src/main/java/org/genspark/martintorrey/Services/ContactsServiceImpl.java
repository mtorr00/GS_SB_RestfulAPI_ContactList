package org.genspark.martintorrey.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.genspark.martintorrey.Dao.ContactDao;
import org.genspark.martintorrey.Entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl implements ContactsService{

	@Autowired
	private ContactDao contactDao;
	
	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return this.contactDao.findAll();
	}

	@Override
	public Contact getContactById(Long id) {
		// TODO Auto-generated method stub
		Optional <Contact> c = this.contactDao.findById(id);
		Contact contact = null;
		if (c.isPresent()) {
			contact = c.get();
		} else {
			throw new RuntimeException("Contact not found for id :: " + id);
		}
		return contact;
	}
	

	@Override
	public Contact getContactByName(String name) {
		// TODO Auto-generated method stub
		Contact contact = null;
		for(Contact i:new ArrayList<>(this.contactDao.findAll())) {
			if(i.getName().equals(name)) {
				contact = i;
				break;
			}
		}
		return contact;
	}



	@Override
	public Contact getContactByPhone(String phone) {
		// TODO Auto-generated method stub
		Contact contact = null;
		for(Contact i:new ArrayList<>(this.contactDao.findAll())) {
			if(i.getPhone().equals(phone)) {
				contact = i;
				break;
			}
		}
		return contact;
	}



	@Override
	public Contact getContactByEmail(String email) {
		// TODO Auto-generated method stub
		Contact contact = null;
		for(Contact i:new ArrayList<>(this.contactDao.findAll())) {
			if(i.getEmail().equals(email)) {
				contact = i;
				break;
			}
		}
		return contact;
	}



	@Override
	public Contact addContact(Contact contact) {
		return this.contactDao.save(contact);
	}



	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return this.contactDao.save(contact);
	}



	@Override
	public String deleteContactById(Long id) {
		// TODO Auto-generated method stub
		this.contactDao.deleteById(id);
		return "Deleted Contact Successfully";
	}


	


	
}
