package Clases;

import javax.swing.JOptionPane;

import APIs.APImonedas;

public class Menu {

	public static void main(String[] args) {
		
		try {
			int resp;
			
			do {
				String[] opciones = {"Conversor de Moneda","Conversor de Temperatura"};
				
				Object opcion = JOptionPane.showInputDialog(null,"Seleccione una opción de conversión", "Menu",JOptionPane.QUESTION_MESSAGE,null,opciones, opciones[0]);
				
				
				switch (opcion.toString()) {
					case "Conversor de Moneda":
						
						// Obtine la ubicacion del cliente y el tipo de moneda
						APImonedas ubicacion = new APImonedas();
						ubicacion.ConsumoAPI("https://api.vatcomply.com/geolocate");
						ubicacion.MiUbicacionMoneda();
						
						// Obtiene el valor de la moneda a convertir
						APImonedas moneda = new APImonedas();
						moneda.ConsumoAPI("https://api.exchangerate.host/latest?base=" + ubicacion.miMoneda);
						
						//Instancia del Objeto
						ConversorMoneda cMoneda = new ConversorMoneda();
						cMoneda.IngresarCantidad();
						cMoneda.TipoMoneda(cMoneda.ListaMonedas(cMoneda.MiMoneda(ubicacion.miPais)));
						moneda.precioConversion = Double.parseDouble(moneda.PrecioMonedaConversion(cMoneda.monedaConversion));						
						JOptionPane.showMessageDialog(null, cMoneda.ConvertirDivisa(moneda.precioConversion));
						
						break;
					case "Conversor de Temperatura":
						break;
				}
				
				resp = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", null, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
			} while (resp == JOptionPane.YES_OPTION);
		} catch (Exception e) {
			e.getMessage();
		}		
	}
}
