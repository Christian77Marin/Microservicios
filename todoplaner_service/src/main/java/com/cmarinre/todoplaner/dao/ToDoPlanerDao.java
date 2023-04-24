package com.cmarinre.todoplaner.dao;

import java.util.List;

import com.cmarinre.todoplaner.model.Agenda;

public interface ToDoPlanerDao {

	List<Agenda> returnPlans();
	void deletePlan(int id);
	void addPlan(Agenda agenda);
	void updatePlan(Agenda agenda);
}
