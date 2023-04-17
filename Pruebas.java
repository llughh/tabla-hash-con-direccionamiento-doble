/*
 - Practica: Implementacion de una tabla Hash
 - Grupo de TPA: P1-M21 7
 - Equipo de Trabajo: Vicente David Mut and Juan Carlos Sánchez
 - Expedientes: Vicente David Mut: 22083342   //   Juan Carlos Sánchez: 22064532
 - Fecha de creación: 24/03/2023
 - Fecha ultima de modificación: 16/4/2023
 - Version: 1
*/

public class Pruebas {
    public static void main(String[] args) {
        // Crear una instancia de Hash
        Hash<Integer> hash = new Hash<Integer>();

        // Insertar elementos en el hash
        hash.insertar(1, 10);
        hash.insertar(2, 20);
        hash.insertar(3, 30);
        hash.insertar(4, 40);
        hash.insertar(5, 50);
        hash.insertar(6, 60);

        System.out.println("\nPruebas constructor Hash por defecto:\n ");

        // Obtener el valor de una clave
        System.out.println("Valor de clave 2: " + hash.get(2)); // Debe imprimir 20

        // Borrar un elemento por clave
        boolean resultadoBorrar = hash.borrar(3);
        System.out.println("Elemento borrado: " + resultadoBorrar); // Debe imprimir true
        hash.borrar(6); //debe borrar el elemetno con clave 6


        // Verificar si el hash está vacío
        boolean esVacia = hash.esVacia();
        System.out.println("El hash está vacío: " + esVacia); // Debe imprimir false

        // Obtener el factor de carga del hash
        float factorCarga = hash.factorCarga();
        System.out.println("Factor de carga: " + factorCarga); // Debe imprimir 0.6


        // Obtener el número de elementos en el hash
        int numElementos = hash.getNumElementos();
        System.out.println("Número de elementos: " + numElementos); // Debe imprimir 4

        System.out.println(hash.toString());

        System.out.println("-------------------------");

        Hash<Integer> hash2 = new Hash<Integer>(10);

        // Insertar elementos en el hash
        hash2.insertar(1, 10);
        hash2.insertar(2, 20);
        hash2.insertar(3, 30);
        hash2.insertar(4, 40);
        hash2.insertar(5, 50);
        hash2.insertar(6, 60);
        hash2.insertar(7, 70);


        System.out.println("\nPruebas constructor Hash con capacidad inicial 10:\n ");

        // Obtener el valor de una clave
        System.out.println("Valor de clave 5: " + hash2.get(5)); // Debe imprimir 50

        // Borrar un elemento por clave
        System.out.println("Elemento borrado: " + hash2.borrar(2)); // Debe imprimir true
        System.out.println("Elemento borrado: " + hash2.borrar(6)); // Debe imprimir true



        // Verificar si el hash está vacío
        boolean esVacia2 = hash2.esVacia();
        System.out.println("El hash está vacío: " + esVacia2); // Debe imprimir false

        // Obtener el factor de carga del hash
        float factorCarga2 = hash2.factorCarga();
        System.out.println("Factor de carga: " + factorCarga2); // Debe imprimir 0.6


        // Obtener el número de elementos en el hash
        System.out.println("Número de elementos: " + hash2.getNumElementos()); // Debe imprimir 5

        System.out.println(hash2.toString());

        System.out.println("-------------------------");

        Hash<Integer> hash3 = new Hash<Integer>(8, 0.5f);

        // Insertar elementos en el hash
        hash3.insertar(1, 10);
        hash3.insertar(2, 20);
        hash3.insertar(3, 30);
        hash3.insertar(4, 40);

        System.out.println("\nPruebas constructor Hash con capacidad inicial 5 y alfaMax 0.5:\n ");

        System.out.println("Valor de clave 1: " + hash3.get(1)); // Debe imprimir 10

        // Borrar un elemento por clave
        System.out.println("Elemento borrado: " + hash3.borrar(3)); // Debe imprimir true

        // Verificar si el hash está vacío
        boolean esVacia3 = hash3.esVacia();
        System.out.println("El hash está vacío: " + esVacia3); // Debe imprimir false

        float factorCarga3 = hash3.factorCarga();
        System.out.println("Factor de carga: " + factorCarga3); // Debe imprimir 0.5

        // Obtener el número de elementos en el hash
        System.out.println("Número de elementos: " + hash3.getNumElementos()); // Debe imprimir 3

        System.out.println(hash3.toString());

        System.out.println("-------------------------");
    }
}

