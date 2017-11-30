package eb.dcbackend.dao;

import java.util.List;

import eb.dcbackend.model.Rol;


public interface RolDAO {

	List<Rol> findAll();
	
	Rol findByType(String type);
	
	Rol findById(int id);
}
