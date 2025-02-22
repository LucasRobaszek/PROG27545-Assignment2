package ca.sheridan.robaszel.assignment2.databases;

import ca.sheridan.robaszel.assignment2.beans.PasswordRecord;
import org.springframework.data.repository.CrudRepository;


public interface DatabaseAccess extends CrudRepository<PasswordRecord, Long> {

}
