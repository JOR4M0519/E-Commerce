package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Commerce {

	private ReadCSV readCSV;
	private Data data;

	public Commerce() {
		data = new Data(null, null, null, 0, null, 0, 0, null);
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
	
	public <T> String findPartiallyByDescription(String search, boolean order, int initMonth, int endMonth) {
		String information = "";

		if(order) {
			Collections.sort(readCSV.getData(), new Comparator<Data>() {

				public int compare(Data o1, Data o2) {

					return new Integer(o2.getQuantity()).compareTo(new Integer(o1.getQuantity()));
				}
			});	
		}

		for(int x=0;x<readCSV.getData().size();x++) {
			for (int i = initMonth-1; i <=(endMonth-initMonth); i++) {
				if(readCSV.getData().get(x).getDescription().contains(search)&&readCSV.getData().get(x).getInvoiceDate().getMonth()==i) {
					information= readCSV.getData().get(x).getDescription()+": "+readCSV.getData().get(x).getQuantity()+" "+readCSV.getData().get(x).getInvoiceDate()+"\n"+information;	
				}
			}
		}

		return information;
	}

	public ReadCSV getReadCSV() {
		return readCSV;
	}

	public void setReadCSV(ReadCSV readCSV) {
		this.readCSV = readCSV;
	}

}
