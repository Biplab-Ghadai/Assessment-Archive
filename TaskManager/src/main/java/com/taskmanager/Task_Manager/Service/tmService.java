package com.taskmanager.Task_Manager.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.Task_Manager.Model.tm;
import com.taskmanager.Task_Manager.Repository.tmRepo;

@Service
public class tmService {
	
		@Autowired
		tmRepo repo;
		
		public List<tm> getAlltmItems() {
			ArrayList<tm> tdmList = new ArrayList<>();
			repo.findAll().forEach(tdm -> tdmList.add(tdm));
			
			return tdmList;
		}
		
		public tm gettmItemById(Long id) {
			return repo.findById(id).get();
		}
		
		public boolean updateStatus(Long id) {
			tm tdm = gettmItemById(id);
			tdm.setStatus("Completed");
			
			return saveOrUpdatetmItem(tdm);
		}
		
		public boolean saveOrUpdatetmItem(tm tdm) {
			tm updatedObj = repo.save(tdm);
			
			if (gettmItemById(updatedObj.getId()) != null) {
				return true;
			}
			
			return false;
		}
		
		public boolean deletetmItem(Long id) {
			repo.deleteById(id);
			
			if (repo.findById(id).isEmpty()) {
				return true;
			}
			
			return false;
		}
	
}
