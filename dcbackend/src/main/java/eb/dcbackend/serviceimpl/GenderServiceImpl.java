package eb.dcbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eb.dcbackend.dao.GenderDAO;
import eb.dcbackend.model.Gender;
import eb.dcbackend.service.GenderService;


@Service("genderService")
@Transactional
public class GenderServiceImpl implements GenderService{

	@Autowired
	private GenderDAO dao;
	
	public Gender findById(int id) {
		return dao.findById(id);
	}

	public Gender findByName(String name) {
		Gender gender = dao.findByName(name);
		return gender;
	}

	public void saveGender(Gender gender) {
		dao.save(gender);
	}

	public void updateGender(Gender gender) {
		Gender entity = dao.findById(gender.getId());
		if(entity!=null){
			entity.setId(gender.getId());
			entity.setName(gender.getName());
		}
	}
	
	public void deleteGenderById(int id) {
		dao.deleteById(id);
	}

	public List<Gender> findAllGender() {
		return dao.findAllGender();
	}
	
}
