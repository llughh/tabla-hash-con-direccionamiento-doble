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

    private Celda<Valor>[] contenedor;

    private int numElementos;

    private float alfaMax;

    public static void main(String[] args) {
    }

    public Hash() {
        /*
        this.contenedor = (Celda<Valor>[]) new Celda[10]; // ejemplo de tamaño inicial 10
        this.numElementos = 0;
        this.alfaMax = alfaMax;*/
    }

    public Hash(int capacidad){

    }

    public Hash(int capacidad, float alfaMax){

    }

    public void insertar(int numeroInsertar, Valor v){
    }

    public boolean borrar(int claveBorrar){
        return true;
    }
    public Valor get(int clave){
        return null;
    }
    public boolean esVacia(){
        return true;
    }
    public float getAlfaMax(){
        return 0;
    }
    public float setAlfaMax(){
        return 0;
    }
    public int getNumElementos(){
        return 0;
    }
    public float factorCarga(){
        return 0;
    }
    private boolean hayColision(){
        return true;
    }
    private int funcionHash(){
        return 0;
    }
    private int hash1(int clave){
        return 0;
    }
    private int hash2(int clave, int colisiones){
        return 0;
    }
    private void redimensionar(){

    }
    private boolean esPrimo(){
        return true;
    }
    private int siguientePrimo(){
        return 0;
    }
    public String toString(){
        return "";
    }
}
