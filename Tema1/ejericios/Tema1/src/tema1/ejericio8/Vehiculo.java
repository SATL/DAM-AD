/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejericio8;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author eslem
 */
public class Vehiculo implements Serializable {

    static final long serialVersionUID = 42L;

    private String marca;
    private String modelo;
    private String matricula;
    private int potencia;
    private String color;

    public Vehiculo(String marca, String modelo, String matricula, int potencia, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.potencia = potencia;
        this.color = color;
    }

    Vehiculo(Scanner in) {
        System.out.println("Marca:");
        this.marca = in.next();
        System.out.println("Modelo:");
        this.modelo = in.next();
        System.out.println("Matricula:");
        this.matricula = in.next();
        System.out.println("Color:");
        this.color = in.next();
        System.out.println("Potencia:");
        this.potencia = in.nextInt();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", potencia=" + potencia + ", color=" + color;
    }

}
