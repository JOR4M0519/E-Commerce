package co.edu.unbosque.model;

import java.util.Date;

public class Data {

	private String invoiceNo;
	private String stockCode;
	private String description;
	private int quantity;
	private Date invoiceDate;
	private double unitPrice;
	private long customerID;
	private String country;
	
	public Data(String invoiceNo, String stockCode, String description, int quantity, Date invoiceDate,
			double unitPrice, long customerID, String country) {
		
		super();
		this.invoiceNo = invoiceNo;
		this.stockCode = stockCode;
		this.description = description;
		this.quantity = quantity;
		this.invoiceDate = invoiceDate;
		this.unitPrice = unitPrice;
		this.customerID = customerID;
		this.country = country;
		
	}
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
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
	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
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
	
	// @Override
     public int compareTo(Data o) {
        String a=new String(String.valueOf(this.getQuantity())+this.getDescription());
        String b=new String(String.valueOf(o.getQuantity())+o.getDescription());
        return a.compareTo(b);
    }

	@Override
	public String toString() {
		return "Data [invoiceNo=" + invoiceNo + ", stockCode=" + stockCode + ", description=" + description
				+ ", quantity=" + quantity + ", invoiceDate=" + invoiceDate + ", unitPrice=" + unitPrice
				+ ", customerID=" + customerID + ", country=" + country + "]"+"\n";
	}
	
}
