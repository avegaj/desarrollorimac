package eb.dcbackend.service;

import java.util.List;

import eb.dcbackend.model.Rol;


public interface RolService {

	Rol findById(int id);

	Rol findByType(String type);
	
	List<Rol> findAll();
	
}
