package com.kh.MVC.orders;

import java.util.List;

public class OrdersController {
	private OrdersDAO dao;
	
	public OrdersController(OrdersDAO dao) {
		this.dao = dao;
	}
	
	public double calculateTotalPrice(List<OrdersDTO> orders) {
		double totalPrice = 0;
		for(OrdersDTO totalO : orders) {
			totalPrice += totalO.getTotal_price();
		}
		return totalPrice;
	}

	
	public List<OrdersDTO> getAllOrders(){
		return dao.getAllOrders();
	}
	public List<OrdersDTO> getSelectOrders(int select){
		return dao.selectCafeTotalPrice(select);
	}
}
