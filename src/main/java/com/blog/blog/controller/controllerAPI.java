package com.blog.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blog.dao.CarDao;
import com.blog.blog.dao.CarDaoImpl;
import com.blog.blog.dao.ModelCarDao;
import com.blog.blog.dao.ModelCarDaoImpl;
import com.blog.blog.model.Car;
import com.blog.blog.model.ModelCar;

import form.CarForm;


// Genere le rendu des fichier static
@RestController
public class controllerAPI {
	
	
	@Autowired
	private ModelCarDao modelCarFakerDao;
	@Autowired
	private CarDao carFakerDao;
	
	// Faker 
	public ModelCarDaoImpl modelCarFaker = new ModelCarDaoImpl();
	public CarDaoImpl carFaker = new CarDaoImpl(modelCarFaker);

	

	@GetMapping(value = "/modelcarlist")
	public List<ModelCar> modelcarList(Model model) {
		return modelCarFaker.findAll();
	}
	
	@GetMapping(value = "/modelcarlist/{id}")
	public List<Car> carbymodel(@PathVariable("id") Integer id) {
		return carFaker.findByCatAll(id);
	}
	@GetMapping(value = "/car/{id}")
	public Car showCar(@PathVariable("id") int id) {
		return carFaker.findById(id);
	}	
	
	@PostMapping(value = "/storeCar")
	public Car storeCar(@RequestBody CarForm carFrom) {
		Integer id = carFrom.getId();
		String name = carFrom.getName();
		ModelCar modelCar = modelCarFaker.findById(5);
		String brand = "Unknow";
		Integer color = carFrom.getColor();
		
		Car newCar = new Car(id, name, modelCar, brand, color);
		carFaker.save(newCar);
		return newCar;
	}
	
	@PutMapping(value = "/carUpdate")
	public Car updateCar(@RequestBody Car car) {
	    return carFaker.update(car);
	}
	    
	@DeleteMapping("/delete/{id}")
	public boolean deleteCar(@PathVariable("id") int id) {
	    return carFaker.delete(id);
	}
}
	
	
