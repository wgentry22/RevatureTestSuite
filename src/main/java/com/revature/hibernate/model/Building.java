package com.revature.hibernate.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="BUILDING")
public class Building {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="building_seq")
	@SequenceGenerator(name="building_seq", allocationSize=1, initialValue=1)
	@Column(name="BUILDING_ID", nullable=false, updatable=false)
	private int buildingId;
	
	
	@Column(name="BUILDING_NAME")
	private String buildingName;
	
	
	@Column(name="BUILDING_LOCATION")
	private int locationId;
	
	
	
	
}
