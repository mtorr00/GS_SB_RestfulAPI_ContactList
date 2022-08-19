package org.genspark.martintorrey.Dao;

import org.genspark.martintorrey.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDao extends JpaRepository<Contact, Long> {

}
