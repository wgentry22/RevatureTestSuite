package com.revature.hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.revature.hibernate.dao.*;
import com.revature.hibernate.model.*;

public class TestClass {

	
	public static void main(String[] args) {
//		Location location = new Location("Northwest HQ", "Portland", "Oregon");
//		LocationDaoImpl.getInstance().insertLocation(location);
//	
//		Building b1 = new Building("NW Test 1");
//		LocationDaoImpl.getInstance().addBuilding(location.getLocationName(), b1);
//		
//		Building b2 = new Building("NW Test 2");
//		LocationDaoImpl.getInstance().addBuilding(location.getLocationName(), b2);
//		
//		Building b3 = new Building("NW Test 3");
//		LocationDaoImpl.getInstance().addBuilding(location.getLocationName(), b3);
//		
//		Room r1 = new Room("101A");
//		LocationDaoImpl.getInstance().addRoom(b1.getBuildingName(), r1);
//		
//		Room r2 = new Room("202B");
//		LocationDaoImpl.getInstance().addRoom(b2.getBuildingName(), r2);
//		
//		Room r3 = new Room("203B");
//		LocationDaoImpl.getInstance().addRoom(b2.getBuildingName(), r3);
//		
//		Room r4 = new Room("314C");
//		LocationDaoImpl.getInstance().addRoom(b3.getBuildingName(), r4);
//		
//		Room r5 = new Room("447C");
//		LocationDaoImpl.getInstance().addRoom(b3.getBuildingName(), r5);
//		
//		Room r6 = new Room("487C");
//		LocationDaoImpl.getInstance().addRoom(b3.getBuildingName(), r6);
		
		
		List<Location> allLocations = LocationDaoImpl.getInstance().selectAllLocations();
		for (Location l : allLocations) {
			System.out.println("Location: " + l.getLocationName());
			for (Building b : l.getBuildings()) {
				System.out.println("Building: " + b.getBuildingName());
				for (Room r : b.getRooms()) {
					System.out.println("Room: " + r.getRoomNumber());
				}
			}
		}
		
//		Curriculum c = new Curriculum("JTA Automation");
//		CurriculumDaoImpl.getInstance().insertCurriculum(c);
//		
//		Skill s1 = new Skill("SQL");
//		SkillDaoImpl.getInstance().insertSkill(s1);
//		Skill s2 = new Skill("JavaScript");
//		SkillDaoImpl.getInstance().insertSkill(s2);
//		Skill s3 = new Skill("Core Java");
//		SkillDaoImpl.getInstance().insertSkill(s3);
//		Skill s4 = new Skill("Servlets");
//		SkillDaoImpl.getInstance().insertSkill(s4);
//		CurriculumDaoImpl.getInstance().addSkill(c.getCurriculumName(), s1);
//		CurriculumDaoImpl.getInstance().addSkill(c.getCurriculumName(), s2);
//		CurriculumDaoImpl.getInstance().addSkill(c.getCurriculumName(), s3);
//		CurriculumDaoImpl.getInstance().addSkill(c.getCurriculumName(), s4);
		
		List<Curriculum> curriculumList = CurriculumDaoImpl.getInstance().selectAllCurriculum();
		for (Curriculum c : curriculumList) {
			System.out.println("Curriculum: " + c.getCurriculumName());
			for (Skill s : c.getCurriculumSkill()) {
				System.out.println("Skill: " + s.getSkillName());
			}
		}
		
	
		
		
	}
	
}
