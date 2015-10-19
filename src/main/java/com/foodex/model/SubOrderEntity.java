package com.foodex.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "fe_sub_orders")
public class SubOrderEntity {
	@JoinColumn
	@Column(name = "order_id")
	private String orderId;
	@Id
	@Column(name = "sub_order_id")
	private String subOrderId;
	@Column(name = "sub_order_date")
	private Date subOrderDate;
	@Column(name = "cook_key")
	private String cookKey;
	@Column(name = "delivery_boy_key")
	private String deliveryBoyKey;
	@Column(name = "food_key")
	private int foodKey;
	@Column(name = "food_quantity")
	private int foodQuantity;
	@Column(name = "food_item_mrp")
	private double foodItemMRP;
	@Column(name = "address_key")
	private int addressKey;
	@Column(name = "delivery_time")
	private Timestamp deliveryTime;
	@Column(name = "order_status")
	private int orderStatus;
	@Column(name = "orphanage_flag")
	private int orphanageFlag;
	@Column(name = "sub_order_cancellation_flag")
	private int subOrderCancellationFlag;
	@Column(name = "course_flag")
	private int courseFlag;
	@Column(name = "sub_order_status")
	private int subOrderStatus;
	@Column(name = "insert_date")
	private Date insertDate;
	@Column(name = "update_date")
	private Date updateDate;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSubOrderId() {
		return subOrderId;
	}

	public void setSubOrderId(String subOrderId) {
		this.subOrderId = subOrderId;
	}

	public Date getSubOrderDate() {
		return subOrderDate;
	}

	public void setSubOrderDate(Date subOrderDate) {
		this.subOrderDate = subOrderDate;
	}

	public String getCookKey() {
		return cookKey;
	}

	public void setCookKey(String cookKey) {
		this.cookKey = cookKey;
	}

	public String getDeliveryBoyKey() {
		return deliveryBoyKey;
	}

	public void setDeliveryBoyKey(String deliveryBoyKey) {
		this.deliveryBoyKey = deliveryBoyKey;
	}

	public int getFoodKey() {
		return foodKey;
	}

	public void setFoodKey(int foodKey) {
		this.foodKey = foodKey;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public double getFoodItemMRP() {
		return foodItemMRP;
	}

	public void setFoodItemMRP(double foodItemMRP) {
		this.foodItemMRP = foodItemMRP;
	}

	public int getAddressKey() {
		return addressKey;
	}

	public void setAddressKey(int addressKey) {
		this.addressKey = addressKey;
	}

	public Timestamp getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Timestamp deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrphanageFlag() {
		return orphanageFlag;
	}

	public void setOrphanageFlag(int orphanageFlag) {
		this.orphanageFlag = orphanageFlag;
	}

	public int getSubOrderCancellationFlag() {
		return subOrderCancellationFlag;
	}

	public void setSubOrderCancellationFlag(int subOrderCancellationFlag) {
		this.subOrderCancellationFlag = subOrderCancellationFlag;
	}

	public int getCourseFlag() {
		return courseFlag;
	}

	public void setCourseFlag(int courseFlag) {
		this.courseFlag = courseFlag;
	}

	public int getSubOrderStatus() {
		return subOrderStatus;
	}

	public void setSubOrderStatus(int subOrderStatus) {
		this.subOrderStatus = subOrderStatus;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "SubOrderEntity [orderId=" + orderId + ", subOrderId=" + subOrderId + ", subOrderDate=" + subOrderDate
				+ ", cookKey=" + cookKey + ", deliveryBoyKey=" + deliveryBoyKey + ", foodKey=" + foodKey
				+ ", foodQuantity=" + foodQuantity + ", foodItemMRP=" + foodItemMRP + ", addressKey=" + addressKey
				+ ", deliveryTime=" + deliveryTime + ", orderStatus=" + orderStatus + ", orphanageFlag=" + orphanageFlag
				+ ", subOrderCancellationFlag=" + subOrderCancellationFlag + ", courseFlag=" + courseFlag
				+ ", subOrderStatus=" + subOrderStatus + ", insertDate=" + insertDate + ", updateDate=" + updateDate
				+ "]";
	}

}
