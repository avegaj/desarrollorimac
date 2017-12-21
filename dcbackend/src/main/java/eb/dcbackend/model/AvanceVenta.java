package eb.dcbackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Avance_Temp_Ventas", schema="temp")
public class AvanceVenta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_av")
	private Integer id;
	
	private Integer year;

	private Integer month;
	
	private Integer day;
	
	private String channel;
	
	private float production;
	
	private float prima_sales;
	
	private float prima_issued;
	
	private float goal_prima;
	
	private float convertibility;
	
	private float per_prima;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public Integer getMonth() {
		return month;
	}


	public void setMonth(Integer month) {
		this.month = month;
	}


	public Integer getDay() {
		return day;
	}


	public void setDay(Integer day) {
		this.day = day;
	}


	public String getChannel() {
		return channel;
	}


	public void setChannel(String channel) {
		this.channel = channel;
	}


	public float getProduction() {
		return production;
	}


	public void setProduction(float production) {
		this.production = production;
	}


	public float getPrima_sales() {
		return prima_sales;
	}


	public void setPrima_sales(float prima_sales) {
		this.prima_sales = prima_sales;
	}


	public float getPrima_issued() {
		return prima_issued;
	}


	public void setPrima_issued(float prima_issued) {
		this.prima_issued = prima_issued;
	}


	public float getGoal_prima() {
		return goal_prima;
	}


	public void setGoal_prima(float goal_prima) {
		this.goal_prima = goal_prima;
	}


	public float getConvertibility() {
		return convertibility;
	}


	public void setConvertibility(float convertibility) {
		this.convertibility = convertibility;
	}


	public float getPer_prima() {
		return per_prima;
	}


	public void setPer_prima(float per_prima) {
		this.per_prima = per_prima;
	}

	@Override
	public String toString() {
		return "AvanceVenta [id=\" + id + \", year=" + year + ", month=" + month + ", day="+ day + 
				", channel=" + channel + ", production=" + production + ", prima_sales="
				+ prima_sales + ", prima_issued=" + prima_issued + ", goal_prima=" + goal_prima 
				+ ", convertibility=" + convertibility + ", per_prima=" + per_prima + "]";
	}
}
