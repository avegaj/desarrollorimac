package eb.dcbackend.dao;

import java.util.List;

import eb.dcbackend.model.CivilStatus;


public interface CivilStatusDAO {

	CivilStatus findById(int id);
	
	CivilStatus findByName(String name);
	
	void save(CivilStatus civilStatus);
	
	void deleteById(int id);
	
	List<CivilStatus> findAllCivilStatus();

}

