package com.blog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.blog.dao.CarDao;
import com.blog.blog.dao.CarDaoImpl;
import com.blog.blog.dao.ModelCarDao;
import com.blog.blog.dao.ModelCarDaoImpl;
import com.blog.blog.model.Car;
import com.blog.blog.model.ModelCar;

import form.CarForm;


// Genere le rendu des fichier static
@Controller
public class controllerViews {
	
	// Injectez (inject) via application.properties.
	@Value("${welcome.message}")
	private String message;
	
	@Autowired
	private ModelCarDao modelCarFakerDao;
	@Autowired
	private CarDao carFakerDao;
	
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
	public String addCarView(Model model) {
		CarForm carForm = new CarForm();
		model.addAttribute("carForm", carForm);
		return "addCar";
	}
	
	
	@PostMapping(value = "/storeCar")
	public String storeCar(Model model, 
			@ModelAttribute("storeCar") CarForm carFrom) {
		Integer id = carFrom.getId();
		String name = carFrom.getName();
		ModelCar modelCar = modelCarFaker.findById(5);
		String brand = "Unknow";
		Integer color = carFrom.getColor();
		
		if (name != null && name.length() > 0 //
				&& name != null && name.length() > 0) {
			Car newCar = new Car(id, name, modelCar, brand, color);
			// carFaker.getCarList().add(newCar);
			carFaker.save(newCar);
			return "redirect:/modelcarlist";
		}

		model.addAttribute("errorMessage", errorMessage);				
		return "modelcar/5";
	}
	
	@GetMapping(value = "/viewUpdate")
	public String updateCarView(Model model, CarForm carFrom) {
		CarForm carForm = new CarForm();
		model.addAttribute("carForm", carForm);
		return "updateCar";
	}
	
	@PostMapping(value = "/carUpdate")
	public String updateCar(@ModelAttribute("updateCar") Car car) {
	    carFaker.update(car);
	    return "redirect:/modelcarlist";
	}
	    
	@GetMapping("/{id}/delete")
	public String deleteCar(@PathVariable("id") Integer id) {
		carFaker.delete(id);
	    return "redirect:/index";
	}
}
	
	
