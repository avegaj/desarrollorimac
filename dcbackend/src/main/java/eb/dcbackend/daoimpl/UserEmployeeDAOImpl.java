package eb.dcbackend.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import eb.dcbackend.dao.AbstractDAO;
import eb.dcbackend.dao.UserEmployeeDAO;
import eb.dcbackend.model.UserEmployee;

@Repository("userEmployeeDAO")
public class UserEmployeeDAOImpl extends AbstractDAO<Integer, UserEmployee> implements UserEmployeeDAO {

	static final Logger logger = LoggerFactory.getLogger(UserEmployeeDAOImpl.class);
	
	public UserEmployee findByDNI(String document) {
		logger.info("DNI : {}", document);
		CriteriaQuery<UserEmployee> crit = createEntityCriteria("document_person", "where for String", document, null);
		Query<UserEmployee> query = getSession().createQuery(crit);	
		List<UserEmployee> results = query.getResultList();
		UserEmployee user = null;
		if(!results.isEmpty()){
		    // ignores multiple results
			user = results.get(0);
		}
		if(user!=null){
			Hibernate.initialize(user.getUserRoles());
		}
		return user;
	}

	public UserEmployee findByUserName(String user_name) {
		logger.info("Nick : {}", user_name);
		CriteriaQuery<UserEmployee> crit = createEntityCriteria("user_name", "where for String", user_name, null);
		Query<UserEmployee> query = getSession().createQuery(crit);	
		List<UserEmployee> results = query.getResultList();
		UserEmployee user = null;
		if(!results.isEmpty()){
		    // ignores multiple results
			user = results.get(0);
		}
		if(user!=null){
			Hibernate.initialize(user.getUserRoles());
		}
		return user;
	}

	public List<UserEmployee> findAllUsers() {
		CriteriaQuery<UserEmployee> criteria = createEntityCriteria(null, "list", null, null);
		criteria.distinct(true);
		List<UserEmployee> users = getSession().createQuery(criteria).getResultList();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return users;
	}

	public void save(UserEmployee user) {
		persist(user);
	}

	public void deleteByDNI(String document) {
		CriteriaQuery<UserEmployee> crit = createEntityCriteria("document", "where for String", document, null);
		Query<UserEmployee> query = getSession().createQuery(crit);
		UserEmployee user = (UserEmployee)query.getSingleResult();
		delete(user);		
	}

}
