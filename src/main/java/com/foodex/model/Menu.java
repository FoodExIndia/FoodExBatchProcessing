package com.foodex.model;

import java.util.Date;

public class Menu {
	private int foodkey;
	private int quantity;
	private int courseflag;
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFoodkey() {
		return foodkey;
	}

	public void setFoodkey(int foodkey) {
		this.foodkey = foodkey;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCourseflag() {
		return courseflag;
	}

	public void setCourseflag(int courseflag) {
		this.courseflag = courseflag;
	}

	@Override
	public String toString() {
		return "Menu [foodkey=" + foodkey + ", quantity=" + quantity + ", courseflag=" + courseflag + ", date=" + date
				+ "]";
	}

}
