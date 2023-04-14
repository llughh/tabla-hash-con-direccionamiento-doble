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
        capacidad = 7;
        contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            contenedor[i] = new Celda<Valor>();
        }
        alfaMax = 0.8f;
        numElementos = 0;

    }

    public Hash(int capacidad) {
        this.capacidad = capacidad;
        contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            contenedor[i] = new Celda<Valor>();
        }

        alfaMax = 0.8f;
        numElementos = 0;

    }

    public Hash(int capacidad, float alfaMax) {
        this.capacidad = capacidad;
        this.alfaMax = (alfaMax < 1.0f && alfaMax > 0.0) ? alfaMax : 0.8f;
        numElementos = 0;
        contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            contenedor[i] = new Celda<Valor>();
        }
    }

    public void insertar(int clave, Valor v) {
        int h = hash1(clave); //calcula la posicion inicial de la celda

        if (factorCarga() < alfaMax) {
            if (contenedor[h] == null) {
                contenedor[h] = new Celda<Valor>();
            }
            contenedor[h].setEstado(1);
            contenedor[h].setClave(clave);
            contenedor[h].setValor(v);
        }else {
            redimensionar();
        }

    }

    public boolean borrar(int clave) {
        int i = 0;
        int h;
        do {
            h = (hash1(clave) + i * hash2(clave, i)) % capacidad;
            i++;
        } while (contenedor[h] != null && (contenedor[h].getEstado() == 0 || contenedor[h].getClave() != clave) && i < capacidad);

        if (contenedor[h] != null && contenedor[h].getClave() == clave && contenedor[h].getEstado() == 1) {
            contenedor[h].setEstado(-1);
            numElementos--;
            return true;
        }
        return false;
    }

    public Valor get(int clave) {
        int h = hash1(clave);
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
        this.alfaMax = alfaMax;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public float factorCarga() {
        return (float) numElementos / capacidad;
    }

    private boolean hayColision(int index) {
        return (contenedor[index].getEstado() == 1 || contenedor[index].getEstado() == -1 && contenedor[index].getValor() != null);
    }

    private int funcionHash(int clave, int colisiones) {
        return hash1(clave) + hash2(clave, colisiones);
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
       /* @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tabla.length; i++) {
                sb.append(i).append(": ");
                Celda<V> celda = tabla[i];
                if (celda.getEstado() == 1) {
                    sb.append(celda.getValor());
                } else {
                    sb.append("-");
                }
                sb.append("\n");
            }
            return sb.toString();
        }    }*/
        return "";
    }//
}
