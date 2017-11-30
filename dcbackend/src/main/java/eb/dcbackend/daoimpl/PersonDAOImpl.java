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
import eb.dcbackend.dao.PersonDAO;
import eb.dcbackend.model.Person;

@Transactional
@Repository("personDAO")
public class PersonDAOImpl extends AbstractDAO<String, Person> implements PersonDAO {
	
		static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

		@Override
		public Person findById(String document) {
			Person person = getByKey(document);
			if(person!=null) {
				Hibernate.initialize(person.getDocument());
			}
			return person;
		}

		@Override
		public Person findByShortName(String shortName) {
			logger.info("Nombre Corto: {}", shortName);
			CriteriaQuery<Person> crit = createEntityCriteria("short_name", "where for String", shortName, null);
			Query<Person> query = getSession().createQuery(crit);
			List<Person> results = query.getResultList();
			Person person = null;
			if(!results.isEmpty()){
				person = results.get(0);
			}
			if(person!=null){
				Hibernate.initialize(person.getShort_name());
			}
			return person;
		}

		@Override
		public void save(Person person) {
			persist(person);	
			
		}

		@Override
		public void deleteById(String document) {
			CriteriaQuery<Person> crit = createEntityCriteria("document", "where for String", document, null);
			Query<Person> query = getSession().createQuery(crit);
			Person person = (Person)query.getSingleResult();
			delete(person);		
		}

		@Override
		public List<Person> findAllPersons() {
			CriteriaQuery<Person> criteria = createEntityCriteria(null, "list", null, null);
			criteria.distinct(true);
			List<Person> persons = getSession().createQuery(criteria).getResultList();
			return persons;
		}
}
