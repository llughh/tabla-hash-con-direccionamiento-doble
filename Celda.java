/*
 - Practica: Implementacion de una tabla Hash
 - Grupo de TPA: P1-M21 7
 - Equipo de Trabajo: Vicente David Mut and Juan Carlos Sánchez
 - Expedientes: Vicente David Mut: 22083342   //   Juan Carlos Sánchez: 22064532
 - Fecha de creación: 24/03/2023
 - Fecha ultima de modificación: 31/3/2023
 - Version: 1
*/
//    H(clave, colisiones) = H1 (clave) + H2 (clave, colisiones)
//    H1 (clave) = clave mod N
//    H2 (clave, colisiones) = colisiones * (7 – (clave mod 7))
public class Celda <Valor> {

    /**
     * clave asociada a la celda
     */
    private int clave;

    /**
     * Objeto que representa el valor de la celda
     */
    Valor valor;

    /**
     * Sirve para indicar si la celda esta ocupada o no
     */
    private int estado;

    public Celda(){
        this.estado = 0;
        this.clave = null;
        this.valor = null;
    }

    /**
     * Constructor de celda con un clave-valor
     * @param clave la clave que se asociara con la celda
     * @param v El valor que se asocia con la clave
     */
    public Celda(int clave, Valor v){
        this.clave = clave;
        this.valor = valor;
    }

    /**
     * Para establecer el estado de celda
     * @param valorEstado Estado a establecer
     * @return true si se puede establecer el estado, false si no
     */
    public boolean setEstado(int estado){
        if(estado == 1 || estado == -1 || estado == 0) {
            this.estado = estado;
        }
    }

    /**
     * Método para establecer la clave asociada con la celda
     * @param valorClave la clave que se va a asociar con la celda
     */
    public void setClave(int clave){
        this.clave = clave;
    }

    /**
     * Método para establecer el valor asociado con la clave en la celda
     * @param v el valor que se va a asociar con la clave
     */
    public void setValor(Valor v){
        this.valor = valor;
    }

    /**
     * Método para obtener el estado de la celda
     * @return estado actual de la celda
     */
    public int getEstado(){
        return estado;
    }

    /**
     * Método para obtener la clave asociada con la celda
     * @return clave asociada con la celda
     */
    public int getClave(){
        return clave;
    }

    /**
     * Método para obtener el valor asociado con la clave en la celda.
     * @return el valor actual asociado con la clave en la celda.
     */
    public Valor getValor(){
        return valor;
    }

    /**
     * Método que verifica si dos celdas son iguales.
     * Si NO es una instancia de "Celda" devuelve false
     *
     */
    public boolean equals(Object object){
        if (object instanceof Celda<?>){
            Celda celda = (Celda) object;
            return this.clave == celda.clave && this.valor = celda.valor;
        }
        return false;
    }
}

