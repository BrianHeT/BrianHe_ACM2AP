import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		ArrayList<Propiedad> propiedades = new ArrayList<>();

		String[] menu = { "Registrar propiedad", "Modificar Propiedad", "Propiedades disponibles", "Alquiler",
				"Salir" };

		int opcion = 0;
		
		 do {
	            
	            opcion = JOptionPane.showOptionDialog(null, "Selecciona una opcion", "Menú de Propiedades",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menu, menu[0]);

	            switch (opcion) {
	         // Registrar propiedad
	            case 0:
	                    String nombre = JOptionPane.showInputDialog("Nombre de la propiedad:");
	                    
	                    int tipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo \n0: departamento\n 1: casa\n 2: mansion:"));
	                    double valorTipo=Propiedad.valorTipo(tipo);
	                    
	                    int ubicacion = Integer.parseInt(JOptionPane.showInputDialog("Ubicación \n0: Barrio Bajo \n 1: Barrio Medio \n 2: Barrio Alto:"));
	                    double valorUbicacion=Propiedad.valorUbicacion(ubicacion);
	                    
	                    int size = Integer.parseInt(JOptionPane.showInputDialog("Tamaño 0: Chico\n 1: Mediano \n 2: Grande:"));
	                    double valorSize =Propiedad.valorSize(size);
	                    
	                    double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor del alquiler:"));
	                    double valorFinal = valor * valorTipo * valorUbicacion * valorSize;
	                    
	                    boolean estado = false; 

	                  
	                    Propiedad nuevaPropiedad = new Propiedad(nombre, tipo, ubicacion, size, estado, valor);
	                    propiedades.add(nuevaPropiedad);
	                    JOptionPane.showMessageDialog(null, "Propiedad registrada con exito\n valor:"+ valorFinal);
	                    break;
//modificar propiedad
	                case 1: 
	                    Propiedad.modificarPropiedad(propiedades);
	                    break;
//propiedades disponibles
	                case 2: 
	                	
	                	
	                	Propiedad.listaPropiedad(propiedades);
	                	
	                   
	                    break;
//alquilar proipiedad
	                case 3: 
	                   Propiedad.alquilar(propiedades);

	                case 4: // Salir
	                    JOptionPane.showMessageDialog(null, "Saliendo");
	                    break;
	            }

	        } while (opcion != 4); 
	    }
}