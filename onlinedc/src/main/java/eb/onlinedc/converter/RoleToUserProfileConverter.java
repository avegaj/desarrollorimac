package eb.onlinedc.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import eb.dcbackend.model.Rol;
import eb.dcbackend.service.RolService;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, Rol>{

	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
	
	@Autowired
	RolService userProfileService;

	/**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Rol convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Rol profile= userProfileService.findById(id);
		logger.info("Profile : {}",profile);
		return profile;
	}
	
}