package eb.onlinedc.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eb.dcbackend.model.UserEmployee;
import eb.dcbackend.model.Rol;
import eb.dcbackend.service.UserEmployeeService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Autowired
	private UserEmployeeService userService;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
		UserEmployee user = userService.findByUserName(user_name);
		logger.info("User : {}", user);
		if (user == null) {
			logger.info("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUser_name(), user.getPassword(), true, true,
				true, true, getGrantedAuthorities(user));
	}

	private List<GrantedAuthority> getGrantedAuthorities(UserEmployee user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Rol userRol : user.getUserRoles()) {
			logger.info("UserProfile : {}", userRol);
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userRol.getName()));
		}
		logger.info("Authorities : {}", authorities);
		return authorities;
	}

}
