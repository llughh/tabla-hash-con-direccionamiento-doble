/*
 - Practica: Implementacion de una tabla Hash
 - Grupo de TPA: P1-M21 7
 - Equipo de Trabajo: Vicente David Mut and Juan Carlos Sánchez
 - Expedientes: Vicente David Mut: 22083342   //   Juan Carlos Sánchez: 22064532
 - Fecha de creación: 24/03/2023
 - Fecha ultima de modificación: 31/3/2023
 - Version: 1
*/

public class Pruebas{
    public static void main(String[] args) {
        Hash<Integer> hash = new Hash<Integer>();

        hash.insertar(1, 10);
        hash.insertar(2, 11);
        hash.insertar(3, 12);
        hash.insertar(4, 13);
        hash.insertar(5, 14);

        // Obtener elementos del hash
        System.out.println("Elemento con clave 1: " + hash.get(1));
        System.out.println("Elemento con clave 3: " + hash.get(3));

        // Borrar elementos del hash
        System.out.println("Borrando elemento con clave 4: " + hash.borrar(4));
        System.out.println("Borrando elemento con clave 2: " + hash.borrar(2));


        System.out.println("Elemento con clave 1: " + hash.get(1));

        // Verificar si el hash está vacío
        System.out.println("¿El hash está vacío?: " + hash.esVacia());

        // Obtener el factor de carga del hash
        System.out.println("Factor de carga del hash: " + hash.factorCarga());

        // Modificar el valor de alfaMax en el hash
        hash.setAlfaMax(0.7f);

        // Obtener el número de elementos en el hash
        System.out.println("Número de elementos en el hash: " + hash.getNumElementos());

    }

}
