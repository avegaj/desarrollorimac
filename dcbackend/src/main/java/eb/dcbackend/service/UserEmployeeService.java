package eb.dcbackend.service;

import java.util.List;

import eb.dcbackend.model.UserEmployee;


public interface UserEmployeeService {
	
	UserEmployee findByDNI(String document);
	
	UserEmployee findByUserName(String user_name);
	
	void saveUser(UserEmployee user);
	
	void updateUser(UserEmployee user);
	
	void deleteUserByDNI(String document);

	List<UserEmployee> findAllUsers(); 
	
}