/*
 - Practica: Implementacion de una tabla Hash
 - Grupo de TPA: P1-M21 7
 - Equipo de Trabajo: Vicente David Mut and Juan Carlos Sánchez
 - Expedientes: Vicente David Mut: 22083342   //   Juan Carlos Sánchez: 22064532
 - Fecha de creación: 24/03/2023
 - Fecha ultima de modificación: 31/3/2023
 - Version: 1
*/
public class Celda <Valor> {
//    H(clave, colisiones) = H1 (clave) + H2 (clave, colisiones)
//    H1 (clave) = clave mod N
//    H2 (clave, colisiones) = colisiones * (7 – (clave mod 7))

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

    public static void main(String[] args) {
    }
    public Celda(){
    }

    /**
     * Constructor de celda con un clave-valor
     * @param clave la clave que se asociara con la celda
     * @param v El valor que se asocia con la clave
     */
    public Celda(int clave, Valor v){
    }

    /**
     * Para establecer el estado de celda
     * @param valorEstado Estado a establecer
     * @return true si se puede establecer el estado, false si no
     */
    public boolean setEstado(int valorEstado){
        return true;
    }

    /**
     * Método para establecer la clave asociada con la celda
     * @param valorClave la clave que se va a asociar con la celda
     */
    public void setClave(int valorClave){
    }

    /**
     * Método para establecer el valor asociado con la clave en la celda
     * @param v el valor que se va a asociar con la clave
     */
    public void setValor(Valor v){
    }

    /**
     * Método para obtener el estado de la celda
     * @return estado actual de la celda
     */
    public int getEstado(){
        return 0;
    }

    /**
     * Método para obtener la clave asociada con la celda
     * @return clave asociada con la celda
     */
    public int getClave(){
        return 0;
    }

    /**
     * Método para obtener el valor asociado con la clave en la celda.
     * @return el valor actual asociado con la clave en la celda.
     */
    public Valor getValor(){
        return null;
    }

    /**
     * Método que verifica si dos celdas son iguales.
     * @return true si las dos celdas son iguales, false si no
     */
    public boolean equals(){
        return true;
    }
}

