import java.util.ArrayList;

public class MedicamentosAmbiente extends Medicamento{

    private double temperatura;
    private ArrayList<String> lugares = new ArrayList<>();

    public MedicamentosAmbiente(int id, String nombre, double costo, int unidadesExistentes, int fechaVencimientoMes, int fechaVencimientoAno, int numeroLote, int vigencia, double temperatura){
        super(id, nombre, costo, unidadesExistentes, fechaVencimientoMes, fechaVencimientoAno, numeroLote, vigencia);
        this.lugares = lugares;
        this.temperatura = temperatura;
        determinarPrecioVenta();
    }

    @Override
    public void determinarPrecioVenta() {
        this.precioVenta = precioVenta;
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
        System.out.println("La temperatura actual es (C): " + this.temperatura);
        System.out.println("Lugares donde no debe almacenarse: " + this.lugares);
    }
}
