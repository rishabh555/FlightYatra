package com.mytechtra.spring.FlightYatra.HibernateEx;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	
	@OneToOne
	private Car car;

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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
	
	}
