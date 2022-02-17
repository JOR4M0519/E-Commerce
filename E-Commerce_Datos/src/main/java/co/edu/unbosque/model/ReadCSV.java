package co.edu.unbosque.model;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadCSV {


	private Data classData;
	private ArrayList<Data> data =new ArrayList<Data>();


	public void readData() {
		FileReader archCSV = null;
		CSVReader csvReader = null;


		try{
			archCSV = new FileReader("./Data/data.csv");
			CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
			csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
			List<String[]> datos = csvReader.readAll();

			for (int i = 1; i < datos.size(); i++) {

				String invoiceNO;
				String stockCode;
				String description;
				String invoiceDate;
				String country;
				double unitPrice;
				int quantity;
				long customerID;
				

				try {
					unitPrice = Double.parseDouble(datos.get(i)[0].split(",")[5]);
				}catch(NumberFormatException e){
					unitPrice = 0;
				}
				try {
					quantity = Integer.parseInt(datos.get(i)[0].split(",")[3]);
				}catch(NumberFormatException e) {
					quantity=0;
				}
				try {
					customerID= Long.parseLong(datos.get(i)[0].split(",")[6]);
				}catch(NumberFormatException e) {
					customerID=0;
				}

				invoiceNO =datos.get(i)[0].split(",")[0];
				stockCode = datos.get(i)[0].split(",")[1];
				description = datos.get(i)[0].split(",")[2];
				invoiceDate = datos.get(i)[0].split(",")[4];
				country = datos.get(i)[0].split(",")[7];

				classData =new Data(invoiceNO, stockCode, description, quantity, invoiceDate, unitPrice, customerID, country);
				data =new ArrayList<Data>();
				data.add(classData);

			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try { 
				archCSV.close();
				csvReader.close();
			}
			catch(IOException e) {
				System.out.println(e);
			}
		}
	}


	public ArrayList<Data> getData() {
		return data;
	}


	public void setData(ArrayList<Data> data) {
		this.data = data;
	}
	

}


