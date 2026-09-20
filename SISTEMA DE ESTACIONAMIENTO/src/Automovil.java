public class Automovil extends Vehiculo {

    public Automovil(String placa, String propietario, int horaIngreso, int horasUtilizadas) {
        super(placa, propietario, horaIngreso, horasUtilizadas);
    }

    @Override
    public double calcularCosto() {
        double subtotal = getHorasUtilizadas() * 10.0;
        if (getHorasUtilizadas() > 5) {
            subtotal = subtotal * 0.90;}


        return subtotal;}

    @Override
    public String getTipo() {
        return "Automóvil";}
}