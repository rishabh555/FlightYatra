package com.mytechtra.spring.FlightYatra.HibernateEx.o2m;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "car")
	private List<Engine> engines = new ArrayList<Engine>();

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

	public List<Engine> getEngines() {
		return engines;
	}
	public void setEngines(List<Engine> engines) {
		this.engines = engines;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + ", mfddate=" + mfddate + "]";
	}
	
	
	
}
