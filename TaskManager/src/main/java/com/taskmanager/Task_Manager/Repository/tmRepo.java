package com.taskmanager.Task_Manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskmanager.Task_Manager.Model.tm;

@Repository
public interface tmRepo extends JpaRepository<tm, Long>{

}
