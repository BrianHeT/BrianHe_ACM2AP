import java.util.ArrayList;

import javax.swing.JOptionPane;

class Propiedad {
    private String propiedad;
    private int tipo; 
    private int ubicacion; 
    private int size; 
    private boolean estado; 
    private double valor;

    public Propiedad(String propiedad, int tipo, int ubicacion, int size, boolean estado, double valor) {
        this.propiedad = propiedad;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.size = size;
        this.estado = estado;
        this.valor = valor;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo; 
    }
    
    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion; 
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size; 
    }

    public boolean estaDisponible() {
        return !estado; 
    }

    public static void alquilar(ArrayList<Propiedad>propiedades) {
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
                 propiedades.get(seleccion).estaDisponible();
                 JOptionPane.showMessageDialog(null, "Propiedad alquilada");
             } else {
                 JOptionPane.showMessageDialog(null, "error");
             }
         }
    	 }
       

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor; 
    }
    public static double valorTipo(int tipo) {
        switch (tipo) {
            case 0: return 1.1; 
            case 1: return 1.25; 
            case 2: return 1.5; 
            default: return 1; 
        }
    }

    public static double valorUbicacion(int ubicacion) {
        switch (ubicacion) {
            case 0: return 0.8; 
            case 1: return 1.1;  
            case 2: return 1.25; 
            default: return 1;  
        }
    }

    public static double valorSize(int size) {
        switch (size) {
            case 0: return 1; 
            case 1: return 1.2; 
            case 2: return 1.5; 
            default: return 1;  
        }
    }

    public static String verificacionVacio(String propiedades){
    	if (propiedades.isEmpty()) {
            JOptionPane.showMessageDialog(null, "erro");
        } else {
           return  propiedades;
    }
		return propiedades;}
    
    
	@Override
	public String toString() {
		return "Propiedad [propiedad=" + propiedad + ", tipo=" + tipo + ", ubicacion=" + ubicacion + ", size=" + size
				+ ", estado=" + estado + ", valor=" + valor + "]";
	}

public static void modificarPropiedad(ArrayList<Propiedad>propiedades) {
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
            int nuevoTipo = Integer.parseInt(JOptionPane.showInputDialog("Nuevo tipo \n 0: departamento\n 1: casa\n 2: mansion:", propiedadAModificar.getTipo()));
            int nuevaUbicacion = Integer.parseInt(JOptionPane.showInputDialog("Nueva ubicación \n 0: Barrio Bajo \n 1: Barrio Medio\n 2: Barrio Alto):", propiedadAModificar.getUbicacion()));
            int nuevoSize = Integer.parseInt(JOptionPane.showInputDialog("Nuevo tamaño \n 0: Chico\n 1: Mediano\n 2: Grande:", propiedadAModificar.getSize()));
            double nuevoValor = Double.parseDouble(JOptionPane.showInputDialog("Nuevo valor base del alquiler:", propiedadAModificar.getValor()));

            double nuevoValorFinal = nuevoValor * Propiedad.valorTipo(nuevoTipo) * Propiedad.valorUbicacion(nuevaUbicacion) * Propiedad.valorSize(nuevoSize);

            
            
            propiedadAModificar.setPropiedad(nuevoNombre);
            propiedadAModificar.setTipo(nuevoTipo);
            propiedadAModificar.setUbicacion(nuevaUbicacion);
            propiedadAModificar.setSize(nuevoSize);
            propiedadAModificar.setValor(nuevoValorFinal);

            JOptionPane.showMessageDialog(null, "Propiedad modificada con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "error");
        }
    }	
}


public static void listaPropiedad(ArrayList<Propiedad>propiedades) {
	 if (propiedades.isEmpty()) {
         JOptionPane.showMessageDialog(null, "erro");
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
}





}






/*for (Propiedad propiedad : propiedad) {
    if (propiedad.estaDisponible()) {
        listaDisponibles += propiedad.getPropiedad() + " - " + propiedad.getValor() + "\n";
    }
}
if (listaDisponibles.isEmpty()) {
    JOptionPane.showMessageDialog(null, "No hay propiedades disponibles");
} else {
    JOptionPane.showMessageDialog(null, "Propiedades disponibles:\n" + listaDisponibles);
}
}*/

