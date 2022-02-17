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
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {


	public void readData() {
		FileReader archCSV = null;
		CSVReader csvReader = null;

		try{
			archCSV = new FileReader("./Data/data.csv");
			CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
			csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
			List<String[]> datos = csvReader.readAll();
			System.out.println(datos.get(10)[0]);


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

}


