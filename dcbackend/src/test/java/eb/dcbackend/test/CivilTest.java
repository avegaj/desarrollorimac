package eb.dcbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import eb.dcbackend.model.CivilStatus;
import eb.dcbackend.service.CivilStatusService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class }, loader = AnnotationConfigContextLoader.class)
public class CivilTest {
              
    @Autowired
    public CivilStatusService civilStatusService;
	              
	public CivilStatus civilStatus;
	              
	@Test
	public void testFind() {
		civilStatus = civilStatusService.findById(1);
		assertEquals("Ok?","Soltero",civilStatus.getName());
	}
	
	/*@Test
	public void testAdd() {
		gender = new Gender();
		gender.setName("No indica");
		genderService.saveGender(gender);
	}*/
	
	/*@Test
	public void testDelete() {
		genderService.deleteGenderById(3);
	}*/
	
	/*@Test
	public void testListSecondrEntity() {			
		assertEquals("Successfully list!",2,genderService.findAllGender().size());
	}*/
}

/*package eb.dcbackend.test;*/

/*import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import eb.dcbackend.dao.SecondEntityDAO;
import eb.dcbackend.model.SecondEntity;*/

/*public class SecondEntityTest {*/

	
	/*private static AnnotationConfigApplicationContext context;*/
	
	/*private static SecondEntityDAO secondEntityDAO;*/
	
	/*@SuppressWarnings("unused")
	private SecondEntity secondEntity;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("eb.dcbackend");
		context.refresh();
		
		secondEntityDAO = (SecondEntityDAO)context.getBean("secondEntityDAO");
	}*/
	/*@Test
	public void testAddSecondEntity() {
		secondEntity = new SecondEntity();
		secondEntity.setName("Oty");
		secondEntity.setDescription("I am entity");
		secondEntityDAO.save(secondEntity);	
	}*/
	
	/*@Test
	public void testGetIdSecondrEntity() {
		secondEntity = secondEntityDAO.findById(1);
		assertEquals("Ok?","Oty",secondEntity.getName());
	}*/
	
	/*@Test
	public void testGetNameSecondrEntity() {
		secondEntity = secondEntityDAO.findByName("Eloy");
		assertEquals("Ok?","Eloy",secondEntity.getName());
	}
	
	@Test
	public void testDeleteSecondrEntity() {
		secondEntityDAO.deleteById(2);
	}*/
	
	/*@Test
	public void testUpdateSecondrEntity() {
		secondEntity = secondEntityDAO.get(1);
		secondEntity.setName("Carlos");
		
		assertEquals("Successfully update",true,secondEntityDAO.update(secondEntity));
	}*/
	
	/*@Test
	public void testDeleteSecondrEntity() {
		secondEntity = secondEntityDAO.get(4);
		
		assertEquals("Successfully delete",true,secondEntityDAO.delete(secondEntity));
	}*/
	
	/*@Test
	public void testListSecondrEntity() {
					
		assertEquals("Successfully list!",5,secondEntityDAO.list().size());
		
	}*/
/*}*/
