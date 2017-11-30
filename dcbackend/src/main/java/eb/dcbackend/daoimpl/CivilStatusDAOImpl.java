package eb.dcbackend.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import eb.dcbackend.dao.AbstractDAO;
import eb.dcbackend.dao.CivilStatusDAO;
import eb.dcbackend.model.CivilStatus;



@Repository("civilStatusDAO")
public class CivilStatusDAOImpl extends AbstractDAO<Integer, CivilStatus> implements CivilStatusDAO {

	static final Logger logger = LoggerFactory.getLogger(CivilStatusDAOImpl.class);
	
	public CivilStatus findById(int id) {
		CivilStatus civilStatus = getByKey(id);
		if(civilStatus!=null){
			Hibernate.initialize(civilStatus.getId());
		}
		return civilStatus;
	}

	public CivilStatus findByName(String name) {
		logger.info("Nombre género : {}", name);
		CriteriaQuery<CivilStatus> crit = createEntityCriteria("name", "where for String", name, null);
		Query<CivilStatus> query = getSession().createQuery(crit);	
		List<CivilStatus> results = query.getResultList();
		CivilStatus civilStatus = null;
		if(!results.isEmpty()){
		    // ignores multiple results
			civilStatus = results.get(0);
		}
		if(civilStatus!=null){
			Hibernate.initialize(civilStatus.getName());
		}
		return civilStatus;
	}

	public List<CivilStatus> findAllCivilStatus() {
		CriteriaQuery<CivilStatus> criteria = createEntityCriteria(null, "list", null, null);
		criteria.distinct(true);
		List<CivilStatus> civilStatuss = getSession().createQuery(criteria).getResultList();
		return civilStatuss;
	}

	public void save(CivilStatus civilStatus) {
		persist(civilStatus);
	}

	public void deleteById(int id) {
		CriteriaQuery<CivilStatus> crit = createEntityCriteria("id", "where for int", null, id);
		Query<CivilStatus> query = getSession().createQuery(crit);
		List<CivilStatus> results = query.getResultList();
		CivilStatus civilStatus = null;
		if(!results.isEmpty()){
		    // ignores multiple results
			civilStatus = results.get(0);
		}
		if(civilStatus!=null){
			Hibernate.initialize(civilStatus.getId());
		}
		delete(civilStatus);
	}

}
