package prestamo;

public class Equipo {
    private String codigo;
    private String nombre;
    private String categoria;
    private boolean disponible;

    public Equipo(String codigo, String nombre, String categoria) {
        if (codigo == null || codigo.trim().isEmpty() ||
            nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Código y nombre no pueden estar vacíos");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.disponible = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void marcarPrestado() {
        if (!disponible) {
            throw new IllegalStateException("El equipo ya está prestado");
        }
        disponible = false;
    }

    public void marcarDevuelto() {
        disponible = true;
    }

    public String toString() {
        return codigo + " | " + nombre + " | " + categoria +
               " | " + (disponible ? "Disponible" : "Prestado");
    }
}