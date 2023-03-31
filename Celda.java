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

    private int clave;

    Valor valor;

    private int estado;

    public static void main(String[] args) {
    }
    public Celda(){
    }
    public Celda(int clave, Valor v){
    }
    public boolean setEstado(int valorEstado){
        return true;
    }
    public void setClave(int valorClave){
    }
    public void setValor(){
    }
    public int getEstado(){
        return 0;
    }
    public int getClave(){
        return 0;
    }
    public void getValor(){
    }
    public boolean equals(){
        return true;
    }
}

