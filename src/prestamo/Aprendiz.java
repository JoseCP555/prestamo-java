package prestamo;

public class Aprendiz {
    private String documento;
    private String nombre;
    private String ficha;
    private String telefono;

    public Aprendiz(String documento, String nombre, String ficha, String telefono) {
        setDocumento(documento);
        this.nombre = nombre;
        this.ficha = ficha;
        setTelefono(telefono);
    }

    public void setDocumento(String documento) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("Documento no puede estar vacío");
        }
        this.documento = documento;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.length() < 10) {
            throw new IllegalArgumentException("Teléfono debe tener al menos 10 dígitos");
        }
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public String toString() {
        return "Doc: " + documento + " | Nombre: " + nombre + " | Ficha: " + ficha;
    }
}