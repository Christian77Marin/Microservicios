package com.cmarinre.todoplaner.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmarinre.todoplaner.model.Agenda;


public interface ToDoPlanerJPASpring extends JpaRepository<Agenda,Integer>{

}
