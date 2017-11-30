package eb.dcbackend.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	//@Column(name="id")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private Integer id;
	
	@Id
	@Column(name="document")
	private String document;

	//@Column(name="first_name")
	private String first_name;
	
	//@Column(name="first_last_name")
	private String first_last_name ;
	
	//@Column(name="second_last_name")
	private String second_last_name;
	
	//@Column(name="birthday_date")
	private Date birthday_date;
	
	//@Column(name="num_child")
	private Integer num_child;
	
	//@Column(name="short_name")
	private String short_name;
	
	@OneToOne
	@JoinColumn(name = "id_gender")
	private Gender id_gender;
	
	@OneToOne
	@JoinColumn(name = "id_civil_status")
	private CivilStatus id_civil_status;

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getFirst_last_name() {
		return first_last_name;
	}

	public void setFirst_last_name(String first_last_name) {
		this.first_last_name = first_last_name;
	}

	public String getSecond_last_name() {
		return second_last_name;
	}

	public void setSecond_last_name(String second_last_name) {
		this.second_last_name = second_last_name;
	}

	public Date getBirthday_date() {
		return birthday_date;
	}

	public void setBirthday_date(Date birthday_date) {
		this.birthday_date = birthday_date;
	}

	public Integer getNum_child() {
		return num_child;
	}

	public void setNum_child(Integer num_child) {
		this.num_child = num_child;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public Gender getId_gender() {
		return id_gender;
	}

	public void setId_gender(Gender id_gender) {
		this.id_gender = id_gender;
	}

	public CivilStatus getId_civil_status() {
		return id_civil_status;
	}

	public void setId_civil_status(CivilStatus id_civil_status) {
		this.id_civil_status = id_civil_status;
	}

	@Override
	public String toString() {
		return "Person [document=" + document + ", first_name=" + first_name + ", first_last_name="
				+ first_last_name + ", second_last_name=" + second_last_name + ", birthday_date=" + birthday_date
				+ ", num_child=" + num_child + ", short_name=" + short_name + ", id_gender=" + id_gender
				+ ", id_civil_status=" + id_civil_status + "]";
	}
}
