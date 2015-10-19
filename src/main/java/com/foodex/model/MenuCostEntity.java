package com.foodex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fe_food_cost")
public class MenuCostEntity {
	@Id
	@Column(name = "food_key")
	private int foodKey;
	@Column(name = "food_item_mrp")
	private double mrp;

	public int getFoodKey() {
		return foodKey;
	}

	public void setFoodKey(int foodKey) {
		this.foodKey = foodKey;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	@Override
	public String toString() {
		return "MenuCostEntity [foodKey=" + foodKey + ", mrp=" + mrp + "]";
	}

}
