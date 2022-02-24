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
	
	/**
	 * Método constructor en donde inicializamos las variables.
	 * <b>pre</b>invoiceNo, stockCode, description, quantity, invoiceDate, 
	 * unitPrice, customerID y country son variables que son inicializadas en el método constructor.
	 * <b>post</b>invoiceNo, stockCode, description, quantity, invoiceDate, 
	 * unitPrice, customerID y country son los valores que se le asignan a sus respectivas variables.<br>
	 * @param invoiceNo String correspondiente al número de la factura.
	 * @param stockCode String correspondiente al código del producto.
	 * @param description String correspondiente al nombre del producto.
	 * @param quantity int correspondiente a la cantidad de productos.
	 * @param invoiceDate Date correspondiente a la fecha de la factura.
	 * @param unitPrice double correspondiente a al precio por unidad del producto.
	 * @param customerID long correspondiente al número de identificación del cliente.
	 * @param country String correspondiente al país en la que se realiza la factura.
	 */
	
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

	@Override
	public String toString() {
		return "Invoice Number = " + invoiceNo + ", Stock Code = " + stockCode + ", Description = " + description
				+ ", Quantity = " + quantity + ", Invoice Date = " + invoiceDate + ", Unit Price = " + unitPrice
				+ ", Customer ID = " + customerID + ", Country = " + country+"\n";
	}
	
}
