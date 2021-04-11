package com.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ViewController {
	
	@GetMapping("/")
	public String viewHome(Model model) {
		int id=10;
		model.addAttribute("id" , id);
		return "index";
	}
	
	@GetMapping(value = "delete")
	public String delete(@RequestParam("id") Integer id) {
		System.out.println("Deleted by " + id);
		return "redirect:/";
		
	}
	
	@PostMapping(value="selectStates")
	@ResponseBody
	public List<String> jqueryAjax(@RequestParam("country") String country) {
		
		List<String> list=new ArrayList<>();
		
		if(country.equals("India")) {
			list.add("Maharashtra");
			list.add("MP");
			list.add("Delhi");
			return list;
		}else if(country.equals("Us")) {
			list.add("us1");
			list.add("us2");
			return list;
		}else if(country.equals("Uk")) {
			list.add("uk1");
			list.add("uk2");
			return list;
		}
		return null;
	}

}
