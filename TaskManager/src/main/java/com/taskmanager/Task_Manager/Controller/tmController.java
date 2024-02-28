package com.taskmanager.Task_Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taskmanager.Task_Manager.Model.tm;
import com.taskmanager.Task_Manager.Service.tmService;

@Controller
public class tmController {
		
	@Autowired
	private tmService service;
	
	@GetMapping({"/", "viewtmList"})
	public String viewAlltmItems(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", service.getAlltmItems());
		model.addAttribute("message", message);
		
		return "ViewtmList";
	}
	
	@GetMapping("/updatetmStatus/{id}")
	public String updateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (service.updateStatus(id)) {
			redirectAttributes.addFlashAttribute("message", "Update Success");
			return "redirect:/viewtmList";
		}
		
		redirectAttributes.addFlashAttribute("message", "Update Failure");
		return "redirect:/viewtmList";
	}
	
	
	@GetMapping("/addtmItem")
	public String addtmItem(Model model) {
		model.addAttribute("tdm", new tm());
		
		return "AddtmItem";
	}
	
	
	@PostMapping("/savetmItem")
	public String savetmItem(tm tdm, RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdatetmItem(tdm)) {
			redirectAttributes.addFlashAttribute("message", "Save Success");
			return "redirect:/viewtmList";
		}
		
		redirectAttributes.addFlashAttribute("message", "Save Failure");
		return "redirect:/addtmItem";
	}
	
	@GetMapping("/edittmItem/{id}")
	public String edittmItem(@PathVariable Long id, Model model) {
		model.addAttribute("tdm", service.gettmItemById(id));
		
		return "EdittmItem";
	}
	
	@PostMapping("/editSavetmItem")
	public String editSavetmItem(tm tdm, RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdatetmItem(tdm)) {
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "redirect:/viewtmList";
		}
		
		redirectAttributes.addFlashAttribute("message", "Edit Failure");
		return "redirect:/edittmItem/" + tdm.getId();
	}
	
	@GetMapping("/deletetmItem/{id}")
	public String deletetmItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (service.deletetmItem(id)) {
			redirectAttributes.addFlashAttribute("message", "Delete Success");
			return "redirect:/viewtmList";
		}
		
		redirectAttributes.addFlashAttribute("message", "Delete Failure");
		return "redirect:/viewtmList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
