package com.revature.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class Skill {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="skill_seq")
	@SequenceGenerator(name="skill_seq", allocationSize=1, initialValue=1)
	@Column(name="skill_id", nullable=false, updatable=false)
	private int skillId;
	
	@Column(name="skill_name", nullable=false, updatable=false)
	private String skillName;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="focusSkill")
	private Collection<Focus> skillFocus = new ArrayList<Focus>();
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="curriculumSkill")
	private Collection<Curriculum> skillCurriculum = new ArrayList<Curriculum>();

	public Skill() {
		super();
	}

	public Skill(int skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + "]";
	}
	
}
