package com.revature.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BATCH")
public class Batch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="batch_seq")
	@SequenceGenerator(name="batch_seq", allocationSize=1, initialValue=1)
	@Column(name="BATCH_ID", nullable=false, updatable=false)
	private int batchId;
	
	@Column(name = "BATCH_NAME", nullable=false)
	private String batchName;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="trainerId")
	private int trainerId;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="roomId")
	private int roomId;
	
	public Batch() {
		super();
	}
	
	public Batch(int batchId, String batchName, int trainerId, int roomId) {
		this.batchId = batchId;
		this.batchName = batchName;
		this.trainerId = trainerId;
		this.roomId = roomId;
	}
	
	public Batch(String batchName, int trainerId, int roomId) {
		this.batchName = batchName;
		this.trainerId = trainerId;
		this.roomId = roomId;
	}
	
	public int getBatchId() {
		return batchId;
	}
	public String getBatchName() {
		return batchName;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + roomId;
		result = prime * result + trainerId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batch other = (Batch) obj;
		if (batchId != other.batchId)
			return false;
		if (batchName == null) {
			if (other.batchName != null)
				return false;
		} else if (!batchName.equals(other.batchName))
			return false;
		if (roomId != other.roomId)
			return false;
		if (trainerId != other.trainerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchName=" + batchName + ", trainerId=" + trainerId + ", roomId="
				+ roomId + "]";
	}
	
}
