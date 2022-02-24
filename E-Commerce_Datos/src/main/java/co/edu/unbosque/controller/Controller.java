package co.edu.unbosque.controller;

import co.edu.unbosque.model.Commerce;
import co.edu.unbosque.view.View;

public class Controller {

    private Commerce commerce;
    private View view;
    private boolean salir;

    public Controller() {

        commerce = new Commerce();
        view = new View();
        salir = false;
        
        view.exportWindows("Welcome to E-Commerce-Data View", "E-Commerce", 2);
        functions();
        
    }
  	/**
	 * Se encarga de unir los métodos del modelo con la vista. 
	 * <b>pre</b>la clase commerce y view deben estar importadas.
	 * <b>post</b>se unifican los métodos de la vista con el modelo.<br>
	 */
	public void functions() {
        
	        while(!salir) {

            int menu = view.menu();

			switch(menu) {
			
			case 1: 
			view.exportWindows("Sum total sales is: "+commerce.sumTotSales(), "E-COMMERCE", 1);
				break;
	
			case 2:
			String invoiceNo = view.inputWindows("Enter invoice number: ", "E-COMMERCE", 1);
			
			if(commerce.findByInvoiceNo(invoiceNo) != null) {
				view.exportWindows(commerce.findByInvoiceNo(invoiceNo).toString().replaceAll(",", ""), "E-COMMERCE", 1);
			}else {
				view.exportWindows("Invalid invoice number, please try again","E-COMMERCE Error",2);	
			}
			
			
				break;
				
			case 3:
			String code = view.inputWindows("Enter the Stock Code", "E-COMMERCE", 1);
                if(commerce.countByStockCode(code.toLowerCase())+commerce.countByStockCode(code.toUpperCase())!=0) {
                    view.exportWindows("The quantity of "+code+" product(s) sold was: "+commerce.countByStockCode(code.toLowerCase())+commerce.countByStockCode(code.toUpperCase()), "E-COMMERCE", 1);
                }else {
                    view.exportWindows("The entered Stock code is incorrect or is not in the database.", "E-COMMERCE Error", 1);
                }
			
				break;
			
			case 4:
				if(view.validationWindows("Do you want to see the average sales per country?", "E-COMMERCE Filter")) {
                    view.exportConsole(commerce.avgMonthlySales(true));
                }else{
                    view.exportConsole(commerce.avgMonthlySales(false));
                }  
				break;
				
			case 5:
				String keyword = view.inputWindows("Enter de hint name, which you wish to find", "E-COMMERCE KeyWord", 1);
			
				if(view.validationWindows("Would you like to filter the search through month range and grouping of countries?", "E-COMMERCE Filter")) {
					
					int initMonth = Integer.parseInt(view.inputWindows("Enter the initial month to filter", "E-COMMERCE Initial Month", 1));
					int endMonth = Integer.parseInt(view.inputWindows("Enter the final month to filter", "E-COMMERCE Final Month", 1));
					
					if(commerce.findPartiallyByDescription(keyword, true, initMonth, endMonth)=="") {
						view.exportConsole("No information in data base");
					}else {
						view.exportConsole(commerce.findPartiallyByDescription(keyword, true, initMonth, endMonth));
					}
					
						
				}else {
					view.exportConsole(commerce.findPartiallyByDescription(keyword, false, 0, 0));
				}
				break;
			
			case 0: 
			view.exportWindows("Thank you, have a nice day :D", "Exit", 1);
				break;
				
				default:
					view.exportWindows("Invalid number, please try again", "E-COMMERCE Error", 0);
					break;
			}
        }
		
	}
}