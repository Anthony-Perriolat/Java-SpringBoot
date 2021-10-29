package com.blog.blog.dao;

import com.blog.blog.model.ModelCar;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;


@Repository
public class ModelCarDaoImpl implements ModelCarDao {

	private List<ModelCar> modelCarList = new ArrayList<ModelCar>();
	
	public ModelCarDaoImpl() {
		modelCarList.add(new ModelCar(0, new String("Citadine"), new Character('A'), new String("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRp_tqQ7baUpcWk2dTWhBQJBsgFYeupFsO4Zg&usqp=CAU")));
		modelCarList.add(new ModelCar(1, new String("Berline"), new Character('B'), new String("https://www.largus.fr/images/images/audi-a3-berline-2020-av2-1280x853.jpg")));
		modelCarList.add(new ModelCar(2, new String("Sport"), new Character('C'), new String("https://images.caradisiac.com/logos-ref/modele/modele--bmw-i8/S0-modele--bmw-i8.jpg")));
		modelCarList.add(new ModelCar(3, new String("Utilitaire"), new Character('D'), new String("https://www.largus.fr/images/images/vehicule-utilitaire.jpg")));
		modelCarList.add(new ModelCar(4, new String("New Car"), new Character('Z'), new String("http://lorempixel.com/400/200/transport")));
	}

	@Override
	public List<ModelCar> findAll() {
		return modelCarList;
	}

	@Override
	public ModelCar findById(int id) {
		List<ModelCar> tmp = modelCarList.stream().filter(p -> p.getId() == id).collect(Collectors.toList());
		ModelCar modelCar = (ModelCar) tmp.get(0);
		return modelCar;
	}

	@Override
	public ModelCar save(ModelCar modelCar) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ModelCar> getModelCarList() {
		return modelCarList;
	}

	public void setModelCarList(List<ModelCar> modelCarList) {
		this.modelCarList = modelCarList;
	}

}
