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
                    String nombre = JOptionPane.showInputDialog("Nombre del animal:");
                    String especie = JOptionPane.showInputDialog("Especie:");
                    String raza = JOptionPane.showInputDialog("Raza:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                    animales.add(new Animal(nombre, especie, raza, edad));
                    JOptionPane.showMessageDialog(null, "Animal registrado con éxito.");
                    break;

                case 1:
                    if (animales.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay animales registrados.");
                    } else {
                        String listaAnimales = "Pacientes registrados:\n";
                        for (Animal animal : animales) {
                            listaAnimales += animal.toString() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, listaAnimales);
                    }
                    break;

                case 2:
                    if (animales.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay animales registrados.");
                    } else {
                        LocalDate fecha = LocalDate.now();
                        LocalDate fechaTurno = fecha.plusMonths(1);
                        String listaAnimal = "Selecciona el animal:\n";
                        for (int i = 0; i < animales.size(); i++) {
                            listaAnimal += (i + 1) + ". " + animales.get(i).getNombre() + "\n";
                        }

                        int seleccion = Integer.parseInt(JOptionPane.showInputDialog(listaAnimal)) - 1;
                        if (seleccion >= 0 && seleccion < animales.size()) {
                            Animal animalSeleccionado = animales.get(seleccion);
                            String observaciones = JOptionPane.showInputDialog("Observaciones:");
                            animalSeleccionado.registrarTurno(fechaTurno, observaciones);
                            JOptionPane.showMessageDialog(null, "Turno creado con éxito.");
                        } else {
                            JOptionPane.showMessageDialog(null, "error");
                        }
                    }
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

