package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	
	/**
	 * Clase que muestra el menu de seleccion principal.
	 * 
	 * @return
	 */

	public int menu() {

		boolean salir = false;
		int number=0;

		while(!salir) {
			number = Integer.valueOf(JOptionPane.showInputDialog(null, "1. Show all total sales" + "\n"
					+ "2. Find details by invoice number"+ "\n"
					+ "3. Count all products sold by stock code"+ "\n"
					+ "4. Average monthly sales by country"+ "\n"
					+ "5. Find partially by description"+ "\n"
					+ "0. Exit", "menu", 1));
			if(number<=5 && number>=0) {
				salir = true;
			}
		}

		return number;
	}

	public String inputWindows(String info, String title, int messageType) {
		return JOptionPane.showInputDialog(null, info, title, messageType);
	}

	public void exportWindows(String info, String title, int messageType) {
		JOptionPane.showMessageDialog(null, info, title, messageType);
	}

	public boolean validationWindows(String info, String title) {
		int answer = JOptionPane.showConfirmDialog(null, info, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(answer == 0) {
			return true;
		}else {
			return false;
		}

	}

}
