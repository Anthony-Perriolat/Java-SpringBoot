package com.blog.blog.dao;

import java.util.List;
import com.blog.blog.model.ModelCar;

public interface ModelCarDao {
	
	public List<ModelCar> findAll();

	public ModelCar findById(int id);

	public ModelCar save(ModelCar modelCar);
	
	
}
