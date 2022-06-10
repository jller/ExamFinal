/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examfinal_alvizurijose;

/**
 *
 * @author ggpo0
 */
public class Plato {
    private int idplato;
    private String nombre;
    private double precio;
    private String descripcion;
    private int valoracion;
    private int estado;
    private String region;

    public Plato() {
    }

    public Plato(String nombre, double precio, String descripcion, int valoracion, String region) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.valoracion = valoracion;
        this.region = region;
    }

    public void detalle(){
      System.out.println("Id: "+this.idplato+" Nombre: "+ this.nombre+ " Precio: "+this.precio+
              " Descripcion: "+this.descripcion+ " Estado: "+this.estado+" Valoracion: "+this.valoracion+" Region: "+this.region);
    }
    /**
     * @return the idplato
     */
    public int getIdplato() {
        return idplato;
    }

    /**
     * @param idplato the idplato to set
     */
    public void setIdplato(int idplato) {
        this.idplato = idplato;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the valoracion
     */
    public int getValoracion() {
        return valoracion;
    }

    /**
     * @param valoracion the valoracion to set
     */
    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }
    
    
    
}
