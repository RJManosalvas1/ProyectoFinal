import java.util.List;

public class CalculadorImpuestos {
    private Vehiculo vehiculo;
    private List<Descuento> descuentos;

    public CalculadorImpuestos(Vehiculo vehiculo, List<Descuento> descuentos) {
        this.vehiculo = vehiculo;
        this.descuentos = descuentos;
    }

    public double calcularTotalImpuestos() {
        double monto = vehiculo.getValorVehiculo();
        for (Descuento descuento : descuentos) {
            monto = descuento.aplicarDescuento(monto);
        }
        return monto;
    }
}
