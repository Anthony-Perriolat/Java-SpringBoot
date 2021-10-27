package com.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.blog.dao.CarDao;
import com.blog.blog.dao.CarDaoImpl;
import com.blog.blog.dao.ModelCarDao;
import com.blog.blog.dao.ModelCarDaoImpl;
import com.blog.blog.model.Car;
import com.blog.blog.model.ModelCar;


// Genere le rendu des fichier static
@Controller
public class controllerViews {
	
	// Injectez (inject) via application.properties.
	@Value("${welcome.message}")
	private String message;
	
	@Autowired 
	private CarDao carDao;
	// Faker 
	public ModelCarDaoImpl modelCarFaker = new ModelCarDaoImpl();
	public CarDaoImpl carFaker = new CarDaoImpl(modelCarFaker);


	@Value("${error.message}")
	private String errorMessage;
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("message", message);
		return "index";
	}
	
	@GetMapping(value = "/modelcarlist")
	public String modelcarList(Model model) {
		model.addAttribute("modelcar", modelCarFaker.findAll());
		return "modelcar";
	}
	
	@GetMapping(value = "/modelcarlist/{id}")
	public String carbymodel(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("carList", carFaker.findByCatAll(id));
		return "carbycategory";
	}
	@GetMapping(value = "/car/{id}")
	public String showCar(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("car", carFaker.findById(id));
		return "car";
	}
	@GetMapping(value = "/addCar")
	public String addCar() {
		return "addCar";
	}
	
	
	@PostMapping(value = "/storeCar")
	public String storeCar(Model model, 
		@ModelAttribute("storeCar") Car car) {
		
		
		
		model.addAttribute("car", message);
		return "car";
	}
}
	
	
