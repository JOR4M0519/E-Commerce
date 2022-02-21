package co.edu.unbosque.model;

import java.util.ArrayList;

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

	public String findPartiallyByDescription(String search, boolean order, int initMonth, int endMonth) {
		String information="";
		ArrayList<Data> ordenar = new ArrayList<Data>();
		int number = 0;

		for(int x=0;x<readCSV.getData().size();x++) {
			String ver= readCSV.getData().get(x).getDescription();
			if(ver.contains(search)) {

				if(order) {

//					if(ordenar.size()!=0) {
//						
//						if(readCSV.getData().get(x).getQuantity()>=ordenar.get(ordenar.size()-1).getQuantity()) {
//                             
//						}
//						
//					}else {
//						ordenar.add(readCSV.getData().get(x));
//					}





					//					ArrayList<Data> orden = new ArrayList<Data>();

					//					if(number<=readCSV.getData().get(x).getQuantity()) {
					//						number = readCSV.getData().get(x).getQuantity();
					//						information= readCSV.getData().get(x).getDescription()+": "+readCSV.getData().get(x).getQuantity()+"\n"+information;
					//					}else {
					//						information= information+"\n"+readCSV.getData().get(x).getDescription()+": "+readCSV.getData().get(x).getQuantity();
					//					}

				}else {
					information= readCSV.getData().get(x).getDescription()+": "+readCSV.getData().get(x).getQuantity()+"\n"+information;	
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
