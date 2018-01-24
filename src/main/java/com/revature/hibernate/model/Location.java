package com.revature.hibernate.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="LOCATION")
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="location_seq")
	@SequenceGenerator(name="location_seq", allocationSize=1, initialValue=1)
	@Column(name="LOCATION_ID", nullable=false, updatable=false)
	private int locationId;
	
	@Column(name="LOCATION_NAME", nullable=false, updatable=false, length=20)
	private String locationName;
	
	@Column(name="LOCATION_CITY", nullable=false, updatable=false, length=20)
	private String locationCity;
	
	@Column(name="LOCATION_STATE", nullable=false, updatable=false, length=20)
	private String locationState;
	
	
	
//	private List<Building> buildings;
	
	
	public Location() {
		super();
	}

	public Location(int locationId) {
		super();
		this.locationId = locationId;
	}

	
	
	public Location(String locationName, String locationCity, String locationState) {
		super();
		this.locationName = locationName;
		this.locationCity = locationCity;
		this.locationState = locationState;
	}

	public Location(int locationId, String locationName, String locationCity, String locationState) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationCity = locationCity;
		this.locationState = locationState;
	}
	

//	public Location(int locationId, String locationName, String locationCity, String locationState,
//			List<Building> buildings) {
//		super();
//		this.locationId = locationId;
//		this.locationName = locationName;
//		this.locationCity = locationCity;
//		this.locationState = locationState;
//		this.buildings = buildings;
//	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getLocationState() {
		return locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

//	@OneToMany(fetch= FetchType.LAZY, mappedBy = "buildingId")
//	public List<Building> getBuildings() {
//		return buildings;
//	}
//	
//	public void setBuildings(List<Building> buildings) {
//		this.buildings = buildings;
//	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", locationCity="
				+ locationCity + ", locationState=" + locationState + "]";
	}

	
	
	
}
