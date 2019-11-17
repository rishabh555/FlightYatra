package com.mytechtra.spring.FlightYatra.HibernateEx.m2m;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name= "engines")
public class Engine {

	
	@Id
	@Column (name="engine_id")
	private int engineId;
	
	@Column(name="engine_name")
	private String engineName;
	
	public Engine() {
		// TODO Auto-generated constructor stub
	}
	
	public Engine(int engineId, String engineName) {
		super();
		this.engineId = engineId;
		this.engineName = engineName;
	}

	
	@ManyToMany(mappedBy = "engines")
	private List<Car> cars = new ArrayList<Car>();

	public int getEngineId() {
		return engineId;
	}

	public void setEngineId(int engineId) {
		this.engineId = engineId;
	}

	public String getEngineName() {
		return engineName;
	}

	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public List<Car> getCars() {
		return cars;
	}

	@Override
	public String toString() {
		return "Engine [engineId=" + engineId + ", engineName=" + engineName + "]";
	}
	
	
	
	}
