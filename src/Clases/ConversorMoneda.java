package Clases;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.parser.JSONParser;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;


public class ConversorMoneda {
	
	private Object eleccionLista;
	private boolean convertir;
	private double valorIngresado;
	public String monedaConversion;
	
	public void IngresarCantidad() {
		valorIngresado = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que deseas convertir"));
	}
	
	public String MiMoneda(String miPais) {
		String nombreMoneda = "";
		
		try {
			nombreMonedas nm = new nombreMonedas();
			JSONObject json = new JSONObject(nm.monedas);
			nombreMoneda = json.getString(miPais);  
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return nombreMoneda;
	}
	public static String[] removeElement(String[] arr, String item) {
        return Arrays.stream(arr)
                .filter(s -> !s.equals(item))
                .toArray(String[]::new);
    }
	public String[] ListaMonedas(String miPais) {
		
		String[] lista = { miPais + " a Dólar",
						   miPais + " a Euro",
						   miPais + " a Libras Esterlinas",
						   miPais + " a Yen Japonés",
						   miPais + " a Won sur-coreano",
						   "Dólar a " + miPais,
						   "Euro a " + miPais,
						   "Libras Esterlinas a " + miPais,
						   "Yen Japonés a " + miPais,
						   "Won sur-coreano a " + miPais } ;	
				
		String item = miPais + " a " + miPais;
		lista = removeElement(lista, item);              		
		
		return lista;
	}
	
	
	
	public void TipoMoneda(String[] lista) {
		
		eleccionLista = JOptionPane.showInputDialog(null,"Elige la moneda a la que deseas convertir tu dinero", "Monedas",JOptionPane.QUESTION_MESSAGE, null, lista, lista[0]);

		
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
