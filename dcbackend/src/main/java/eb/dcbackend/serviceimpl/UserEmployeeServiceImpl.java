package eb.dcbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eb.dcbackend.dao.UserEmployeeDAO;
import eb.dcbackend.model.UserEmployee;
import eb.dcbackend.service.UserEmployeeService;


@Service("userEmployeeService")
@Transactional
public class UserEmployeeServiceImpl implements UserEmployeeService{

	@Autowired
	private UserEmployeeDAO dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public UserEmployee findByDNI(String document) {
		return dao.findByDNI(document);
	}

	public UserEmployee findByUserName(String user_name) {
		UserEmployee user = dao.findByUserName(user_name);
		return user;
	}

	public void saveUser(UserEmployee user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	public void updateUser(UserEmployee user) {
		UserEmployee entity = dao.findByDNI(user.getDocument_person());
		if(entity!=null){
			entity.setDate_init(user.getDate_init());
			entity.setDate_contract(user.getDate_contract());
			entity.setUser_name(user.getUser_name());
			entity.setUser_red(user.getUser_red());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setImagen_url(user.getImagen_url());
			entity.setActive(user.isActive());
			entity.setId_sede(user.getId_sede());
			entity.setId_grade(user.getId_grade());
			entity.setId_type_contract(user.getId_type_contract());
			entity.setDocument_person(user.getDocument_person());

		}
	}
	
	public void deleteUserByDNI(String document) {
		dao.deleteByDNI(document);
	}

	public List<UserEmployee> findAllUsers() {
		return dao.findAllUsers();
	}

}
