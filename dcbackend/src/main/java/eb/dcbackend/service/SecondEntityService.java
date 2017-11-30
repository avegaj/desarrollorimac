package eb.dcbackend.service;
 
import java.util.List;

import eb.dcbackend.model.SecondEntity;

public interface SecondEntityService {
 	
	SecondEntity findById(int id);
	
	SecondEntity findByName(String name);
	
 	void saveSecondEntity(SecondEntity secondEntity);
 	
 	void updateSecondEntity(SecondEntity secondEntity);
 	
 	void deleteSecondEntityById(int id);
 
 	List<SecondEntity> list(); 
 	
}