import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        HashSet<String> placasRegistradas = new HashSet<>();
        HashMap<String, Double> totalPorTipo = new HashMap<>();

        totalPorTipo.put("Automovil", 0.0);
        totalPorTipo.put("Motocicleta", 0.0);

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do { 
        try {
                System.out.println("\n=== SISTEMA DE GESTION DE ESTACIONAMIENTO ===");
                System.out.println("1. Registrar Automovil");
                System.out.println("2. Registrar Motocicleta");
                System.out.println("3. Buscar Vehiculo por Placa");
                System.out.println("4. Mostrar Todos los Vehiculos");
                System.out.println("5. Mostrar Recaudacion Total");
                System.out.println("6. Salir");
                System.out.print("Ingrese una opcion: ");

                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        registrarVehiculo(scanner, listaVehiculos, placasRegistradas, totalPorTipo, "Automovil");
                        break;
                    case 2:
                        registrarVehiculo(scanner, listaVehiculos, placasRegistradas, totalPorTipo, "Motocicleta");
                        break;
                    case 3:
                        buscarVehiculo(scanner, listaVehiculos);
                        break;
                    case 4:
                        mostrarTodos(listaVehiculos);
                        break;
                    case 5:
                        mostrarRecaudacion(totalPorTipo);
                        break;
                    case 6:
                        System.out.println("¡Gracias por utilizar el sistema!");
                        break;
                    default:
                        System.out.println("Opcion no valida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero entero valido.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            } finally {
                System.out.println("----------------------------------------------");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private static void registrarVehiculo(Scanner scanner, ArrayList<Vehiculo> lista,
                                          HashSet<String> placas, HashMap<String, Double> totales,
                                          String tipo) {
        try {
            System.out.print("Ingrese la placa del vehiculo: ");
            String placa = scanner.nextLine().trim().toUpperCase();

            if (placas.contains(placa)) {
                System.out.println("Error: La placa '" + placa + "' ya esta registrada en el sistema.");
                return;
            }

            System.out.print("Ingrese el nombre del propietario: ");
            String propietario = scanner.nextLine().trim();

            System.out.print("Ingrese la hora de ingreso (0-23): ");
            int horaIngreso = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese las horas utilizadas: ");
            int horasUtilizadas = Integer.parseInt(scanner.nextLine());

            if (horasUtilizadas <= 0) {
                System.out.println("Error: Las horas utilizadas deben ser mayor a cero.");
                return; }

            Vehiculo nuevoVehiculo;
            if (tipo.equals("Automovil")) {
                nuevoVehiculo = new Automovil(placa, propietario, horaIngreso, horasUtilizadas);
            } 
            else {
                nuevoVehiculo = new Motocicleta(placa, propietario, horaIngreso, horasUtilizadas);
            }

            lista.add(nuevoVehiculo);
            placas.add(placa);

            double costoCalculado = nuevoVehiculo.calcularCosto();
            totales.put(tipo, totales.get(tipo) + costoCalculado);

            System.out.println("\n¡Vehiculo registrado exitosamente!");
            nuevoVehiculo.mostrarInformacion(); } 
        
        catch (NumberFormatException e) {
            System.out.println("Error de entrada: Debe ingresar un numero valido para las horas.");} }

    private static void buscarVehiculo(Scanner scanner, ArrayList<Vehiculo> lista) {
        System.out.print("Ingrese la placa a buscar: ");
        String placaBusqueda = scanner.nextLine().trim().toUpperCase();

        boolean encontrado = false;
        for (Vehiculo v : lista) {
            if (v.getPlaca().equalsIgnoreCase(placaBusqueda)) {
                v.mostrarInformacion();
                encontrado = true;
                break;}}

        if (!encontrado) {
            System.out.println("No se encontro ningun vehiculo con la placa: " + placaBusqueda);}}

    private static void mostrarTodos(ArrayList<Vehiculo> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay vehiculos registrados en el estacionamiento.");
            return; }

        System.out.println("\n=== LISTADO DE VEHICULOS REGISTRADOS ===");
        for (Vehiculo v : lista) {
            v.mostrarInformacion();  } }

    private static void mostrarRecaudacion(HashMap<String, Double> totales) {
        double totalAutomoviles = totales.get("Automovil");
        double totalMotocicletas = totales.get("Motocicleta");
        double totalGeneral = totalAutomoviles + totalMotocicletas;

        System.out.println("\n=== RESUMEN DE RECAUDACION ===");
        System.out.printf("Total Recaudado en Automoviles  : Q%.2f\n", totalAutomoviles);
        System.out.printf("Total Recaudado en Motocicletas : Q%.2f\n", totalMotocicletas);
        System.out.printf("TOTAL GENERAL RECAUDADO          : Q%.2f\n", totalGeneral);
    }
}
