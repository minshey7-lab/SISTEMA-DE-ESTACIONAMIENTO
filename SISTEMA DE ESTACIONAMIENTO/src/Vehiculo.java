public abstract class Vehiculo {
    private String placa;
    private String propietario;
    private int horaIngreso;
    private int horasUtilizadas;

    public Vehiculo(String placa, String propietario, int horaIngreso, int horasUtilizadas) {
        this.placa = placa;
        this.propietario = propietario;
        this.horaIngreso = horaIngreso;
        this.horasUtilizadas = horasUtilizadas;}



    public String getPlaca() {
        return placa;}

    public String getPropietario() {
        return propietario;}

    public int getHoraIngreso() {
        return horaIngreso;}

    public int getHorasUtilizadas() {
        return horasUtilizadas;}

  //

    public abstract double calcularCosto();

    //

    public abstract String getTipo();

    //

    public void mostrarInformacion() {
        System.out.println("----------------------------------------");
        System.out.println("Tipo            : " + getTipo());
        System.out.println("Placa           : " + placa);
        System.out.println("Propietario     : " + propietario);
        System.out.println("Hora de Ingreso : " + horaIngreso + ":00 hrs");
        System.out.println("Horas Utilizadas: " + horasUtilizadas);
        System.out.printf("Costo Total     : Q%.2f\n", calcularCosto());
        System.out.println("----------------------------------------");}
}