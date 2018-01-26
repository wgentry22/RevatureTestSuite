package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.model.Skill;
import com.revature.hibernate.model.Trainer;

public interface TrainerDao {

	void insertTrainer(Trainer trainer);
	List<Trainer> selectAllTraineres();
	Trainer selectTrainerByName(String name);
	Trainer selectTrainerById(int id);
	void deleteTrainer(String name);
	void addSkill(String trainerFirstName, String trainerLastName, Skill skill);
}
