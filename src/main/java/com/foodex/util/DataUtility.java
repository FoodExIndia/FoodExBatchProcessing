package com.foodex.util;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.foodex.model.MenuCostEntity;
import com.google.common.collect.Maps;

public final class DataUtility {
	private DataUtility() {

	}

	public static Map<Integer, Double> menuCost = Maps.newHashMap();

	@SuppressWarnings("unchecked")
	public static Map<Integer, Double> loadMenuCost() {
		if (menuCost.isEmpty()) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			List<MenuCostEntity> menuCostList = session.createQuery("from com.foodex.model.MenuCostEntity").list();
			for (MenuCostEntity cost : menuCostList) {
				menuCost.put(cost.getFoodKey(), cost.getMrp());
			}
			HibernateUtil.shutdown();
		}
		return menuCost;
	}

	public static void main(String[] args) {
		System.out.println(DataUtility.loadMenuCost());
	}

}
