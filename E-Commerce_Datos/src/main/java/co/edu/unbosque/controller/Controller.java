package co.edu.unbosque.controller;

import co.edu.unbosque.model.Commerce;
import co.edu.unbosque.view.View;

public class Controller {

	private Commerce commerce;
	private View view;
	
	public Controller() {
		commerce = new Commerce();
		view = new View();
		view.exportWindows("Welcome to E-Commerce-Data View", "E-Commerce", 2);
		
		System.out.println("Suma venta totales: "+commerce.sumTotSales());
		System.out.println(commerce.findByInvoiceNo("536365").toString());
		String code = "85123A";
		System.out.println(commerce.countByStockCode(code.toLowerCase())+commerce.countByStockCode(code.toUpperCase()));
		System.out.println(commerce.avgMonthlySales()+"a");
		
	}
}
