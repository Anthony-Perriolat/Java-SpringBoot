package com.blog.blog.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.blog.blog.model.Car;
import com.blog.blog.model.ModelCar;

public class CarDaoImpl implements CarDao{
	
	private List<Car> carList = new ArrayList<>();
	
	public CarDaoImpl(ModelCarDaoImpl modelCarFaker) {
		List<ModelCar> tab = modelCarFaker.getModelCarList();
		carList.add(new Car(1, new String("C1"), tab.get(0), new String("Citroen"), new Integer(3)));
		carList.add(new Car(2, new String("Twingo"), tab.get(0) , new String("Renault"), new Integer(3)));
		carList.add(new Car(3, new String("Clio"), tab.get(0), new String("Renault"), new Integer(3)));
		carList.add(new Car(4, new String("107"), tab.get(0) , new String("Peugeot"), new Integer(3)));
		carList.add(new Car(5, new String("Tesla model S"), tab.get(1), new String("tesla"), new Integer(3)));
		carList.add(new Car(6, new String("C 220"), tab.get(1) , new String("meco"), new Integer(3)));
		carList.add(new Car(7, new String("I8"), tab.get(2), new String("bmw"), new Integer(3)));
		carList.add(new Car(8, new String("S3"), tab.get(2) , new String("audi"), new Integer(3)));
	}

	@Override
	public List<Car> findAll() {
		// TODO Auto-generated method stub
		return carList;
	}

	public List<Car> findByCatAll(Integer category) {
		List<Car> carListbyCategory = carList.stream().filter(p -> p.getIdModel() == category).collect(Collectors.toList());
		return carListbyCategory;
	}

	@Override
	public Car findById(int id) {
		List<Car> tmp = carList.stream().filter(p -> p.getId() == id).collect(Collectors.toList());
		Car car = (Car) tmp.get(0);
		return car;
	}

	@Override
	public Car save(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> findByCatAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
