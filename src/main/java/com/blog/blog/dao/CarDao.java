package com.blog.blog.dao;

import java.util.List;

import com.blog.blog.model.Car;

public interface CarDao {
	
	public List<Car> findAll();
	
	public List<Car> findByCatAll();


	public Car findById(int id);

	public Car save(Car car);
}
