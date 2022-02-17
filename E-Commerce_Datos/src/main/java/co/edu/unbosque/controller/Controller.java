package co.edu.unbosque.controller;

import co.edu.unbosque.model.ReadCSV;

public class Controller {

	private ReadCSV rca;
	public Controller() {

		rca = new ReadCSV();
		rca.readData();
	}
}
