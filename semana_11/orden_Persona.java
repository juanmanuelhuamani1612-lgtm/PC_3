package orden_personas;
public class orden_Persona {
    
    public static void quickSortPorPeso(Persona[] personas) {
        if (personas == null || personas.length == 0) {
            return;
        }
        quickSortPorPeso(personas, 0, personas.length - 1);
    }
    
    private static void quickSortPorPeso(Persona[] personas, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionPorPeso(personas, low, high);
            quickSortPorPeso(personas, low, pivotIndex - 1);
            quickSortPorPeso(personas, pivotIndex + 1, high);
        }
    }
    
    private static int partitionPorPeso(Persona[] personas, int bajo, int alto) {
        // Elegir el pivote (peso de la persona en la posición alto)
        double pivot = personas[alto].peso;
        int i = bajo - 1;
        
        for (int j = bajo; j < alto; j++) {
            // Ordenar de menor a mayor peso
            if (personas[j].peso <= pivot) {
                i++;
                // Intercambiar personas
                Persona temp = personas[i];
                personas[i] = personas[j];
                personas[j] = temp;
            }
        }
        
        // Colocar el pivote en su posición correcta
        Persona temp = personas[i + 1];
        personas[i + 1] = personas[alto];
        personas[alto] = temp;
        
        return i + 1;
    }
    
    // Método main para probar el algoritmo
    public static void main(String[] args) {
        // Crear array de personas con sus pesos
        Persona[] personas = {
            new Persona("María", 65.5),
            new Persona("Carlos", 80.2),
            new Persona("Ana", 55.8),
            new Persona("Luis", 92.1),
            new Persona("Sofia", 62.3),
            new Persona("Pedro", 78.9),
            new Persona("Laura", 58.4)
        };
        
        System.out.println("=== PERSONAS SIN ORDENAR ===");
        for (Persona p : personas) {
            System.out.println(p);
        }
        
        // Ordenar de menor a mayor peso
        quickSortPorPeso(personas);
        
        System.out.println("\n=== ORDENADAS PESO DE MENOR A MAYOR ===");
        for (Persona p : personas) {
            System.out.println(p);
        }     
    }
}
