package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Commerce {
	private ReadCSV readCSV;
	
	
	public Commerce() {
		readCSV = new ReadCSV();
		readCSV.uploadData();	
	}
	
	public double sumTotSales() {
		double totSales =0.0 ;
		for (int i = 0; i < readCSV.getData().size(); i++) {
			totSales =Math.round((readCSV.getData().get(i).getQuantity()*readCSV.getData().get(i).getUnitPrice() + totSales)*100.0)/100.0;
		}
		return totSales;
	}
	
	public ArrayList<Data> findByInvoiceNo(String invoiceNo) {
		ArrayList<Data> dataInvoiceNo =new ArrayList<Data>();	
		for (int i = 0; i < readCSV.getData().size(); i++) {
			if(readCSV.getData().get(i).getInvoiceNo().equals(invoiceNo)) {
				dataInvoiceNo.add(readCSV.getData().get(i));
			}
		}
		return dataInvoiceNo;
	}
	
	public int countByStockCode(String stockCode) {
		int quantity=0;
		for (int i = 0; i < readCSV.getData().size(); i++) {
			if(readCSV.getData().get(i).getStockCode().equals(stockCode)) {
				quantity= readCSV.getData().get(i).getQuantity()+quantity;
			}
		}
		return quantity;
	}
	
	public double avgMonthlySales() {
		double n1 = 0.0;
		double sum = 0.0;
		
		for (int i = 0; i < readCSV.getData().size(); i++) {
			switch(readCSV.getData().get(i).getInvoiceDate().getMonth()) {
			case 1:
				//double sum = 0.0;
				sum = Math.round((readCSV.getData().get(i).getQuantity()*readCSV.getData().get(i).getUnitPrice() + sum)*100.00)/100.00;
				n1 = sum/i;
				break;
			}
			
		}
		
		return n1;
	}

	public ReadCSV getReadCSV() {
		return readCSV;
	}

	public void setReadCSV(ReadCSV readCSV) {
		this.readCSV = readCSV;
	}
	
	 

}
