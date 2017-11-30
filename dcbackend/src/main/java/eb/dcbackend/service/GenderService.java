package eb.dcbackend.service;

import java.util.List;

import eb.dcbackend.model.Gender;


public interface GenderService {
	
	Gender findById(int id);
	
	Gender findByName(String name);
	
	void saveGender(Gender gender);
	
	void updateGender(Gender gender);
	
	void deleteGenderById(int id);

	List<Gender> findAllGender(); 

}