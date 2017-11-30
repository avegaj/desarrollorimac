package eb.dcbackend.dao;


import java.util.List;

import eb.dcbackend.model.Person;

public interface PersonDAO {
	
	Person findById (String document);
	
	Person findByShortName (String firstName);
	
	void save (Person person);
	
	void deleteById (String document);
	
	List<Person> findAllPersons();
	
}
