package com.cmarinre.todoplaner.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmarinre.todoplaner.model.Agenda;

public class ToDoPlanerDaoImpl implements ToDoPlanerDao{

	
	@Autowired
	ToDoPlanerJPASpring toDoPlaner;
	
	@Override
	public List<Agenda> returnPlans() {
		
		return toDoPlaner.findAll();
	}

	@Override
	public void deletePlan(int id) {
		toDoPlaner.deleteById(id);
		
	}

	@Override
	public void addPlan(Agenda agenda) {
		toDoPlaner.save(agenda);
		
	}

	@Override
	public void updatePlan(Agenda agenda) {
		toDoPlaner.save(agenda);
		
	}

}
