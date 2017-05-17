//package org.test;
//
//import java.util.Date;
//
//import org.Form.OrderTraineeForm;
//import org.dao.OrderDao;
//import org.dao.imp.OrderDaoImp;
//import org.model.Order;
//
//public class test08 {
//	public static void main(String[] args) {
//		OrderDao oDao = new OrderDaoImp();
//
//		Order o = new Order("a", 0, new Date().getTime() / 1000, 8L);
//
//		String[] name = { "h", "j" };
//		Integer[] sex = { 1, 0 };
//		Long[] birthday = { 1L, 2L };
//		String[] ad = { "q", "w" };
//		Long[] orderId = { 1L, 3L };
//
//		OrderTraineeForm ot = new OrderTraineeForm(name, sex, birthday, ad, ad,
//				ad, ad, ad, ad, orderId);
//
//		System.out.println(oDao.addOrder(o, ot));
//
//	}
//}