package com.revature.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ROOM")
public class Room {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="room_seq")
	@SequenceGenerator(name="room_id_seq", allocationSize=1, initialValue=1)
	@Column(name="ROOM_ID", nullable=false, updatable=false)
	private int roomId;
	
	//Room number is a string to incorporate 
	@Column(name="ROOM_NUMBER", nullable=false, updatable=false)
	private String roomNumber;
	
	
	
	
	public Room() {
		super();
	}
	
	
	
}
