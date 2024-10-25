import java.util.ArrayList;

public class MedicamentosRefrigerados extends Medicamento{

    private ArrayList<Double> RangoTemperatura = new ArrayList<>();
    private double tiempoMax;

    public MedicamentosRefrigerados(int id, String nombre, double costo, int unidadesExistentes, int fechaVencimientoMes, int fechaVencimientoAno, int numeroLote, int vigencia, double minTemp, double maxTemp, double tiempoMax) {
        super(id, nombre, costo, unidadesExistentes, fechaVencimientoMes, fechaVencimientoAno, numeroLote, vigencia);
        RangoTemperatura.add(minTemp);
        RangoTemperatura.add(maxTemp);
        this.RangoTemperatura = RangoTemperatura;
        this.tiempoMax = tiempoMax;
        determinarPrecioVenta();
    }

    @Override
    public void determinarPrecioVenta() {
        double precio;
        this.precioVenta = precioVenta + precioVenta*0.25;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println();
        System.out.println("Id: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Costo: " + getCosto());
        System.out.println("Precio Venta: " + getPrecioVenta());
        System.out.println("Unidades Vendidas: " + getUnidadesVendidas());
        System.out.println("Unidades Existentes: " + getUnidadesExistentes());
        System.out.println("Fecha Vencimiento: " + getFechaVencimientoMes() + "/" + getFechaVencimientoAno());
        System.out.println("Numero Lote: " + getNumeroLote());
        System.out.println("Vigencia: " + getVigencia());
        System.out.println("El rango de temperatura es de (C): " + this.RangoTemperatura.get(0) + " - " + this.RangoTemperatura.get(1));
        System.out.println("El timepo maximo sin refrigeracion de este medicamento es de: " + this.tiempoMax);
    }
}
