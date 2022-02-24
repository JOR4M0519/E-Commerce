package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Commerce {

	private ReadCSV readCSV;

	/**
	 * Este método inicializa los objetos y ejecuta los métodos escritos.
	 * <b>pre</b>Los objetos están declarados.
	 * <b>post</b> Inicializa el objeto readCSV. <br>
	 * <b>post</b> Ejecuta el método readCSV.uploadData <br>
	 */
	public Commerce() {
		readCSV = new ReadCSV();
		readCSV.uploadData();	
	}

	/**
	 *Calcula el total de ventas de la tienda.
	 * <b>pre</b>totSales es una varible inicializada en 0.0 en la que se almacena el resultado de la suma de todas las ventas.
	 * <b>pre</b>El objeto readCSV esta inicializado.
	 * <b>post</b> Recorre el ArrayList del readCSV sumando el atributo UnitPrice de cada uno de los elementos. <br>
	 * @return totSales es un dato de tipo double equivalente a la suma total de las ventas de la tienda.
	 */
	public double sumTotSales() {
		double totSales =0.0 ;
		for (int i = 0; i < readCSV.getData().size(); i++) {
			totSales =Math.round((readCSV.getData().get(i).getQuantity()*readCSV.getData().get(i).getUnitPrice() + totSales)*100.0)/100.0;
		}
		return totSales;
	}

	/**
	 * Recorre el ArrayList de objetos de tipo Data comparando el atributo invoiceNo de cada no de los elementos con el pasado por parámetros.
	 * <b>pre</b> El objeto readCSV esta inicializado.
	 * <b>post</b> Compara el invoiceNo de cada uno de los ArrayList con el invoiceNo pasado por parámetro para encontrar similitudes. <br>
	 * <b>post</b>Almacena en un ArrayList los objetos de tipo Data encontrados como similares con respecto al invoiceNo pasado por parámetro. <br>
	 * @param invoiceNo Es un string que corresponde al número de la factura a buscar.
	 * @return dataInvoiceNo Es un ArrayList de objetos de tipo Data en los que el atributo invoiceNo coinciden con los pasados por parámetro.
	 */
	public ArrayList<Data> findByInvoiceNo(String invoiceNo) {
		ArrayList<Data> dataInvoiceNo =new ArrayList<Data>();	
		for (int i = 0; i < readCSV.getData().size(); i++) {
			if(readCSV.getData().get(i).getInvoiceNo().equals(invoiceNo)) {
				dataInvoiceNo.add(readCSV.getData().get(i));
			}
		}
		return dataInvoiceNo;
	}

	/**
	 * Este metodo se encarga de contar los productos por un parametro de código.
	 * <b>pre</b> Insertar el dato del código.
	 * <b>post</b> Retornar la cantidad de productos. <br>
	 * @param stockCode Es un String que  corresponde al código del producto.
	 * @return quantity Es un int que guarda la cantidad de productos con el código.
	 */
	public int countByStockCode(String stockCode) {
		int quantity=0;
		for (int i = 0; i < readCSV.getData().size(); i++) {
			if(readCSV.getData().get(i).getStockCode().equals(stockCode)) {
				quantity= readCSV.getData().get(i).getQuantity()+quantity;
			}	
		}

		return quantity;
	}


	/**
	 * Este método se encarga de calcular el promedio mensual.
	 * <b>pre</b> Poseer un valor de verdad la variable groupByCountry.
	 * <b>post</b> Retorna el promedio mensual general o por país. <br>
	 * @param groupByCountry Es un boolean que se encarga de validar la función de agrupamiento por país.
	 * @return infoTotal Es un String que retorna el promedio de ventas mensual.
	 */
	public String avgMonthlySales(boolean groupByCountry) {
		String infoTotal="";

		if(groupByCountry) {
			List<String> countries = new ArrayList();
			countries.add(readCSV.getData().get(0).getCountry());

			for (int i = 1; i < readCSV.getData().size(); i++) {
				if(!countries.contains(readCSV.getData().get(i).getCountry())) {
					countries.add(readCSV.getData().get(i).getCountry());
				}
			}

			double countriesAVG[] = new double[countries.size()];

			for (int j = 0; j < countries.size(); j++) {
				for (int i = 0; i < readCSV.getData().size(); i++) {
					if(countries.get(j).equals(readCSV.getData().get(i).getCountry())) {
						countriesAVG[j] = countriesAVG[j] + (readCSV.getData().get(i).getUnitPrice()*readCSV.getData().get(i).getQuantity()); 
					}
				}
				countriesAVG[j]= (Math.round((countriesAVG[j]/12)*100.00))/100.00;
				infoTotal = countries.get(j)+": $"+ countriesAVG[j]+"\n"+infoTotal;
			}

		}else {

			infoTotal= "Promedio de ventas mensual es: $ " +((Math.round((sumTotSales()/12)*100.00))/100.00);
		}

		return infoTotal;
	}


	/**
	 * Retorna la lista de descripciones que coinciden parcialmente con el criterio de búsqueda incluyendo la cantidad de unidades vendidas con la opción de ordenar por el producto más vendido y filtrar por rango de meses 
	 * <b>pre</b> Los parametros deben tener valor.
	 * <b>post</b> El metodo retornara descripcion cantidad y fecha. <br>
	 * @param search Palabra clave de búsqueda de la descripción.
	 * @param order Opción para ordenar o mantener el orden del arraylist.
	 * @param initMonth Funciona para saber el mes inicial.
	 * @param endMonth Funciona para ver el mes final.
	 * @return information Se guardan todos los datos buscados. 
	 */
	public String findPartiallyByDescription(String search, boolean order, int initMonth, int endMonth) {
		String information = "";

		if(order) {
			Collections.sort(readCSV.getData(), new Comparator<Data>() {

				public int compare(Data o1, Data o2) {

					return new Integer(o2.getQuantity()).compareTo(new Integer(o1.getQuantity()));
				}
			});

			for(int x=0;x<readCSV.getData().size();x++) {
				for (int i = initMonth-1; i <=(endMonth-initMonth); i++) {
					if(readCSV.getData().get(x).getDescription().contains(search)&&readCSV.getData().get(x).getInvoiceDate().getMonth()==i) {
						information= readCSV.getData().get(x).getDescription()+": "+readCSV.getData().get(x).getQuantity()+" "+readCSV.getData().get(x).getInvoiceDate()+"\n"+information;	
					}
				}
			}
			
		} else {
			for(int x=0;x<readCSV.getData().size();x++) {
				if(readCSV.getData().get(x).getDescription().contains(search)) {
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