package eb.dcbackend.dao;

import java.util.List;

import eb.dcbackend.model.Gender;


public interface GenderDAO {

	Gender findById(int id);
	
	Gender findByName(String name);
	
	void save(Gender gender);
	
	void deleteById(int id);
	
	List<Gender> findAllGender();

}

