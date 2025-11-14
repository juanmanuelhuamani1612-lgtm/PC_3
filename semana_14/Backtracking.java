package backtracking;
public class Backtracking {
    static int[][] laberinto = {
        {1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}
    };
    static int N = laberinto.length;

    static boolean resolverLaberinto(int x, int y) {
        if (x == N - 1 && y == N - 1) { // Caso base: llegó a la salida
            System.out.println("(" + x + "," + y + ")");
            return true;
        }

        if (esSeguro(x, y)) {
            System.out.println("(" + x + "," + y + ")");
            laberinto[x][y] = 0; // Marca el camino para no volver

            // Mover hacia la derecha o hacia abajo
            if (resolverLaberinto(x + 1, y) || resolverLaberinto(x, y + 1))
                return true;

            laberinto[x][y] = 1; // Desmarca si no funcionó (backtrack)
        }
        return false;
    }

    static boolean esSeguro(int x, int y) {
        return (x >= 0 && y >= 0 && x < N && y < N && laberinto[x][y] == 1);
    }

    public static void main(String[] args) {
        System.out.println("Camino encontrado:");
        resolverLaberinto(0, 0);
    }
}

