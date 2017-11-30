package eb.dcbackend.dao;

import java.util.List;

import eb.dcbackend.model.UserEmployee;


public interface UserEmployeeDAO {

	UserEmployee findByDNI(String document_person);
	
	UserEmployee findByUserName(String user_name);
	
	void save(UserEmployee user);
	
	void deleteByDNI(String document);
	
	List<UserEmployee> findAllUsers();

}

