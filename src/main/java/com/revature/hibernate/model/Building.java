package com.revature.hibernate.model;


import javax.persistence.*;

@Entity
@Table(name = "BUILDING")
public class Building {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="building_seq")
	@SequenceGenerator(name="building_seq", allocationSize=1, initialValue=1)
	@Column(name="BUILDING_ID", nullable=false, updatable=false)
	private int buildingId;
	
	
	@Column(name="BUILDING_NAME", nullable=false, updatable=true)
	private String buildingName;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Location location;

	public Building() {
		super();
	}
	
	public Building(int id) {
		this.buildingId = id;
	}
	
	public Building(String name) {
		this.buildingName = name;
	}
	
	public Building(int id, String name) {
		this.buildingId = id;
		this.buildingName = name;
	}
	
	
	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
}
