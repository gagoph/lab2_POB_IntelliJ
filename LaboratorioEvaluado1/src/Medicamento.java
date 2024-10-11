import java.util.Scanner;
import java.util.ArrayList;

public abstract class Medicamento {

    Scanner datos = new Scanner (System.in);

    private int id;
    private String nombre;
    private double costo;
    protected double precioVenta;
    private int unidadesVendidas;
    private int unidadesExistentes;
    private int fechaVencimientoMes;
    private int fechaVencimientoAno;
    private int numeroLote;
    private int vigencia;
    private boolean oferta;

    public Medicamento(int id, String nombre, double costo, int unidadesExistentes, int fechaVencimientoMes, int fechaVencimientoAno, int numeroLote, int vigencia) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.precioVenta =  precioVenta(25);
        this.unidadesVendidas = 0;
        this.unidadesExistentes = unidadesExistentes;
        this.fechaVencimientoMes = fechaVencimientoMes;
        this.fechaVencimientoAno = fechaVencimientoAno;
        this.numeroLote = numeroLote;
        this.vigencia = vigencia;
        this.oferta = false;
    }

    //Metodos sin parametros
    public abstract void determinarPrecioVenta();
    public abstract void mostrarInformacion();

    //Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public double getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }
    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }
    public int getUnidadesExistentes() {
        return unidadesExistentes;
    }
    public void setUnidadesExistentes(int unidadesExistentes) {
        this.unidadesExistentes = unidadesExistentes;
    }
    public int getFechaVencimientoMes() {
        return fechaVencimientoMes;
    }
    public void setFechaVencimientoMes(int fechaVencimientoMes) {
        this.fechaVencimientoMes = fechaVencimientoMes;
    }
    public int getFechaVencimientoAno() {
        return fechaVencimientoAno;
    }
    public void setFechaVencimientoAno(int fechaVencimientoAno) {
        this.fechaVencimientoAno = fechaVencimientoAno;
    }
    public int getNumeroLote() {
        return numeroLote;
    }
    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }
    public int getVigencia() {
        return vigencia;
    }
    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }


    public double precioVenta(int porcentaje) {
        double precio;
        precio = this.costo + this.costo * porcentaje/100;
        this.precioVenta = precio;
        return precio;
    }

    public void determinarVencido(int mesActual, int anoActual) {
        if(anoActual == this.fechaVencimientoAno) {
            if(mesActual > this.fechaVencimientoMes) {
                System.out.println("El medicamento: " + this.nombre + ", con id: " + this.id + ", vencio el: " + this.fechaVencimientoMes + "/" + fechaVencimientoAno);
                System.out.println("Desea retirar el lote del mercado? (y/n): ");
                String desicion = datos.nextLine();
                if(desicion.equals("y")) {
                    this.retirarLote(this.numeroLote);
                }
            }
            else if (mesActual < this.fechaVencimientoMes) {
                System.out.println("El medicamento: " + this.nombre + ", con id: " + this.id + ", tiene fecha de vencimiento el: " + this.fechaVencimientoMes + "/" + fechaVencimientoAno);
            }
            else if (mesActual == this.fechaVencimientoMes) {
                System.out.println("El medicamento: " + this.nombre + ", con id: " + this.id + ", vence este mes el: " + this.fechaVencimientoMes + "/" + fechaVencimientoAno);
            }
        }
        else {
            if(anoActual > this.fechaVencimientoAno) {
                System.out.println("El medicamento: " + this.nombre + ", con id: " + this.id + ", vencio el: " + this.fechaVencimientoMes + "/" + fechaVencimientoAno);
                System.out.println("Desea retirar el lote del mercado? (y/n): ");
                String desicion = datos.nextLine();
                if(desicion.equals("y")){
                    this.retirarLote(this.numeroLote);
                }
            }
            else if (anoActual < this.fechaVencimientoAno) {
                System.out.println("El medicamento: " + this.nombre + ", con id: " + this.id + ", tiene fecha de vencimiento el: " + this.fechaVencimientoMes + "/" + fechaVencimientoAno);
            }
        }
    }

    public void retirarLote(int numeroL) {
        if (this.numeroLote == numeroL) {
            this.setVigencia(2);
            System.out.println("El medicamento: " + this.nombre + " con numero de lote: " + this.numeroLote + " fue retirado");
        }
    }

    public void colocarOferta(int mesActual, int anoActual) {
        if (this.oferta == false) {
            if(anoActual == this.fechaVencimientoAno) {
                if (this.fechaVencimientoMes >= mesActual) {
                    if((this.fechaVencimientoMes - mesActual) <= 3) {
                        this.precioVenta = this.precioVenta - this.precioVenta*0.3;
                        System.out.println("Oferta efectuada a este medicamento");
                        this.oferta = true;
                    }
                    else {
                        System.out.println("A este medicamento no le aplica la oferta.");
                    }
                } else {
                    System.out.println("A este medicamento no le aplica la oferta.");
                }
            }
            else if (anoActual == this.fechaVencimientoAno-1) {
                if((mesActual - this.fechaVencimientoMes == 9) | (mesActual - this.fechaVencimientoMes == 10) | (mesActual - this.fechaVencimientoMes == 11)) {
                    this.precioVenta = this.precioVenta - this.precioVenta*0.3;
                    System.out.println("Oferta efectuada a este medicamento");
                    this.oferta = true;
                }
                else {
                    System.out.println("A este medicamento no le aplica la oferta.");
                }
            }
            else {
                System.out.println("A este medicamento no le aplica la oferta.");
            }
        } else {
            System.out.println("El medicamento: " + this.nombre + " ya tiene oferta.");
        }

    }

    public void reponerInventario() {
        if(this.unidadesExistentes < 5) {
            System.out.println("El medicamento: " + this.nombre + " tiene " + this.unidadesExistentes + " unidades, se recomienda reponer");
        } else {
            System.out.println("El medicamento: " + this.nombre + " tiene " + this.unidadesExistentes + " unidades disponibles en el inventario.");
        }
    }

}
