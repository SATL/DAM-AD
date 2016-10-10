/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio1;

/**
 *
 * @author eslem
 */
public class Noticia {

    private int fecha;
    private int hora;
    private int lecturas;
    private String texto;

    public Noticia(int fecha, int hora, int lecturas, String texto) {
        this.fecha = fecha;
        this.hora = hora;
        this.lecturas = lecturas;
        this.texto = texto;
    }

    public int getData() {
        return fecha;
    }

    public int getLecturas() {
        return lecturas;
    }

    public void incLecturas() {
        lecturas++;
    }

    public boolean igualData(int d, int m, int a) {
        return d == fecha % 100 && m == (fecha / 100) % 100 && a == fecha / 10000;
    }

    public String toString() {
        String s = "";
        s += fecha % 100 + "/" + (fecha / 100) % 100 + "/" + (fecha / 10000) + " - ";
        s += (hora / 100) + ":" + (hora % 100) + "\n";
        s += texto + "\n";
        s += "Leida " + lecturas + " veces\n";
        return s;
    }

    public String toFile() {
        return fecha + "#" + hora + "#" + lecturas + "#" + texto;
    }

}
