package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.model.Curriculum;

public interface CurriculumDao {

	
	void insertCurriculum(Curriculum curriculum);
	Curriculum selectCurriculumById(int id);
	Curriculum selectCurriculumByName(String name);
	List<Curriculum> selectAllCurriculum();
	void updateCurriculum(Curriculum curriculum, String name);
	
}
