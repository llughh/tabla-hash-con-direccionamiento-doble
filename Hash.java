/*
 - Practica: Implementacion de una tabla Hash
 - Grupo de TPA: P1-M21 7
 - Equipo de Trabajo: Vicente David Mut and Juan Carlos Sánchez
 - Expedientes: Vicente David Mut: 22083342   //   Juan Carlos Sánchez: 22064532
 - Fecha de creación: 24/03/2023
 - Fecha ultima de modificación: 31/3/2023
 - Version: 1
*/
public class Hash <Valor> {

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

    public static void main(String[] args) {
    }

    public Hash() {
        /*
        this.contenedor = (Celda<Valor>[]) new Celda[10]; // ejemplo de tamaño inicial 10
        this.numElementos = 0;
        this.alfaMax = alfaMax;*/
    }

    /**
     * Crea tabla Hash con tamaño especificado
     * @param capacidad: Tamaño inicial de la tabla hash
     */
    public Hash(int capacidad){

    }

    /**
     * Crea tabla Hash con el tamaño y el factor carga Max especificado
     * @param capacidad: Tamaño inicial de la tabla hash
     * @param alfaMax: Factor de carga Max permitido para la tabla hash.
     */
    public Hash(int capacidad, float alfaMax){

    }

    /**
     * Inserta valores en la tabla Hash
     * @param clave: clave asociada al valor a insertar
     * @param v: valor a insertar
     */
    public void insertar(int clave, Valor v){
    }

    /**
     * Borra valor de la tabla Hash
     * @param claveBorrar: clave del valor a eliminar
     * @return true si se eliminó el valor, false en caso contrario
     */
    public boolean borrar(int claveBorrar){
        return true;
    }

    /**
     * Obtiene el valor asociado a una clave en la tabla Hash
     * @param clave
     * @return El valor asociado a la clave, o null si la clave no está en la tabla Hash
     */
    public Valor get(int clave){
        return null;
    }

    /**
     * Indica si la tabla hash está vacía
     * @return true si la tabla hash está vacía, false en caso contrario
     */
    public boolean esVacia(){
        return true;
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
        return 0;
    }

    /**
     * Devuelve el número de elementos que hay en la tabla de Hash
     * @return  número de elementos en la tabla Hash
     */
    public int getNumElementos(){
        return 0;
    }

    /**
     * Determina si hay factor carga en la tabla Hash
     * @return factor de carga de la tabla Hash
     */
    public float factorCarga(){
        return 0;
    }

    /**
     * Determina si hay colision en X celda
     * @return devuelve true si hay colision, false si no lo hay
     */
    private boolean hayColision(){
        return true;
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
        return 0;
    }

    /**
     * Funcion Hash secundaria en caso de colision
     * @param clave la clave para la que se va a calcular el índice.
     * @param colisiones el número de colisiones que ha habido en la celda.
     * @return índice de la celda de la tabla de hash.
     */
    private int hash2(int clave, int colisiones){
        return 0;
    }

    /**
     * Cambia el tamaño de la tabla de Hash
     */
    private void redimensionar(){

    }

    /**
     * Determina si un número es primo o no
     * @return true si el número es primo, false si no
     */
    private boolean esPrimo(){
        return true;
    }

    /**
     * Devuelve el siguiente número primo más grande que un número dado
     * @return nuevo numero primo
     */
    private int siguientePrimo(){
        return 0;
    }

    /**
     * Devuelve una representación de cadena de la tabla de hash.
     *
     * @return una representación de cadena de la tabla de hash.
     */
    public String toString(){
        return "";
    }
}
