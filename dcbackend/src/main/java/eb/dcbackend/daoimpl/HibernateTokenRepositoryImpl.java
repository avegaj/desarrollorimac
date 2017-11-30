package eb.dcbackend.daoimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eb.dcbackend.dao.AbstractDAO;
import eb.dcbackend.model.PersistentLogin;

@Repository("tokenRepositoryDAO")
@Transactional
public class HibernateTokenRepositoryImpl extends AbstractDAO<String, PersistentLogin>
		implements PersistentTokenRepository {

	static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		logger.info("Creating Token for user : {}", token.getUsername());

		PersistentLogin persistentLogin = new PersistentLogin();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setSeries(token.getSeries());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLast_used(token.getDate());
		/*Vuelve persistente a la instancia*/
		persist(persistentLogin);
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		logger.info("Fetch Token if any for seriesId : {}", seriesId);
		try {
			CriteriaQuery<PersistentLogin> crit = createEntityCriteria("series", "where for String", seriesId, null);
			Query<PersistentLogin> query = getSession().createQuery(crit);
			PersistentLogin persistentLogin = (PersistentLogin)query.getSingleResult();
			return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
					persistentLogin.getToken(), persistentLogin.getLast_used());
		} catch (Exception e) {
			logger.info("Token not found...");
			return null;
		}
	}

	@Override
	public void removeUserTokens(String username) {
		logger.info("Removing Token if any for user : {}", username);
		CriteriaQuery<PersistentLogin> crit = createEntityCriteria("username", "where for String", username, null);
		Query<PersistentLogin> query = getSession().createQuery(crit);
		List<PersistentLogin> results = query.getResultList();
		PersistentLogin persistentLogin = null;
		if(!results.isEmpty()){
		    // ignores multiple results
			persistentLogin = results.get(0);
		}
		if (persistentLogin != null) {
			logger.info("rememberMe was selected");
			delete(persistentLogin);
		}
	}

	@Override
	public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
		logger.info("Updating Token for seriesId : {}", seriesId);
		PersistentLogin persistentLogin = getByKey(seriesId);
		persistentLogin.setToken(tokenValue);
		persistentLogin.setLast_used(lastUsed);
		update(persistentLogin);
	}

}
