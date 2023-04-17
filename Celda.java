/*
 - Practica: Implementacion de una tabla Hash
 - Grupo de TPA: P1-M21 7
 - Equipo de Trabajo: Vicente David Mut and Juan Carlos Sánchez
 - Expedientes: Vicente David Mut: 22083342   //   Juan Carlos Sánchez: 22064532
 - Fecha de creación: 24/03/2023
 - Fecha ultima de modificación: 31/3/2023
 - Version: 1
*/

public class Celda<Valor> {

    private int clave;
    Valor valor;
    private int estado;

    public Celda(){
        this.estado = 0;
        this.clave = 0;
        this.valor = null;
    }
    public Celda(int clave, Valor v){
        this.clave = clave;
        this.valor = v;
    }
    public boolean setEstado(int estado){
        if(estado == 1 || estado == -1 || estado == 0) {
            this.estado = estado;
        }
        return false;
    }
    public void setClave(int clave){
        this.clave = clave;
    }

    public void setValor(Valor v){
        this.valor = v;
    }

    public int getEstado(){
        return estado;
    }

    public int getClave(){
        return clave;
    }

    public Valor getValor(){
        return valor;
    }

    public boolean equals(Object object){

        if (object instanceof Celda){
            Celda celda = (Celda) object;
            return this.clave == celda.clave && this.valor == celda.valor;
        }
        return false;
    }
}

