package eb.dcbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eb.dcbackend.dao.PersonDAO;
import eb.dcbackend.model.Person;
import eb.dcbackend.service.PersonService;


@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDAO dao;
	
	public Person findById(String document) {
		return dao.findById(document);
	}

	public Person findByShortName(String shortName) {
		Person person = dao.findByShortName(shortName);
		return person;
	}

	public void savePerson(Person person) {
		dao.save(person);
	}

	public void updatePerson(Person person) {
		Person entity = dao.findById(person.getDocument());
		if(entity!=null){
			//entity.setId(person.getId());
			entity.setDocument(person.getDocument());
			entity.setFirst_name(person.getFirst_name());
			entity.setFirst_last_name(person.getFirst_last_name());
			entity.setSecond_last_name(person.getSecond_last_name());
			entity.setBirthday_date(person.getBirthday_date());
			entity.setShort_name(person.getShort_name());
			entity.setId_gender(person.getId_gender());
			entity.setId_civil_status(person.getId_civil_status());
		}
	}
	
	public void deletePersonById(String document) {
		dao.deleteById(document);
	}

	public List<Person> findAllPerson() {
		return dao.findAllPersons();
	}
	
}
