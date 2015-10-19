package com.foodex.business;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.foodex.util.HibernateUtil;

public class OrderRouting {
	public static void main(String[] args) {
		routeOrder();
	}

	public static void routeOrder() {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			List<?> list = session
					.createQuery(
							"from com.foodex.model.OrderEntity order INNER JOIN com.foodex.model.SubOrderEntity sub where order.orderId=sub.orderId")
					.list();
			for (Object arr : list) {
				System.out.println(arr);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
                                                                      