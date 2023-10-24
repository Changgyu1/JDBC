package com.kh.MVC.orders;

import java.util.List;
import java.util.Scanner;

public class OrdersMain {
	public static void main(String[] args) {
		OrdersDAO dao = new OrdersDAO();
		OrdersController controller = new OrdersController(dao);
		OrdersView view = new OrdersView();

		List<OrdersDTO> orders = controller.getAllOrders();

		double totalPrice = controller.calculateTotalPrice(orders);
		//view.showTotalPrice(totalPrice);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 아이디를 입력해주세요!");
		int cafeid = sc.nextInt();
		
		List<OrdersDTO> orders1 = controller.getSelectOrders(cafeid);
		double totalPrice1 = controller.calculateTotalPrice(orders1);
		view.AllOrdersList(orders1);
		view.selectTotalPrice(cafeid, totalPrice1);
	}
}
	
