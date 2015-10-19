package com.foodex.business;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.foodex.model.Menu;
import com.foodex.model.OrderEntity;
import com.foodex.model.SubOrderEntity;
import com.foodex.util.DataUtility;
import com.foodex.util.HibernateUtil;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

public class SubOrderProcessing {
	public static Map<Integer, Double> menuCost = null;

	public static void main(String[] args) {
		new SubOrderProcessing().subOrderCreation();
	}

	@SuppressWarnings("unchecked")
	private void subOrderCreation() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(OrderEntity.class);
		criteria.add(Restrictions.eq("orderStatus", 1));
		List<OrderEntity> orderListEntity = criteria.list();
		menuCost = DataUtility.loadMenuCost();
		for (OrderEntity orderEntity : orderListEntity) {
			List<SubOrderEntity> subOrdersList = createSubOrderKey(orderEntity);
			if (!subOrdersList.isEmpty()) {
				for (SubOrderEntity order : subOrdersList)
					session.save(order);
			}
		}
		session.beginTransaction().commit();
		HibernateUtil.shutdown();
	}

	/**
	 * 
	 * @param orderEntity
	 * @return
	 */
	public List<SubOrderEntity> createSubOrderKey(OrderEntity orderEntity) {
		Gson gson = new Gson();
		Menu[] menus = gson.fromJson(orderEntity.getMenu(), Menu[].class);
		List<SubOrderEntity> subOrdersList = Lists.newArrayList();
		int count = 0;
		for (Menu menu : menus) {
			SubOrderEntity subOrderEntity = new SubOrderEntity();
			subOrderEntity.setCourseFlag(menu.getCourseflag());
			subOrderEntity.setFoodItemMRP(menuCost.get(menu.getFoodkey()) * menu.getQuantity());
			subOrderEntity.setFoodKey(menu.getFoodkey());
			subOrderEntity.setFoodQuantity(menu.getQuantity());
			subOrderEntity.setOrderId(orderEntity.getOrderId());
			subOrderEntity.setOrphanageFlag(orderEntity.getOrphanageFlag());
			subOrderEntity.setSubOrderCancellationFlag(orderEntity.getOrderCancellationFlag());
			subOrderEntity.setSubOrderStatus(1);
			subOrderEntity.setSubOrderDate(new Date(menu.getDate().getTime()));
			subOrderEntity.setSubOrderId(
					count < 10 ? orderEntity.getOrderId() + "0" + ++count : orderEntity.getOrderId() + ++count);
			if (menu.getCourseflag() == 1) {
				subOrderEntity.setAddressKey(orderEntity.getBfAddress());
				subOrderEntity.setDeliveryTime(orderEntity.getBreakfastTime());
			} else if (menu.getCourseflag() == 2) {
				subOrderEntity.setAddressKey(orderEntity.getLunchAddress());
				subOrderEntity.setDeliveryTime(orderEntity.getLunchTime());
			} else {
				subOrderEntity.setDeliveryTime(orderEntity.getDinnerTime());
				subOrderEntity.setAddressKey(orderEntity.getDinnerAddress());
			}
			subOrdersList.add(subOrderEntity);
		}
		return subOrdersList;
	}
}
