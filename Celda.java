/*
 - Practica: Implementacion de una tabla Hash
 - Grupo de TPA: P1-M21 7
 - Equipo de Trabajo: Vicente David Mut and Juan Carlos Sánchez
 - Expedientes: Vicente David Mut: 22083342   //   Juan Carlos Sánchez: 22064532
 - Fecha de creación: 24/03/2023
 - Fecha ultima de modificación: 31/3/2023
 - Version: 1
*/


/**
 * Clase generica que contine una clave, valor y un estado.
 * @param <Valor> Tipo de valor contenido en la celda.
 */
public class Celda<Valor> {
    private int clave;
    Valor valor;
    private int estado;

    /**
     * Contructor sin parametros.
     */
    public Celda(){
        this.estado = 0;
        this.clave = 0;
        this.valor = null;
    }

    /**
     * Constructor que toma una clave y un valor como parametros.
     * @param clave La clave de la celda.
     * @param v El valor de la celda.
     */
    public Celda(int clave, Valor v){
        this.clave = clave;
        this.valor = v;
    }

    /**
     * Establece el Estado de la celda
     * @param estado Estado de la celda que puede ser unicamente 1, 0, -1.
     * @return true si puedo establcer el Estado / false si no.
     */
    public boolean setEstado(int estado){
        if(estado == 1 || estado == -1 || estado == 0) {
            this.estado = estado;
            return true;
        }
        return false;
    }

    /**
     * Establece la Clave de la Celda.
     * @param clave
     */
    public void setClave(int clave){
        this.clave = clave;
    }

    /**
     * Establece el valor de la Celda.
     * @param v
     */
    public void setValor(Valor v){
        this.valor = v;
    }

    /**
     * Obtiene el Estado de la Celda
     * @return
     */
    public int getEstado(){
        return estado;
    }

    /**
     * Obtiene la Clave de la Celda
     * @return
     */
    public int getClave(){
        return clave;
    }

    /**
     * Obtiene el Valor de la Celda
     * @return
     */
    public Valor getValor(){
        return valor;
    }

    /**
     * Obtiene si dos Celdas son iguales
     * @param object Objeto a compara con la Celda
     * @return ture si las Celdas son iguales / false si no lo son
     */
    public boolean equals(Object object){

        if (object instanceof Celda){
            Celda celda = (Celda) object;
            return this.clave == celda.clave && this.valor == celda.valor;
        }
        return false;
    }
}
