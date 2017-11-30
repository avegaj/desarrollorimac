package eb.dcbackend.service;

import java.util.List;

import eb.dcbackend.model.Person;


public interface PersonService {
	
	Person findById(String document);
	
	Person findByShortName(String shortName);
	
	void savePerson(Person person);
	
	void updatePerson(Person person);
	
	void deletePersonById(String id);

	List<Person> findAllPerson(); 

}