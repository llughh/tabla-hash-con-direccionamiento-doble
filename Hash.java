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

    /**
     * Array que contendra las celdas de la tabla Hash
     */
    private Celda<Valor>[] contenedor;
    /**
     * Elementos actualmente almacenados
     */
    private int numElementos;
    /**
     * Factor carga Max permitida en la tabla Hash
     */
    private float alfaMax;

    private int capacidad;

    /**
     * Tabla predeterminada
     */
    public Hash() {
        capacidad = 7;
        contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            contenedor[i] = new Celda<Valor>();
        }
        alfaMax = 0.8;
        numElementos = 0;

    }

    /**
     * Crea tabla Hash con tamaño especificado
     * @param capacidad: Tamaño inicial de la tabla hash
     */
    public Hash(int capacidad){
        this.capacidad = capacidad;
        contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++){
            contenedor[i] = new Celda<Valor>();
        }

        alfaMax = 0.8;
        numElementos = 0;

    }

    /**
     * Crea tabla Hash con el tamaño y el factor carga Max especificado
     * @param capacidad: Tamaño inicial de la tabla hash
     * @param alfaMax: Factor de carga Max permitido para la tabla hash.
     */
    public Hash(int capacidad, float alfaMax){
        this.capacidad = capacidad;
        this.alfaMax = alfaMax;
        numElementos = 0;
        contenedor = new Celda[capacidad];
        for (int i = 0; i < capacidad; i++) {
            contenedor[i] = new Celda<Valor>();
        }
    }

    /**
     * Inserta valores en la tabla Hash
     * @param clave: clave asociada al valor a insertar
     * @param v: valor a insertar
     */
    public void insertar(int clave, Valor v){
        if(factorCarga() >= alfaMax){
            redimensionar();
        }
        int h = hash1(clave); //calcula la posicion inicial de la celda
        if(contenedor[h] == null){
            contenedor[h] = new Celda<Valor>();
        }
        contenedor[h].setEstado(1);
        contenedor[h].setClave(clave);
        contenedor[h].setValor(v);
    }


    /**
     * Borra valor de la tabla Hash
     * @param clave: clave del valor a eliminar
     * @return True si se eliminó el valor
     * Si no se encuentra la celda con la clave clave o su estado no es 1, se devuelve false
     */
    public boolean borrar(int clave){
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


    /**
     * Obtiene el valor asociado a una clave en la tabla Hash
     * @param clave
     * @return El valor asociado a la clave, o null si la clave no está en la tabla Hash
     */
    public Valor get(int clave){

        int h = hash1(clave);
        if (contenedor[h] == null){
            return null;
        }else if (contenedor[h].getClave() == clave && contenedor[h].getEstado() == 1){
            return contenedor[h].getValor();
        }else {
            int h2 = hash2(clave);
            /**
             *
             */
        }
    }

    /**
     * Indica si la tabla hash está vacía
     * @return true si la tabla hash está vacía, false en caso contrario
     */
    public boolean esVacia(){
        return numElementos == 0;
    }

    /**
     * Obtiene el factor de carga Max para la tabla Hash
     * @return El factor de carga Max
     */
    public float getAlfaMax(){
        return 0;
    }

    /**
     * Establece el factor de carga Max para la tabla Hash
     * @param alfaMax factor de carga Max permitido
     * @return  valor anterior del factor de carga Max
     */
    public float setAlfaMax(float alfaMax){
        this.alfaMax = alfaMax;
    }

    /**
     * Devuelve el número de elementos que hay en la tabla de Hash
     * @return  número de elementos en la tabla Hash
     */
    public int getNumElementos(){
        return numElementos;
    }

    /**
     * Determina si hay factor carga en la tabla Hash
     * @return factor de carga de la tabla Hash
     */
    public float factorCarga(){
        return (float) numElementos / capacidad;
    }

    /**
     * Determina si hay colision en X celda
     * @return devuelve true si hay colision, false si no lo hay
     */
    private boolean hayColision(int index){
        return (contenedor[index].getEstado() == 1 && contenedor[index].getClave() != clave);
    }

    private int funcionHash(){
        return 0;
    }

    /**
     * Calcula el índice de la celda de la tabla de hash para una clave dada.
     * @param clave la clave para la que se va a calcular el índice.
     * @return índice de la celda de la tabla de hash.
     */
    private int hash1(int clave){
        return clave % capacidad;
    }

    /**
     * Funcion Hash secundaria en caso de colision
     * El resultado de la operación de módulo es el residuo de la división de la clave por N-1, y luego se suma 1 al resultado.
     * @param clave la clave para la que se va a calcular el índice.
     * @param colisiones el número de colisiones que ha habido en la celda.
     * @return índice de la celda de la tabla de hash.
     */
    private int hash2(int clave, int colisiones){
        return (clave % (N - 1)) + 1;
    }

    /**
     * Cambia el tamaño de la tabla de Hash
     */
    private void redimensionar(){
        int capacidad2 = siguientePrimo(capacidad*2);
        Celda<Valor> contenedor2 = new Celda[capacidad2];
        for (int i = 0; i<capacidad2; i++){
            if(contenedor[i] != null && contenedor[i].getEstado() == 1){    //reubicamos en nueva tabla
               int h;   //nueva posicion
               int j = 0;   //colisiones
                do {
                    h = (hash1(contenedor[i].getClave()) + j * hash2(contenedor[i].getClave, j)) % capacidad2;
                    j++;
                } while (capacidad2[h] != null);
                contenedor[h] = contenedor2[i]; //encontramos h(posicion vacia) en contenedor2 y asignamos la celda original
            }
        }
        //actualizamos variables
        contenedor = contenedor2;
        capacidad = capacidad2
    }

    /**
     * Determina si un número es primo o no
     * @return true si el número es primo, false si no
     */
    private boolean esPrimo(int n){
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
     * Devuelve el siguiente número primo más grande que el número dado
     * @return nuevo numero primo
     */
    private int siguientePrimo(int n){
        int siguiente = n + 1;
        while (!esPrimo(siguiente)) {
            siguiente++;
        }
        return siguiente;
    }

    /**
     * Devuelve una representación de cadena de la tabla de hash.
     *
     * @return una representación de cadena de la tabla de hash.
     */
    public String toString(){   //la he visto en stack (hay que echarle un ojo)
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
}
