package eb.dcbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eb.dcbackend.dao.RolDAO;
import eb.dcbackend.model.Rol;
import eb.dcbackend.service.RolService;


@Service("userRolService")
@Transactional
public class RolServiceImpl implements RolService{
	
	@Autowired
	RolDAO dao;
	
	public Rol findById(int id) {
		return dao.findById(id);
	}

	public Rol findByType(String type){
		return dao.findByType(type);
	}

	public List<Rol> findAll() {
		return dao.findAll();
	}
}
