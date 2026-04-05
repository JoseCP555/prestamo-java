package prestamo;

import java.util.ArrayList;

public class SistemaPrestamos {

    private ArrayList<Aprendiz> aprendices = new ArrayList<>();
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    private int contador = 1;

    public void registrarAprendiz(Aprendiz a) {
        aprendices.add(a);
    }

    public void registrarEquipo(Equipo e) {
        equipos.add(e);
    }

    public Aprendiz buscarAprendiz(String doc) {
        for (Aprendiz a : aprendices) {
            if (a.getDocumento().equals(doc)) {
                return a;
            }
        }
        return null;
    }

    public Equipo buscarEquipo(String cod) {
        for (Equipo e : equipos) {
            if (e.getCodigo().equals(cod)) {
                return e;
            }
        }
        return null;
    }

    public void listarEquipos() {
        for (Equipo e : equipos) {
            System.out.println(e);
        }
    }

    public void prestarEquipo(String doc, String cod) {
        Aprendiz a = buscarAprendiz(doc);
        Equipo e = buscarEquipo(cod);

        if (a == null) {
            throw new RuntimeException("Aprendiz no existe");
        }

        if (e == null) {
            throw new RuntimeException("Equipo no existe");
        }

        Prestamo p = new Prestamo(contador++, a, e);
        prestamos.add(p);
    }

    public void devolverEquipo(int id) {
        for (Prestamo p : prestamos) {
            if (p.getId() == id && p.isActivo()) {
                p.cerrarPrestamo();
                return;
            }
        }
        throw new RuntimeException("Préstamo no encontrado o ya cerrado");
    }

    public void listarPrestamosActivos() {
        for (Prestamo p : prestamos) {
            if (p.isActivo()) {
                System.out.println(p);
            }
        }
    }
}