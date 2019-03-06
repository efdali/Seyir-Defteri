package com.punwald.seyirdefteri.models;

public class CategoryModel {
	private String category;

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return category;
		}
}
