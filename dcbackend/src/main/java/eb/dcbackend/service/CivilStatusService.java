package eb.dcbackend.service;

import java.util.List;

import eb.dcbackend.model.CivilStatus;


public interface CivilStatusService {
	
	CivilStatus findById(int id);

	List<CivilStatus> findAllCivilStatus(); 

}