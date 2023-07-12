package Clases;

import javax.swing.JOptionPane;

public class ConversorMoneda {
	
	private Object eleccionLista;
	private boolean convertir;
	private double valorIngresado;
	public String monedaConversion;
	
	public void IngresarCantidad() {
		valorIngresado = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que deseas convertir"));
	}
	
	public String[] ListaMonedas(String miMoneda) {
		
		String[] lista = { miMoneda + " a Dólar",
				 miMoneda + " a Euros",
				 miMoneda + " a Libras Esterlinas",
				 miMoneda + " a Yen Japonés",
				 miMoneda + " a Won sul-coreano",
				 "Dólar a " + miMoneda,
				 "Euros a " + miMoneda,
				 "Libras Esterlinas a " + miMoneda,
				 "Yen Japonés a " + miMoneda,
				 "Won sul-coreano a " + miMoneda}; 
		
		return lista;
	}
	
	public void TipoMoneda(String[] lista) {
		
		eleccionLista = JOptionPane.showInputDialog(null,"Elige la moneda a la que deseas convertir tu dinero", "Monedas",JOptionPane.QUESTION_MESSAGE,null,lista, lista[0]);
		
		if(lista[0] == eleccionLista.toString()) {
			monedaConversion = "USD";
			convertir = true;
		} else if (lista[1] == eleccionLista.toString()) {
			monedaConversion = "EUR";
			convertir = true;
		} else if (lista[2] == eleccionLista.toString()) {
			monedaConversion = "GBP";
			convertir = true;
		} else if (lista[3] == eleccionLista.toString()) {
			monedaConversion = "JPY";
			convertir = true;
		} else if (lista[4] == eleccionLista.toString()) {
			monedaConversion = "KRW";
			convertir = true;
		} else if (lista[5] == eleccionLista.toString()) {
			monedaConversion = "USD";
			convertir = false;
		} else if (lista[6] == eleccionLista.toString()) {
			monedaConversion = "EUR";
			convertir = false;
		} else if (lista[7] == eleccionLista.toString()) {
			monedaConversion = "GBP";
			convertir = false;
		} else if (lista[8] == eleccionLista.toString()) {
			monedaConversion = "JPY";
			convertir = false;
		} else if (lista[9] == eleccionLista.toString()) {
			monedaConversion = "KRW";
			convertir = false;
		}
	}
	
	public double ConvertirDivisa(double moneda2) {
		if(convertir == true) {
			return valorIngresado * moneda2;
		} else {
			return valorIngresado / moneda2;

		}
	}
}
