package org.pickles.dataformat.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Party {

	private List<Person> participants;
	private Map<String, Food> foods = new HashMap<>();
	private String address;

	public Party(List<Person> participants, String address) {
		this.participants = participants;
		this.address = address;
	}

	public void setStaple(Food staple){
		foods.put("staple", staple);
	}

	public void setMainDish(Food mainDish){
		foods.put("mainDish", mainDish);
	}

	public void setSideDish(Food sideDish){
		foods.put("sideDish", sideDish);
	}

	public void setDrink(Food drink){
		foods.put("drink", drink);
	}

	public List<Person> getParticipants() {
		return participants;
	}

	public Map<String, Food> getFoods() {
		return foods;
	}
}
