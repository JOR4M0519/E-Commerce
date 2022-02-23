package co.edu.unbosque.controller;

import co.edu.unbosque.model.Commerce;
import co.edu.unbosque.model.Data;
import co.edu.unbosque.view.View;

public class Controller {

	private Commerce commerce;
	private View view;

	public Controller() {

		commerce = new Commerce();
		view = new View();
		view.exportWindows("Welcome to E-Commerce-Data View", "E-Commerce", 2);
		boolean salir = false;

		while(!salir) {

			int menu = view.menuLau();

			if(menu==1) {
				view.exportWindows("Suma venta totales: "+commerce.sumTotSales(), "Suma total ventas", 1);
			}else if(menu==2) {

				view.exportWindows("Resultado de la busqueda:\n"+commerce.findByInvoiceNo(view.inputWindows("Ingrese el numero", null, 1)).toString(), "Texto", 1);	

			}else if(menu==3) {

				String code = view.inputWindows("Ingrese el codigo", null, 1);
				if(commerce.countByStockCode(code.toLowerCase())+commerce.countByStockCode(code.toUpperCase())!=00) {
					view.exportWindows(""+commerce.countByStockCode(code.toLowerCase())+commerce.countByStockCode(code.toUpperCase()), "Suma total ventas", 1);	
				}else {
					view.exportWindows("El codigo ingresado es incorrecto o no se encuentra dentro del sistema.", "Suma total ventas", 1);
				}

			}else if(menu==4) {
				
				System.out.println(commerce.findPartiallyByDescription("MUG", salir, menu, menu).toString()+"\n");
			}else if(menu==5) {
				System.out.println(commerce.findPartiallyByDescription("MUG", view.validationWindows("Ordenar por producto mas ventido", "Que opina"), 1, 2));
			}else if(menu==0) {
				salir = true;
			}

		}

	}
}
