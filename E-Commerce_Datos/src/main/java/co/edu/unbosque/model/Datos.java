package co.edu.unbosque.model;

import com.opencsv.bean.CsvBindByName;

public class Datos {

	@CsvBindByName(column = "InvoiceNo")
	private long invoiceNo;
	
	@CsvBindByName(column = "StockCode")
	private String stockCode;
	
	@CsvBindByName(column = "Description")
	private String description;
	
	@CsvBindByName(column = "Quantity")
	private int quantity;
	
	@CsvBindByName(column = "InvoiceDate")
	private String invoiceDate;
	
	@CsvBindByName(column = "UnitPrice")
	private double unitPrice;
	
	@CsvBindByName(column = "CustomerID")
	private long customerID;
	
	@CsvBindByName(column = "Country")
	private String country;
	
	//get & setters
	public long getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Datos [invoiceNo=" + invoiceNo + ", stockCode=" + stockCode + ", description=" + description
				+ ", quantity=" + quantity + ", invoiceDate=" + invoiceDate + ", unitPrice=" + unitPrice
				+ ", customerID=" + customerID + ", country=" + country + "]";
	}
	
	
	
	

}
