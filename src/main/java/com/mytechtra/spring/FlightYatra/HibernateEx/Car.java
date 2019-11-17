package com.mytechtra.spring.FlightYatra.HibernateEx;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car {

	@Id
	@Column (name="car_id")
	private int carId;
	
	@Column (name="car_name")
	private String carName;
	
	@Column (name="mfddate")
	private Date mfddate;
	
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public Car(int carId, String carName, Date mfddate) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.mfddate = mfddate;
	}

	@OneToOne(mappedBy = "car" ,cascade = CascadeType.PERSIST )
	private Engine engine;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public Date getMfddate() {
		return mfddate;
	}

	public void setMfddate(Date mfddate) {
		this.mfddate = mfddate;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
}
