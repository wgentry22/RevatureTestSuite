package com.revature.hibernate.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="focus")
public class Focus {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="focus_seq")
	@SequenceGenerator(name="focus_seq", allocationSize=1, initialValue=1)
	@Column(name="focus_id", nullable=false, updatable=false)
	private int focusId;
	
	@Column(name="focus_name", nullable=false, updatable=true, length=20)
	private String focusName;
	
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="skillFocus")
	@JoinTable(name="focus_skill", joinColumns=@JoinColumn(name="focus_id"),
	inverseJoinColumns=@JoinColumn(name="skill_id"))
	private Collection<Skill> focusSkill;


	
	//No args constructor
	public Focus() {
		super();
	}
	
	public Focus(String name) {
		this.focusName = name;
	}
	
	
	//All args constructor
	public Focus(int focusId, String focusName, Collection<Skill> focusSkill) {
	super();
	this.focusId = focusId;
	this.focusName = focusName;
	this.focusSkill = focusSkill;
	}
	
	//Getters and setters
		public int getFocusId() {
			return focusId;
		}

		public void setFocusId(int focusId) {
			this.focusId = focusId;
		}

		public String getFocusName() {
			return focusName;
		}

		public void setFocusName(String focusName) {
			this.focusName = focusName;
		}

		public Collection<Skill> getFocusSkill() {
			return focusSkill;
		}

		public void setFocusSkill(Collection<Skill> focusSkill) {
			this.focusSkill = focusSkill;
		}
		
		//ToString
		@Override
		public String toString() {
			return "Focus [focusId=" + focusId + ", focusName=" + focusName + "]";
		}

	
}
