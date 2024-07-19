public interface Descuento {
    double aplicarDescuento(double monto);
}

class DescuentoProntoPago implements Descuento {
    private double porcentaje;

    public DescuentoProntoPago(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto - (monto * porcentaje / 100);
    }
}

class DescuentoServicioPublico implements Descuento {
    private double descuentoFijo;

    public DescuentoServicioPublico(double descuentoFijo) {
        this.descuentoFijo = descuentoFijo;
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto - descuentoFijo;
    }
}

class DescuentoTrasladoCuenta implements Descuento {
    private double porcentaje;

    public DescuentoTrasladoCuenta(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicarDescuento(double monto) {
        return monto - (monto * porcentaje / 100);
    }
}
