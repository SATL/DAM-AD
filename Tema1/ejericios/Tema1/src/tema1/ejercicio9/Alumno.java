/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio9;

import java.io.Serializable;

/**
 *
 * @author eslem
 */
public class Alumno implements Serializable {

    static final long serialVersionUID = 42L;

    int dni;
    double nota1;
    double nota2;

    public Alumno(int dni, double nota1, double nota2) {
        this.dni = dni;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    @Override
    public String toString() {
        return "dni=" + dni + ", nota1=" + nota1 + ", nota2=" + nota2;
    }
    
    

}
