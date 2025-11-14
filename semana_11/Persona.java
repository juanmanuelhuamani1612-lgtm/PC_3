package orden_personas;
class Persona {
    String nombre;
    double peso; // en kilogramos
    
    public Persona(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%.1f kg)", nombre, peso);
    }
}