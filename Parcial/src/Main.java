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
	                    if (propiedades.isEmpty()) {
	                        JOptionPane.showMessageDialog(null, "No hay propiedades registradas.");
	                    } else {
	                        String listaPropiedades = "";
	                        for (int i = 0; i < propiedades.size(); i++) {
	                            listaPropiedades += (i + 1) + ". " + propiedades.get(i).getPropiedad() + "\n";
	                        }
	                        int seleccion = Integer.parseInt(JOptionPane.showInputDialog("Selecciona la propiedad a modificar:\n" + listaPropiedades)) - 1;

	                        if (seleccion >= 0 && seleccion < propiedades.size()) {
	                            Propiedad propiedadAModificar = propiedades.get(seleccion);

	                            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre de la propiedad:", propiedadAModificar.getPropiedad());
	                            int nuevoTipo = Integer.parseInt(JOptionPane.showInputDialog("Nuevo tipo \n0: departamento\n 1: casa\n 2: mansion:", propiedadAModificar.getTipo()));
	                            int nuevaUbicacion = Integer.parseInt(JOptionPane.showInputDialog("Nueva ubicación \n 0: Barrio Bajo \n 1: Barrio Medio\n 2: Barrio Alto):", propiedadAModificar.getUbicacion()));
	                            int nuevoSize = Integer.parseInt(JOptionPane.showInputDialog("Nuevo tamaño \n0: Chico\n 1: Mediano\n 2: Grande:", propiedadAModificar.getSize()));
	                            double nuevoValor = Double.parseDouble(JOptionPane.showInputDialog("Nuevo valor base del alquiler:", propiedadAModificar.getValor()));

	                            double nuevoValorFinal = nuevoValor * Propiedad.valorTipo(nuevoTipo) * Propiedad.valorUbicacion(nuevaUbicacion) * Propiedad.valorSize(nuevoSize);

	                            
	                            
	                            propiedadAModificar.setPropiedad(nuevoNombre);
	                            propiedadAModificar.setTipo(nuevoTipo);
	                            propiedadAModificar.setUbicacion(nuevaUbicacion);
	                            propiedadAModificar.setSize(nuevoSize);
	                            propiedadAModificar.setValor(nuevoValorFinal);

	                            JOptionPane.showMessageDialog(null, "Propiedad modificada con éxito");
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Selección no válida.");
	                        }
	                    }
	                    break;
//propiedades disponibles
	                case 2: 
	                    if (propiedades.isEmpty()) {
	                        JOptionPane.showMessageDialog(null, "No hay propiedades registradas.");
	                    } else {
	                        String listaDisponibles = "";
	                        for (Propiedad propiedad : propiedades) {
	                            if (propiedad.estaDisponible()) {
	                                listaDisponibles += propiedad.getPropiedad() + " - " + propiedad.getValor() + "\n";
	                            }
	                        }
	                        if (listaDisponibles.isEmpty()) {
	                            JOptionPane.showMessageDialog(null, "No hay propiedades disponibles");
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Propiedades disponibles:\n" + listaDisponibles);
	                        }
	                    }
	                    break;
//alquilar proipiedad
	                case 3: 
	                    if (propiedades.isEmpty()) {
	                        JOptionPane.showMessageDialog(null, "No hay propiedades registradas.");
	                    } else {
	                        String listaPropiedades = "";
	                        for (int i = 0; i < propiedades.size(); i++) {
	                            if (propiedades.get(i).estaDisponible()) {
	                                listaPropiedades += (i + 1) + ". " + propiedades.get(i).getPropiedad() + "\n";
	                            }
	                        }
	                        int seleccion = Integer.parseInt(JOptionPane.showInputDialog("Selecciona la propiedad a alquilar:\n" + listaPropiedades)) - 1;

	                        if (seleccion >= 0 && seleccion < propiedades.size()) {
	                            propiedades.get(seleccion).alquilar();
	                            JOptionPane.showMessageDialog(null, "Propiedad alquilada");
	                        } else {
	                            JOptionPane.showMessageDialog(null, "error");
	                        }
	                    }
	                    break;

	                case 4: // Salir
	                    JOptionPane.showMessageDialog(null, "Saliendo");
	                    break;
	            }

	        } while (opcion != 4); 
	    }
}
