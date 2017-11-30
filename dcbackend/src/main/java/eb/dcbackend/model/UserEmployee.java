package eb.dcbackend.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="USER_EMPLOYEE")
public class UserEmployee implements Serializable{

	private static final long serialVersionUID = 1L;

	private Date date_init;
	
	private Date date_contract;
	
	@NotEmpty
	@Column(name="user_name", unique=true, nullable=false)
	private String user_name;
	
	private String user_red;
	
	@NotEmpty
	private String password;
	
	private String image_url;
	
	private boolean active;
	
	@OneToOne
	@JoinColumn(name = "id_sede")
	private TypeSede id_sede;
	
	@OneToOne
	@JoinColumn(name = "id_grade")
	private TypeGrade id_grade;
	
	@OneToOne
	@JoinColumn(name = "id_type_contract")
	private TypeContract id_type_contract;
	
	@Id
	@Column(name="document_person")
	private String document_person;
	
	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY) /*No se inicia hasta que sea necesario*/
	@JoinTable(name = "USER_ROL", 
             joinColumns = { @JoinColumn(name = "document_user") }, 
             inverseJoinColumns = { @JoinColumn(name = "id_rol") })
	private Set<Rol> userRoles = new HashSet<Rol>();

	public Date getDate_init() {
		return date_init;
	}

	public void setDate_init(Date date_init) {
		this.date_init = date_init;
	}

	public Date getDate_contract() {
		return date_contract;
	}

	public void setDate_contract(Date date_contract) {
		this.date_contract = date_contract;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_red() {
		return user_red;
	}

	public void setUser_red(String user_red) {
		this.user_red = user_red;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImagen_url() {
		return image_url;
	}

	public void setImagen_url(String imagen_url) {
		this.image_url = imagen_url;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public TypeSede getId_sede() {
		return id_sede;
	}

	public void setId_sede(TypeSede id_sede) {
		this.id_sede = id_sede;
	}

	public TypeGrade getId_grade() {
		return id_grade;
	}

	public void setId_grade(TypeGrade id_grade) {
		this.id_grade = id_grade;
	}

	public TypeContract getId_type_contract() {
		return id_type_contract;
	}

	public void setId_type_contract(TypeContract id_type_contract) {
		this.id_type_contract = id_type_contract;
	}

	public String getDocument_person() {
		return document_person;
	}

	public void setDocument_person(String document_person) {
		this.document_person = document_person;
	}

	public Set<Rol> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<Rol> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((date_contract == null) ? 0 : date_contract.hashCode());
		result = prime * result + ((date_init == null) ? 0 : date_init.hashCode());
		result = prime * result + ((document_person == null) ? 0 : document_person.hashCode());
		result = prime * result + ((id_grade == null) ? 0 : id_grade.hashCode());
		result = prime * result + ((id_sede == null) ? 0 : id_sede.hashCode());
		result = prime * result + ((id_type_contract == null) ? 0 : id_type_contract.hashCode());
		result = prime * result + ((image_url == null) ? 0 : image_url.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userRoles == null) ? 0 : userRoles.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_red == null) ? 0 : user_red.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEmployee other = (UserEmployee) obj;
		if (active != other.active)
			return false;
		if (date_contract == null) {
			if (other.date_contract != null)
				return false;
		} else if (!date_contract.equals(other.date_contract))
			return false;
		if (date_init == null) {
			if (other.date_init != null)
				return false;
		} else if (!date_init.equals(other.date_init))
			return false;
		if (document_person == null) {
			if (other.document_person != null)
				return false;
		} else if (!document_person.equals(other.document_person))
			return false;
		if (id_grade == null) {
			if (other.id_grade != null)
				return false;
		} else if (!id_grade.equals(other.id_grade))
			return false;
		if (id_sede == null) {
			if (other.id_sede != null)
				return false;
		} else if (!id_sede.equals(other.id_sede))
			return false;
		if (id_type_contract == null) {
			if (other.id_type_contract != null)
				return false;
		} else if (!id_type_contract.equals(other.id_type_contract))
			return false;
		if (image_url == null) {
			if (other.image_url != null)
				return false;
		} else if (!image_url.equals(other.image_url))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userRoles == null) {
			if (other.userRoles != null)
				return false;
		} else if (!userRoles.equals(other.userRoles))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_red == null) {
			if (other.user_red != null)
				return false;
		} else if (!user_red.equals(other.user_red))
			return false;
		return true;
	}
}
