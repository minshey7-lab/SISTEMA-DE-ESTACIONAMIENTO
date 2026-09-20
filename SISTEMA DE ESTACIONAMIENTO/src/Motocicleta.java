public class Motocicleta extends Vehiculo {

    public Motocicleta(String placa, String propietario, int horaIngreso, int horasUtilizadas) {
        super(placa, propietario, horaIngreso, horasUtilizadas);
    }

    @Override
    public double calcularCosto() {
        double subtotal = getHorasUtilizadas() * 6.0;
        if (getHorasUtilizadas() > 5) {
            subtotal = subtotal * 0.90;
        }
        return subtotal;
    }

    @Override
    public String getTipo() {
        return "Motocicleta";
    }
}