package eb.dcbackend.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Hibernate;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eb.dcbackend.dao.AbstractDAO;
import eb.dcbackend.dao.AvanceVentaDAO;
import eb.dcbackend.model.AvanceVenta;

@Transactional
@Repository("avanceVentaDAO")
public class AvanceVentaDAOImpl extends AbstractDAO<Integer, AvanceVenta> implements AvanceVentaDAO{

	static final Logger logger = LoggerFactory.getLogger(AvanceVentaDAOImpl.class);
	
	@Override
	public AvanceVenta findById(int id) {
		AvanceVenta avanceventa = getByKey(id);
		if(avanceventa!=null) {
			Hibernate.initialize(avanceventa.getId());
		}
		return avanceventa;
	}
	
	@Override
	public AvanceVenta findByYear(int year) {
		logger.info("Año: {}", year);
		CriteriaQuery<AvanceVenta> crit = createEntityCriteria("year", "where for int", null, year);
		Query<AvanceVenta> query = getSession().createQuery(crit);
		List<AvanceVenta> results = query.getResultList();
		AvanceVenta avanceventa = null;
		if(!results.isEmpty()){
			avanceventa = results.get(0);
		}
		if(avanceventa!=null){
			Hibernate.initialize(avanceventa.getYear());
		}
		return avanceventa;
	}
	
	@Override
	public AvanceVenta findByMonth(int month) {
		logger.info("Mes: {}", month);
		CriteriaQuery<AvanceVenta> crit = createEntityCriteria("month", "where for int", null, month);
		Query<AvanceVenta> query = getSession().createQuery(crit);
		List<AvanceVenta> results = query.getResultList();
		AvanceVenta avanceventa = null;
		if(!results.isEmpty()){
			avanceventa = results.get(0);
		}
		if(avanceventa!=null){
			Hibernate.initialize(avanceventa.getMonth());
		}
		return avanceventa;
	}
	
	@Override
	public AvanceVenta findByChannel(String channel) {
		logger.info("Canal: {}", channel);
		CriteriaQuery<AvanceVenta> crit = createEntityCriteria("channel", "where for String", channel, null);
		Query<AvanceVenta> query = getSession().createQuery(crit);
		List<AvanceVenta> results = query.getResultList();
		AvanceVenta avanceventa = null;
		if(!results.isEmpty()){
			avanceventa = results.get(0);
		}
		if(avanceventa!=null){
			Hibernate.initialize(avanceventa.getChannel());
		}
		return avanceventa;
	}
	
	@Override
	public List<AvanceVenta> findAllAvancesVenta() {
		CriteriaQuery<AvanceVenta> criteria = createEntityCriteria(null, "list", null, null);
		criteria.distinct(true);
		List<AvanceVenta> avanceventa = getSession().createQuery(criteria).getResultList();
		return avanceventa;
	}
	
}
