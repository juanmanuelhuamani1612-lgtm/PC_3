package bus_binaria;
        
import java.util.Arrays;
import java.util.Scanner;

class Alumno {
    int codigo;
    String nombre;

    public Alumno(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}

public class BusquedaBinaria {
    public static void main(String[] args) {

        Alumno[] alumnos = {
            new Alumno(1001, "Manuel"),
            new Alumno(1003, "Valeria"),
            new Alumno(1005, "Carlos"),
            new Alumno(1007, "Lucia"),
            new Alumno(1009, "Andres"),
            new Alumno(1010, "Juan"),
            new Alumno(1011, "Marco"),
            new Alumno(1012, "Julian"),
            new Alumno(1013, "Sebastian")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el código del alumno que deseas buscar: ");
        int codigoBuscado = sc.nextInt();

        int resultado = busquedaBinaria(alumnos, codigoBuscado);

        if (resultado != -1) {
            System.out.println(" Alumno encontrado: " + alumnos[resultado].nombre);
        } else {
            System.out.println(" Alumno no encontrado en el registro.");
        }

        sc.close();
    }

    // Método de búsqueda binaria
    public static int busquedaBinaria(Alumno[] alumnos, int codigoBuscado) {
        int inicio = 0;
        int fin = alumnos.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (alumnos[medio].codigo == codigoBuscado) {
                return medio; // encontrado
            } else if (alumnos[medio].codigo < codigoBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1; // no encontrado
    }
}
