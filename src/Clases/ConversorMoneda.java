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
	private double valorIngresado;
	
	public String monedaConversion;
	private boolean convertir;
	private Character simbolo;
	public String nombreConversion;
	
	public void IngresarCantidad() {
		boolean bandera = false;
		
		do {
			try {
				valorIngresado = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de dinero que deseas convertir"));
				bandera = true;
				
				if(valorIngresado <= 0) {
					JOptionPane.showMessageDialog(null, "No se permite ingresar numeros negativos ni cero");
					bandera = false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Solo se permiten numeros");
				bandera = false;
			}
		} while (!bandera);	
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
		String[] arreglo = null;
		
		try {
			arreglo = Arrays.stream(arr)
	                .filter(s -> !s.equals(item))
	                .toArray(String[]::new);
		} catch (Exception e) {
			e.getMessage();
		}
        
		return arreglo;
    }
	public String[] ListaMonedas(String miPais) {
		String[] lista = null;

		try {
			lista = new String[] { miPais + " a Dólar",
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
			
		} catch (Exception e) {
			e.getMessage();
		}
		            		
		return lista;
	}
	
	public void TipoMoneda(String[] lista, String miPais) {
		try {	
			eleccionLista = JOptionPane.showInputDialog(null,"Elige la moneda a la que deseas convertir tu dinero", "Monedas",JOptionPane.QUESTION_MESSAGE, null, lista, lista[0]);

			if(lista[0] == eleccionLista.toString()) {
				monedaConversion = "USD";
				nombreConversion = "Dolares";
				convertir = true;
			} else if (lista[1] == eleccionLista.toString()) {
				monedaConversion = "EUR";
				nombreConversion = "Euros";
				convertir = true;
			} else if (lista[2] == eleccionLista.toString()) {
				monedaConversion = "GBP";
				nombreConversion = "Libras Esterlinas";
				convertir = true;
			} else if (lista[3] == eleccionLista.toString()) {
				monedaConversion = "JPY";
				nombreConversion = "Yenes Japoneses";
				convertir = true;
			} else if (lista[4] == eleccionLista.toString()) {
				monedaConversion = "KRW";
				nombreConversion = "Wones sur-coreanos";
				convertir = true;
			} else if (lista[5] == eleccionLista.toString()) {
				monedaConversion = "USD";
				nombreConversion = miPais;
				convertir = false;
			} else if (lista[6] == eleccionLista.toString()) {
				monedaConversion = "EUR";
				nombreConversion = miPais;
				convertir = false;
			} else if (lista[7] == eleccionLista.toString()) {
				monedaConversion = "GBP";
				nombreConversion = miPais;
				convertir = false;
			} else if (lista[8] == eleccionLista.toString()) {
				monedaConversion = "JPY";
				nombreConversion = miPais;
				convertir = false;
			} else if (lista[9] == eleccionLista.toString()) {
				monedaConversion = "KRW";
				nombreConversion = miPais;
				convertir = false;
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public Character SimboloMoneda(String miMoneda) {
		Character simbolo = null;
		
		try {
			if(monedaConversion == "EUR" && convertir == true) {
				simbolo = '€';
			} else if (miMoneda == "EUR" && convertir == false) {
				simbolo = '€';
			} else {
				simbolo = '$';
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return simbolo;
	}
	
	public double ConvertirDivisa(double moneda2) {
		double conversion = 0;
		
		try {
			if(convertir == true) {
				conversion = valorIngresado * moneda2;
			} else {
				conversion = valorIngresado / moneda2;

			}
		} catch (Exception e) {
			e.getMessage();
		}
	
		return conversion;
	}
}
