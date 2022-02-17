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

public class ReadCsvApp {

    public List<Datos> readFromPath(String localPath) {
        try {
        	System.out.println("Direccion:"+localPath);
        	// Creating the path object representing the file to be read
            URI uri = ClassLoader.getSystemResource(localPath).toURI();
            
            Path path = Paths.get(uri);

            // Creating the strategy to read the CSV and the bean for casting
            // Could be by header names or column positions
            HeaderColumnNameMappingStrategy ms = new HeaderColumnNameMappingStrategy();
            ms.setType(Datos.class);

            // Reading the file, setting the strategy and custom separator
            Reader reader = Files.newBufferedReader(path);
            CsvToBean cb = new CsvToBeanBuilder(reader).withType(Datos.class)
                    .withMappingStrategy(ms)
                    .withSeparator(',')
                    .build();

            // Extracting result previous to close the reader
            CSVTransfer csvTransfer = new CSVTransfer();
            csvTransfer.setCsvList(cb.parse());
            reader.close();

            return csvTransfer.getCsvList();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ArrayList<Datos>();
    }

    public static void main(String[] args) {
    	FileReader archCSV = null;
        CSVReader csvReader = null;
        
    	try{
    	archCSV = new FileReader("./Data/dataa.csv");
        CSVParser conPuntoYComa = new CSVParserBuilder().withSeparator(';').build();
        csvReader = new CSVReaderBuilder(archCSV).withCSVParser(conPuntoYComa).build();
        List<String[]> datos = csvReader.readAll();
        System.out.println(datos.get(10)[0].split(","));
//        String[] fila = null;
//        while((fila = csvReader.readNext()) != null) {
//            System.out.println(fila[0]
//                      + " | " + fila[1]
//                      + " |  " + fila[2]);
//        }

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
    	
//        System.out.println("Reading a CSV using OpenCSV library");
//        String[] fila = null;
//        try {
//        	CSVReader csvReader = new CSVReader(new FileReader("./Data/data.csv"));
//	        while((fila = csvReader.readNext()) != null) {
//	            System.out.println(fila[0]
//	                      + " | " + fila[1]
//	                      + " |  " + fila[2]);
//	        }
//
//	        csvReader.close();
//        } catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//       

        
//        List<Datos> result = new ReadCsvApp().readFromPath("./Data/data.csv");
//        for (Datos r : result) {
//            System.out.println(r.toString());
       
    }


