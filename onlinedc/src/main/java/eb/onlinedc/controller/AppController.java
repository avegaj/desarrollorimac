package eb.onlinedc.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import eb.dcbackend.model.Rol;
import eb.dcbackend.service.RolService;
import eb.dcbackend.service.UserEmployeeService;
import eb.dcbackend.dao.SecondEntityDAO;

@Controller
@RequestMapping("/")
@SessionAttributes("Profiles")
public class AppController {


	@Autowired
	UserEmployeeService userService;

	@Autowired
	RolService userProfileService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	SecondEntityDAO secondEntityDAO;

	static final Logger logger = LoggerFactory.getLogger(AppController.class);
	
	/**
	 * Este metodo maneja las peticiones GET de inicio de sesion Si los usarios se
	 * encuentran autenticados e intentan ir a la pagina de login.jsp los devuelve
	 * al main.jsp
	 */

	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
		} else {
			logger.info("ROLE : {}", getRole());
			
			switch (getRole()) {
	    	
	    	case "[ROLE_ADMIN]": 

	    		return "redirect:/home_admin";

	    	case "[ROLE_USER]": 

	    		return "redirect:/home_division";
	    		
	    	case "[ROLE_DBA]": 

	    		return "redirect:/home_division";
	    	default:

	    		return null;
			}
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}
	
	@RequestMapping(value = "/home_admin", method = RequestMethod.GET)
	public ModelAndView homeAdmin() {
		ModelAndView mv = new ModelAndView("home");
		logger.info("ROLE : {}", mv);
		return mv;
	}
	@RequestMapping(value = "/home_division", method = RequestMethod.GET)
	public ModelAndView homeDivision() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@RequestMapping(value = "common/content", method = RequestMethod.GET)
	public ModelAndView contentPage() {
		ModelAndView mv = new ModelAndView("common/content");
		logger.info("ROLE : {}", mv);
		return mv;
	}

	@RequestMapping(value = "/common/navigation", method = RequestMethod.GET)
	public ModelAndView contentNavigationPage() {
		ModelAndView mv = new ModelAndView("common/navigation");
		return mv;
	}

	@RequestMapping(value = "/common/topnavbar", method = RequestMethod.GET)
	public ModelAndView contentTopnavbarPage() {
		ModelAndView mv = new ModelAndView("common/topnavbar");
		return mv;
	}

	@RequestMapping(value = "/common/footer", method = RequestMethod.GET)
	public ModelAndView contentFooterPage() {
		ModelAndView mv = new ModelAndView("common/footer");
		return mv;
	}
	
	@RequestMapping(value = "/common/tools", method = RequestMethod.GET)
	public ModelAndView contentToolPage() {
		ModelAndView mv = new ModelAndView("common/tools");
		return mv;
	}

	@RequestMapping(value = "common/welcome", method = RequestMethod.GET)
	public ModelAndView body1Page() {
		ModelAndView mv = new ModelAndView("common/welcome");
		logger.info("ROLE : {}", mv);
		return mv;
	}
	
	@RequestMapping(value = "/home_admin/usuarios", method = RequestMethod.GET)
	public ModelAndView bodyUsuarios() {
		ModelAndView mv = new ModelAndView("usuarios");
		//passing the list of entities
		mv.addObject("entities", secondEntityDAO.list());
		return mv;
	}
	
	@RequestMapping(value = "/home_division/avance_venta", method = RequestMethod.GET)
	public ModelAndView bodyAvanceVenta() {
		ModelAndView mv = new ModelAndView("avance_venta");		
		return mv;
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessdenied";
	}
		
    @ModelAttribute("Profiles")
    public List<Rol> initializeProfiles() {
        return userProfileService.findAll();
    }
	
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	private String getRole() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Set<String> roles = authentication.getAuthorities().stream()
		     .map(r -> r.getAuthority()).collect(Collectors.toSet());
		
		String stringRoles = roles.toString();
		
		return stringRoles;
	}
	
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}
	
	/*Test*/
	
	@RequestMapping(value = "/home_admin/import", method = RequestMethod.GET)
	public ModelAndView bodyImport() {
		ModelAndView mv = new ModelAndView("test/import");
		return mv;
	}
	

}