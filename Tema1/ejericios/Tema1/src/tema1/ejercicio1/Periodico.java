/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1.ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author eslem
 */
public class Periodico {

    List<Noticia> noticias;
    int numNoticias;

    public Periodico() {
        noticias = new ArrayList<>(1000);
    }

    public void insertar(Noticia n) {
        noticias.add(n);
        numNoticias++;
    }

    public Noticia primeraNoticia(int d, int m, int a) {
        List<Noticia> noticiasSort = noticias;
        Collections.sort(noticiasSort, (Noticia x, Noticia b) -> x.getData() - b.getData());

        for (Noticia not : noticiasSort) {
            if (not.getData() >= convertDate(a, m, d)) {
                return not;
            }
        }
        return null;
    }

    public void masPopulares() {
        if (noticias.isEmpty()) {
            System.out.println("No hay ninguna noticia");
            return;
        }

        List<Noticia> noticiasSort = noticias;
        Collections.sort(noticiasSort, (Noticia a, Noticia b) -> b.getLecturas() - a.getLecturas());

        for (int i = 0; i < noticiasSort.size(); i++) {
            Noticia noticia = noticiasSort.get(i);
            System.out.println(noticia.toString());
            if (noticia.getLecturas() != noticiasSort.get(i + 1).getLecturas()) {
                return;
            }
        }
    }

    private int convertDate(int a, int m, int d) {
        return a * 10000 + m * 100 + d;
    }

    public void borrarAnteriores(int d, int m, int a) {
        int date = convertDate(a, m, d);

        for (int i = 0; i < noticias.size(); i++) {
            if (noticias.get(i).getData() < date) {
                noticias.remove(i);
                i--;
            }

        }
    }

    public void verTodas() {
        noticias.stream().forEach(x -> System.out.println(x.toString()));
    }

}
