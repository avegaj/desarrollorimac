package eb.dcbackend.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import eb.dcbackend.model.CivilStatus;
import eb.dcbackend.model.Gender;
import eb.dcbackend.model.Person;
import eb.dcbackend.service.CivilStatusService;
import eb.dcbackend.service.GenderService;
import eb.dcbackend.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class }, loader = AnnotationConfigContextLoader.class)
public class PersonTest {
              
    @Autowired
    public PersonService personService;
    
    @Autowired
    public GenderService genderService;
    
    @Autowired
    public CivilStatusService civilStatusService;
	              
	public Person person;
	
	public Gender gender;
	
	public CivilStatus civilStatus;
	              
	/*@Test
	public void testFind() {
		person = personService.findById("08731420");
		assertEquals("Ok?","08731420",person.getDocument());
	}*/
	
	@Test
	public void testAdd() throws ParseException {
		
		String str = "13/06/2011";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date date;
		date = dateFormat.parse(str);
		dateFormat.parseObject(str);
		
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		
		person = new Person();
		person.setDocument("44782327");
		person.setFirst_name("ELOY");
		person.setFirst_last_name("BARAHONA");
		person.setSecond_last_name("SILVA");
		person.setBirthday_date(sqlDate);
		
		gender = genderService.findById(2);
		System.out.println("Gender: " + gender.getId()+ ": " + gender.getName());
		person.setId_gender(gender);
		System.out.println("Person Gender: " + person.getId_gender());
		
		civilStatus = civilStatusService.findById(1);
		System.out.println("Civil_Status: " + civilStatus.getId()+ ": " + civilStatus.getName());
		person.setId_civil_status(civilStatus);
		
		personService.savePerson(person);
	}
	
	/*@Test
	public void testDelete() {
		personService.deletePersonById("44782323");
	}*/
	
	@Test
	public void testList() {			
		assertEquals("Successfully list!",1,personService.findAllPerson().size());
	}
}