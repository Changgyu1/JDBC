package com.kh.MVC.orders;

import java.util.List;

public class OrdersView {
	
	public void showTotalPrice(double totalPrice) {
		System.out.println("√— ∏≈√‚ : " + totalPrice);
	}
	
	public void AllOrdersList(List<OrdersDTO> orders) {
		for(OrdersDTO o : orders) {
			System.out.println();
			System.out.println("cafe_id : " + o.getCafe_id());
			System.out.println("menu_id : " + o.getMenu_id());
			System.out.println("Quantity : " + o.getQuantity());
			System.out.println("totalPrice : " + o.getTotal_price());
		}
	}
	
	public void selectTotalPrice(int select, double totalPrice) {
		System.out.println(select + "¿« √— ∏≈√‚ : " + totalPrice);
	}
}
