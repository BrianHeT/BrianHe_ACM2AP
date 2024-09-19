package ejercicio2;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Animal> animales = new ArrayList<>();

    public static void main(String[] args) {
        String[] menu = { "Registrar animal", "Ver pacientes", "Crear turno", "Salir" };

        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Selecciona una opcion", "Menu de Propiedades",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menu, menu[0]);

            switch (opcion) {
                case 0:
                    Animal.infoAnimal(animales);
                    break;

                case 1:
                    Animal.listaAnimal(animales);
                    break;

                case 2:
                    Animal.turnoAnimal(animales);
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Salir");
                    break;

                default:
                    break;
            }
        } while (opcion != 3);
    }
}

