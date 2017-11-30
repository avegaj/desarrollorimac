package eb.dcbackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DISTRICT")
public class District implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String n_dep;
	
	private String n_prov;
	
	private String n_dis;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getN_dep() {
		return n_dep;
	}

	public void setN_dep(String n_dep) {
		this.n_dep = n_dep;
	}

	public String getN_prov() {
		return n_prov;
	}

	public void setN_prov(String n_prov) {
		this.n_prov = n_prov;
	}

	public String getN_dis() {
		return n_dis;
	}

	public void setN_dis(String n_dis) {
		this.n_dis = n_dis;
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", name=" + name + ", n_dep=" + n_dep + ", n_prov=" + n_prov + ", n_dis=" + n_dis
				+ "]";
	}
}