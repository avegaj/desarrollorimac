package eb.dcbackend.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;


import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import eb.dcbackend.dao.AbstractDAO;
import eb.dcbackend.dao.RolDAO;
import eb.dcbackend.model.Rol;



@Repository("userProfileDAO")
public class RolDAOImpl extends AbstractDAO<Integer, Rol>implements RolDAO{

	public Rol findById(int id) {
		return getByKey(id);
	}

	public Rol findByType(String type) {
		CriteriaQuery<Rol> crit = createEntityCriteria("type", "where for String", type, null);
		Query<Rol> query = getSession().createQuery(crit);
		return (Rol)query.getSingleResult();
	}
	
	public List<Rol> findAll(){
		CriteriaQuery<Rol> criteria = createEntityCriteria(null, "list", null, null);
		List<Rol> usersprofile = getSession().createQuery(criteria).getResultList();
		return usersprofile;
	}
	
}
