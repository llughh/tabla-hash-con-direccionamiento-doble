/*
 - Practica: Implementacion de una tabla Hash
 - Grupo de TPA: P1-M21 7
 - Equipo de Trabajo: Vicente David Mut and Juan Carlos Sánchez
 - Expedientes: Vicente David Mut: 22083342   //   Juan Carlos Sánchez: 22064532
 - Fecha de creación: 24/03/2023
 - Fecha ultima de modificación: 31/3/2023
 - Version: 1
*/

public class Hash<Valor> {

    private Celda<Valor>[] contenedor;
    private int numElementos;
    private float alfaMax;
    private int capacidad;

    public Hash() {
        this.capacidad = 7;
        this.contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            this.contenedor[i] = new Celda<Valor>();
        }
        this.alfaMax = 0.8f;
        this.numElementos = 0;

    }

    public Hash(int capacidad) {
        this.capacidad = capacidad;
        this.contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            this.contenedor[i] = new Celda<Valor>();
        }

        this.alfaMax = 0.8f;
        this.numElementos = 0;

    }

    public Hash(int capacidad, float alfaMax) {
        this.capacidad = capacidad;
        this.alfaMax = (alfaMax < 1.0f && alfaMax > 0.0) ? alfaMax : 0.8f;
        this.numElementos = 0;
        this.contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            this.contenedor[i] = new Celda<Valor>();
        }
    }

    public void insertar(int clave, Valor v) {
        int colisiones = 0;
        int h2 = funcionHash(clave, colisiones);
        if (factorCarga() <= alfaMax) {
            while (hayColision(funcionHash(clave, colisiones))){
                colisiones++;
                h2 = funcionHash(clave, colisiones);
            }
            if (contenedor[h2] == null) {
                contenedor[h2] = new Celda<Valor>();
            }
            contenedor[h2].setEstado(1);
            contenedor[h2].setClave(clave);
            contenedor[h2].setValor(v);
        }else {
            redimensionar();
        }
        numElementos++;
    }

    public boolean borrar(int clave) {
        int colisiones = 0;
        int maxColisiones = 15;
        int h = funcionHash(clave, colisiones);
        while (hayColision(h) && contenedor[h].getClave() != clave && colisiones <= maxColisiones){
            colisiones++;
            h = funcionHash(clave, colisiones);
        }

        if (contenedor[h] != null && contenedor[h].getClave() == clave && contenedor[h].getEstado() == 1) {
            contenedor[h].setEstado(-1);
            numElementos--;
            return true;
        }
        return false;
    }

    public Valor get(int clave) {
        int colisiones = 0;
        int maxColisiones = 15;
        int h = funcionHash(clave, colisiones);
        while (hayColision(h) && contenedor[h].getClave() != clave && colisiones <= maxColisiones){
            colisiones++;
            h = funcionHash(clave, colisiones);
        }
        if (contenedor[h].getClave() == clave && contenedor[h].getEstado() == 1) {
            return  contenedor[h].getValor();
        }else {
            return null;
        }
    }

    public boolean esVacia() {
        return numElementos == 0;
    }

    public float getAlfaMax() {
        return alfaMax;
    }

    public void setAlfaMax(float alfaMax) {
        this.alfaMax = (alfaMax > 0.0f && alfaMax <= 1.0f) ? alfaMax : 0.8f;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public float factorCarga() {
        return numElementos / capacidad;
    }

    private boolean hayColision(int index) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean resultado = (stackTrace[2].getClassName() == "insertar")
                ? (contenedor[index].getEstado() == 1 && contenedor[index].getValor() != null)
                : ((contenedor[index].getEstado() == 1 && contenedor[index].getValor() != null) || contenedor[index].getEstado() == -1);
        return resultado;
    }

    private int funcionHash(int clave, int colisiones) {
        int resultadoHash = hash1(clave) + hash2(clave, colisiones);
        return (resultadoHash % capacidad);
    }

    private int hash1(int clave) {
        return clave % capacidad;
    }

    private int hash2(int clave, int colisiones) {
        return (colisiones * (7 - (clave % 7)));
    }

    private void redimensionar() {
        int capacidad2 = siguientePrimo(capacidad * 2);
        Celda[] contenedor2 = new Celda[capacidad2];
        for (int i = 0; i < capacidad2; i++) {
            if (contenedor[i] != null && contenedor[i].getEstado() == 1) {    //reubicamos en nueva tabla
                int h;   //nueva posicion
                int j = 0;   //colisiones
                do {
                    h = (hash1(contenedor[i].getClave()) + j * hash2(contenedor[i].getClave(), j)) % capacidad2;
                    j++;
                } while (contenedor2[h] != null);
                contenedor[h] = contenedor2[i]; //encontramos h(posicion vacia) en contenedor2 y asignamos la celda original
            }
        }
        //actualizamos variables
        contenedor = contenedor2;
        capacidad = capacidad2;
    }

    private boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int siguientePrimo(int n) {
        int siguiente = n + 1;
        while (!esPrimo(siguiente)) {
            siguiente++;
        }
        return siguiente;
    }

    public String toString() {   //la he visto en stack (hay que echarle un ojo)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contenedor.length; i++) {
            sb.append(i).append(" -> ");
            Celda<Valor> celda = contenedor[i];
            if (celda.getEstado() == 1) {
                sb.append(celda.getValor());
            } else {
                sb.append("-");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
