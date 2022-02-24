package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {

	/**
	 * Método que muestra en pantalla el menú de selección principal.
	 * <b>pre</b>JOptionPane de la librería swing está importado.
	 * <b>post</b>Muestra en pantalla el menú de selección principal.<br>
	 * <b>post</b>Recibe un entero correspondiente al número seleccionado del menú.<br>
	 * @return number Es el número que el usuario selecciono del menú.
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

	/**
	 * Solicita al usuario el ingreso de un dato por pantalla por medio de JOptionPane.
	 * <b>pre</b>JOptionPane de la librería swing está importado.
	 * <b>post</b>Muestra una ventana que solicita datos al usuario.<br>
	 * <b>post</b>Recibe datos ingresados por el usuario.<br>
	 * @param info Es un string correspondiente al mensaje de solicitud que se le muestra al usuario.
	 * @param title Es un string que corresponde al título de la ventana mostrada en pantalla.
	 * @param messageType Es un dato de tipo entero que corresponde al tipo de ventana que se muestra.
	 * @return Un string que corresponde a los datos obtenidos por la ventana que ingresa el usuario.
	 */
	public String inputWindows(String info, String title, int messageType) {
		return JOptionPane.showInputDialog(null, info, title, messageType);
	}

	/**
	 * 
	 * @param info
	 * @param title
	 * @param messageType
	 */
	public void exportWindows(String info, String title, int messageType) {
		JOptionPane.showMessageDialog(null, info, title, messageType);
	}

	/**
	 * 
	 * @param info
	 * @param title
	 * @return
	 */
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
