package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
	
	
	public ArrayList<Data> orderDescription(){
		ArrayList<Data> dataDescription =new ArrayList<Data>();
		
		
		
		
		return dataDescription;
		
		
	}

	
	
	public List<Data> findPartiallyByDescription(String search, boolean order, int initMonth, int endMonth) {
		List<Data> dataDescription =new ArrayList<Data>();
		Data dataa =null;

		for(int x=0;x<readCSV.getData().size();x++) {
			if(readCSV.getData().get(x).getDescription().contains(search)) {
				dataa=readCSV.getData().get(x);
				dataDescription.add(dataa);
				
				 Collections.sort(dataDescription);

//				if(order) {
//
//					if(readCSV.getData().get(x).getQuantity()>=readCSV.getData().get(x+1).getQuantity()) {
//						String mayor = readCSV.getData().get(x).getDescription()+": "+readCSV.getData().get(x).getQuantity()+"\n";
//						String menor = readCSV.getData().get(x+1).getDescription()+": "+readCSV.getData().get(x+1).getQuantity()+"\n";
//					
//
//						if(readCSV.getData().get(x).getQuantity()<=readCSV.getData().get(x-1).getQuantity()) {
//							
//							String medio= readCSV.getData().get(x).getDescription()+": "+readCSV.getData().get(x).getQuantity()+"\n";
//							
//							String menor= readCSV.getData().get(x).getDescription()+": "+readCSV.getData().get(x).getQuantity()+"\n";
//							readCSV.getData().add(x, readCSV.getData().get(x-1));
//							readCSV.getData().add(x-1, menor);
//						}
//
//					}else {
//
//						if(readCSV.getData().get(x).getQuantity()<=readCSV.getData().get(x-1).getQuantity()) {
//							Data menor= readCSV.getData().get(x);
//							readCSV.getData().add(x, readCSV.getData().get(x-1));
//							readCSV.getData().add(x-1, menor);
//						}	
//					}
//
//				}else {
//					information= readCSV.getData().get(x).getDescription()+": "+readCSV.getData().get(x).getQuantity()+"\n"+information;	
//				}
			
			
			}
			
			

		}

		return dataDescription;
	}


	public ReadCSV getReadCSV() {
		return readCSV;
	}

	public void setReadCSV(ReadCSV readCSV) {
		this.readCSV = readCSV;
	}

}
