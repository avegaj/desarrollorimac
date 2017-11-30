package eb.dcbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eb.dcbackend.dao.CivilStatusDAO;
import eb.dcbackend.model.CivilStatus;
import eb.dcbackend.service.CivilStatusService;


@Service("civilStatusService")
@Transactional
public class CivilStatusServiceImpl implements CivilStatusService{

	@Autowired
	private CivilStatusDAO dao;
	
	public CivilStatus findById(int id) {
		return dao.findById(id);
	}

	public List<CivilStatus> findAllCivilStatus() {
		return dao.findAllCivilStatus();
	}
	
}
