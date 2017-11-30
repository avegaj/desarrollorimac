package eb.dcbackend.serviceimpl;
 
 import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;
 
 import eb.dcbackend.dao.SecondEntityDAO;
 import eb.dcbackend.model.SecondEntity;
 import eb.dcbackend.service.SecondEntityService;
 
 @Service("secondEntityService")
 @Transactional
 public class SecondEntityServiceImpl implements SecondEntityService{
 	@Autowired
 	private SecondEntityDAO dao;
 	
 	public SecondEntity findById(int id) {
 		return dao.findById(id);
 	}
 	
 	public SecondEntity findByName(String name) {
 		SecondEntity secondEntity = dao.findByName(name);
 		return secondEntity;
 	}
 
 	public void saveSecondEntity(SecondEntity secondEntity) {
 		dao.save(secondEntity);
 	}
 
 	public void updateSecondEntity(SecondEntity secondEntity) {
 		SecondEntity entity = dao.findById(secondEntity.getId());
 		if(entity!=null){
 			entity.setName(secondEntity.getName());
 			entity.setDescription(secondEntity.getDescription());
 			entity.setActivate(secondEntity.getActivate());
 		}
 	}
 	
 	public void deleteSecondEntityById(int id) {
 		dao.deleteById(id);
 	}
 
 	public List<SecondEntity> list() {
 		return dao.list();
 	}
 
 
 }