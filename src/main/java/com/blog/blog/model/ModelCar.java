package com.blog.blog.model;

public class ModelCar {
	
	private int id; 
	private String nameModel;
	private Character characterCategory;
	private String urlPicture;
	
	
	
	public ModelCar(int id, String nameModel, Character characterCategory, String urlPicture) {
		super();
		this.id = id;
		this.nameModel = nameModel;
		this.characterCategory = characterCategory;
		this.urlPicture = urlPicture;
	}
	public String getUrlPicture() {
		return urlPicture;
	}
	public void setUrlPicture(String urlPicture) {
		this.urlPicture = urlPicture;
	}
	@Override
	public String toString() {
		return "modelCar [id=" + id + ", nameModel=" + nameModel + ", characterCategory=" + characterCategory + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameModel() {
		return nameModel;
	}
	public void setNameModel(String nameModel) {
		this.nameModel = nameModel;
	}
	public Character getCharacterCategory() {
		return characterCategory;
	}
	public void setCharacterCategory(Character characterCategory) {
		this.characterCategory = characterCategory;
	}
	
	
	
	

}
