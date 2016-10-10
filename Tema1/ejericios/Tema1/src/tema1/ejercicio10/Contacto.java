/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio10;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author eslem
 */
public class Contacto implements Serializable {

    static final long serialVersionUID = 42L;
    String nombre;
    String direccion;
    String cp;
    int telefono;

    public Contacto(String nombre, String direccion, String cp, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cp = cp;
        this.telefono = telefono;
    }

    public Contacto(Scanner in) {
        System.out.println("Nombre");
        this.nombre = in.nextLine();

        System.out.println("Direccin");
        this.direccion = in.nextLine();

        System.out.println("CP:");
        this.cp = in.next();

        System.out.println("Telefono:");
        this.telefono = in.nextInt();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", direccion=" + direccion + ", cp=" + cp + ", telefono=" + telefono;
    }

}
