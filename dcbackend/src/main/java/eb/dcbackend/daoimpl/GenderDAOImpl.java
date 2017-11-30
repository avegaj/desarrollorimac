package eb.dcbackend.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import eb.dcbackend.dao.AbstractDAO;
import eb.dcbackend.dao.GenderDAO;
import eb.dcbackend.model.Gender;



@Repository("genderDAO")
public class GenderDAOImpl extends AbstractDAO<Integer, Gender> implements GenderDAO {

	static final Logger logger = LoggerFactory.getLogger(GenderDAOImpl.class);
	
	public Gender findById(int id) {
		Gender gender = getByKey(id);
		if(gender!=null){
			Hibernate.initialize(gender.getId());
		}
		return gender;
	}

	public Gender findByName(String name) {
		logger.info("Nombre género : {}", name);
		CriteriaQuery<Gender> crit = createEntityCriteria("name", "where for String", name, null);
		Query<Gender> query = getSession().createQuery(crit);	
		List<Gender> results = query.getResultList();
		Gender gender = null;
		if(!results.isEmpty()){
		    // ignores multiple results
			gender = results.get(0);
		}
		if(gender!=null){
			Hibernate.initialize(gender.getName());
		}
		return gender;
	}

	public List<Gender> findAllGender() {
		CriteriaQuery<Gender> criteria = createEntityCriteria(null, "list", null, null);
		criteria.distinct(true);
		List<Gender> genders = getSession().createQuery(criteria).getResultList();
		return genders;
	}

	public void save(Gender gender) {
		persist(gender);
	}

	public void deleteById(int id) {
		CriteriaQuery<Gender> crit = createEntityCriteria("id", "where for int", null, id);
		Query<Gender> query = getSession().createQuery(crit);
		List<Gender> results = query.getResultList();
		Gender gender = null;
		if(!results.isEmpty()){
		    // ignores multiple results
			gender = results.get(0);
		}
		if(gender!=null){
			Hibernate.initialize(gender.getId());
		}
		delete(gender);
	}

}
