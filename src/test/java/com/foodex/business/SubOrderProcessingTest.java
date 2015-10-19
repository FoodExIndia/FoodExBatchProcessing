package com.foodex.business;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.foodex.model.Menu;
import com.foodex.model.OrderEntity;
import com.foodex.util.DataUtility;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

public class SubOrderProcessingTest {
	OrderEntity entity = new OrderEntity();

	@SuppressWarnings("deprecation")
	@Before
	public void setup() {
		SubOrderProcessing.menuCost = DataUtility.loadMenuCost();
		entity.setBreakfastTime(new Timestamp(2015, 10, 25, 8, 45, 52, 12));
		entity.setClientId(2564589545l);
		entity.setDinnerTime(new Timestamp(2015, 10, 25, 9, 45, 52, 12));
		entity.setFoodOrderFromDate(new Date(2015, 10, 18));
		entity.setFoodOrderToDate(new Date(2015, 10, 22));
		entity.setOrderCancellationFlag(0);
		entity.setOrphanageFlag(0);
		entity.setBfAddress(1);
		entity.setLunchAddress(2);
		entity.setDinnerAddress(1);
		entity.setBreakfastTime(new Timestamp(new java.util.Date().getTime()));
		entity.setLunchTime(new Timestamp(new java.util.Date().getTime()));
		entity.setDinnerTime(new Timestamp(new java.util.Date().getTime()));
		List<Menu> orderEntityList = Lists.newArrayList();
		Menu menu1 = new Menu();
		menu1.setCourseflag(1);
		menu1.setFoodkey(100);
		menu1.setQuantity(4);
		menu1.setDate(new java.util.Date());
		orderEntityList.add(menu1);
		menu1 = new Menu();
		menu1.setCourseflag(2);
		menu1.setFoodkey(200);
		menu1.setQuantity(4);
		menu1.setDate(new java.util.Date());
		orderEntityList.add(menu1);
		menu1 = new Menu();
		menu1.setCourseflag(3);
		menu1.setFoodkey(200);
		menu1.setQuantity(5);
		menu1.setDate(new java.util.Date());
		orderEntityList.add(menu1);
		Gson gson = new Gson();
		entity.setMenu(gson.toJson(orderEntityList));
		entity.setOrderId("12346567890");
	}

	@Test
	public void testCreateSubOrder() {
		SubOrderProcessing subOrderProcessing = new SubOrderProcessing();
		System.out.println(subOrderProcessing.createSubOrderKey(entity));
	}
}
