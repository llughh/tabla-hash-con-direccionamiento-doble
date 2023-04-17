/*
 - Practica: Implementacion de una tabla Hash
 - Grupo de TPA: P1-M21 7
 - Equipo de Trabajo: Vicente David Mut and Juan Carlos Sánchez
 - Expedientes: Vicente David Mut: 22083342   //   Juan Carlos Sánchez: 22064532
 - Fecha de creación: 24/03/2023
 - Fecha ultima de modificación: 16/04/2023
 - Version: 5
*/


public class Hash<Valor> {

    private Celda<Valor>[] contenedor;  //Array que representa la tabla hash
    private int numElementos;   //Numero de lemetnos almazenados en la tabla Hash
    private float alfaMax;  //Factor de carga máximo
    private int capacidad;  //Capacidad inicial de la tabla

    /**
     * Constructor por defecto de la tabla Hash
     * - capacidad inicial: 7
     * - factor de carga maximo: 0.8
     * - tabla vacia
     */
    public Hash() {
        this.capacidad = 7;
        this.contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            this.contenedor[i] = new Celda<Valor>();
        }
        this.alfaMax = 0.8f;
        this.numElementos = 0;

    }

    /**
     * Constructor de la clase Hash que permite definir la capacidad inicial de la tabla
     * @param capacidad Capacidad inicial de la tabla Hash
     * - factor de carga maximo: 0.8
     * - tabla vacia
     */
    public Hash(int capacidad) {
        this.capacidad = capacidad;
        this.contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            this.contenedor[i] = new Celda<Valor>();
        }
        this.alfaMax = 0.8f;
        this.numElementos = 0;
    }

    /**
     * Constructor de la clase Hash que permite definir la capacidad inicial y el factor de carga máximo.
     * @param capacidad Capacidad inicial de la tala Hash
     * @param alfaMax El factor de carga maximo permitido en tabla
     */
    public Hash(int capacidad, float alfaMax) {
        this.capacidad = capacidad;
        this.alfaMax = (alfaMax < 1.0f && alfaMax > 0.0f) ? alfaMax : 0.8f;
        this.numElementos = 0;
        this.contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            this.contenedor[i] = new Celda<Valor>();
        }
    }

    /**
     * Método para insertar un elemetno en la tabla Hash
     * @param clave Clave del elemetno a insertar
     * @param v Valor del elemento a insertar
     */
    public void insertar(int clave, Valor v) {
        int colisiones = 0;
        int colisionesAux = 0;
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
            while (hayColision(funcionHash(clave, colisionesAux))){
                colisionesAux++;
                h2 = funcionHash(clave, colisionesAux);
            }
            if (contenedor[h2] == null) {
                contenedor[h2] = new Celda<Valor>();
            }
            contenedor[h2].setEstado(1);
            contenedor[h2].setClave(clave);
            contenedor[h2].setValor(v);


        }
        numElementos++;
    }

    /**
     * Metodo para borrar un elemento de la tabla Hash
     * @param clave Clave del elemento a borrar
     * @return true si el elemento se ha borrado / false si no se ha borrado
     */
    public boolean borrar(int clave) {
        int colisiones = 0; //contador de colisiones
        int maxColisiones = 15;
        int h = funcionHash(clave, colisiones);
        while (hayColision(h) && contenedor[h].getClave() != clave && colisiones <= maxColisiones){ //Encuentra el elemento a borrar
            colisiones++;
            h = funcionHash(clave, colisiones);
        }

        if (contenedor[h] != null && contenedor[h].getClave() == clave && contenedor[h].getEstado() == 1) {
            contenedor[h].setEstado(-1);
            contenedor[h].setValor(null);
            contenedor[h].setClave(0);
            numElementos--;
            return true;
        }

        return false;
    }

    /**
     * El metodo obtiene el valor asociado a una clave
     * @param clave Clave a buscar
     * @return el valor asociado a la clave, si no lo encuentra null
     */
    public Valor get(int clave) {
        int colisiones = 0;
        int maxColisiones = 15;
        int h = funcionHash(clave, colisiones);
        while (hayColision(h) && contenedor[h].getClave() != clave && colisiones <= maxColisiones){
            colisiones++;
            h = funcionHash(clave, colisiones);
        }
        if (contenedor[h] != null && contenedor[h].getClave() == clave && contenedor[h].getEstado() == 1) {
            return  contenedor[h].getValor();
        }else {
            return null;
        }
    }

    /**
     * Verifica si la tabla esta vacia
     * @return true si esta vacia / false si no lo esta
     */
    public boolean esVacia() {
        return numElementos == 0;
    }

    /**
     * Obtiene el valor de alfaMax
     * @return el valor del factor de carga máximo
     */
    public float getAlfaMax() {
        return alfaMax;
    }

    /**
     * Establece el valor de alfamax
     * @param alfaMax nuevo alfaMax
     */
    public void setAlfaMax(float alfaMax) {
        this.alfaMax = (alfaMax > 0.0f && alfaMax <= 1.0f) ? alfaMax : 0.8f;
    }

    /**
     * Obtiene el numero de elemetnos en la tabla
     * @return
     */
    public int getNumElementos() {
        return numElementos;
    }

    /**
     * Calcula el factorCarga de la tabla
     * @return nuevo factor carga
     */
    public float factorCarga() {
        return (float)(numElementos+1) / (float)capacidad;
    }

    /**
     * Verifica si hay colision en X posicion de la tabla
     * @param index posicion en el contenedor
     * @return true si hay colision / false si no hay colision
     */
    private boolean hayColision(int index) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean resultado = (stackTrace[2].getClassName() == "insertar")
                ? (contenedor[index].getEstado() == 1 && contenedor[index].getValor() != null)
                : ((contenedor[index].getEstado() == 1 && contenedor[index].getValor() != null) || contenedor[index].getEstado() == -1);
        return resultado;
    }

    /**
     * Calcula el valor hash de la clave con el numero de colisiones dado.
     * @param clave Clave para calcular el valor Hash
     * @param colisiones Numero de colisiones
     * @return Valor Hash calculado
     */
    private int funcionHash(int clave, int colisiones) {
        int resultadoHash = hash1(clave) + hash2(clave, colisiones);
        return (resultadoHash % capacidad);
    }

    /**
     * Calcual el valor de H1
     * @param clave Clave para calcular el valor Hash1
     * @return H1
     */
    private int hash1(int clave) {
        return clave % capacidad;
    }

    /**
     * Calcula el valor de H2
     * @param clave Clave para calcular H2
     * @param colisiones
     * @return H2
     */
    private int hash2(int clave, int colisiones) {
        return (colisiones * (7 - (clave % 7)));
    }

    /**
     * Realiza la redimension de la tabla cuando es necesario
     */
    private void redimensionar() {
        int nuevaCapacidad = siguientePrimo(capacidad * 2);
        int viejaCapacidad  = capacidad;
        Celda<Valor>[] nuevoContenedor = new Celda[nuevaCapacidad];
        Celda<Valor>[] viejoContenedor = new Celda[nuevaCapacidad];

        viejoContenedor = contenedor;
        contenedor = nuevoContenedor;
        capacidad = nuevaCapacidad;
        for (int i = 0; i < capacidad; i++) {
            this.contenedor[i] = new Celda<Valor>();
        }

        // Copiar elementos del antiguo contenedor al nuevo contenedor
        for (int i = 0; i < viejaCapacidad; i++) {
            if (viejoContenedor[i].getEstado() == 1) {
                int clave = viejoContenedor[i].getClave();
                Valor valor = viejoContenedor[i].getValor();
                insertar(clave, valor);
                numElementos--;

            }
        }

    }

    /**
     * Verifica si un numero dado es primo
     * @param n Numero a verificar
     * @return true si el numero es primo / false si no es primo
     */
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

    /**
     * Encuentra el siguiente numero primo mayor al dado
     * @param n Numermo a partir del cual se busca el siguiente primo
     * @return
     */
    private int siguientePrimo(int n) {
        int siguiente = n + 1;
        while (!esPrimo(siguiente)) {
            siguiente++;
        }
        return siguiente;
    }

    /**
     *Devuelve una representación en forma de cadena de caracteres de la tabla Hash.
     * @return represenatación de la tabla
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        for (int i = 0; i < capacidad; i++) {
            Celda<Valor> celdaActual = contenedor[i];
            sb.append(i).append(" -> ").append(celdaActual.getClave()).append(" -> ").append(celdaActual.getValor());
            sb.append("\n");
        }
        // Eliminar la última coma y espacio si hay elementos en la tabla
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("\n");
        return sb.toString();
    }
}
