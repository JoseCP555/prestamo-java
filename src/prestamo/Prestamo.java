package prestamo;

import java.time.LocalDate;

public class Prestamo {
    private int id;
    private Aprendiz aprendiz;
    private Equipo equipo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean activo;

    public Prestamo(int id, Aprendiz aprendiz, Equipo equipo) {
        if (aprendiz == null) {
            throw new IllegalArgumentException("Aprendiz no existe");
        }

        if (equipo == null) {
            throw new IllegalArgumentException("Equipo no existe");
        }

        if (!equipo.isDisponible()) {
            throw new IllegalStateException("Equipo no disponible");
        }

        this.id = id;
        this.aprendiz = aprendiz;
        this.equipo = equipo;
        this.fechaPrestamo = LocalDate.now();
        this.activo = true;

        equipo.marcarPrestado();
    }

    public int getId() {
        return id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void cerrarPrestamo() {
        if (!activo) {
            throw new IllegalStateException("El préstamo ya está cerrado");
        }

        this.activo = false;
        this.fechaDevolucion = LocalDate.now();
        equipo.marcarDevuelto();
    }

    public String toString() {
        return "ID: " + id +
               " | Aprendiz: " + aprendiz.getDocumento() +
               " | Equipo: " + equipo.getCodigo() +
               " | Estado: " + (activo ? "Activo" : "Cerrado");
    }
}