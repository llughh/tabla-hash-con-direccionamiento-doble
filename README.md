# Tabla Hash

El codigo implementa una tabla Hash de codificación propia. Para ello se crean dos clases genéricas: Hash y Celda. 

La clase Hash representará la propia tabla. Utilizará direccionamiento abierto con doble hashing como estrategia para la resolución de colisiones. 

En cada posición de la tabla se almacenará un objeto de la clase Celda. 

Cada celda (ver figura 1) almacena la clave y el valor del elemento, además del estado de esa posición (borrado = -1, vacío = 0, ocupado = 1)
![image](https://user-images.githubusercontent.com/88946644/232522759-f271ecfd-7654-45f7-9525-318a1dca9085.png)

Tanto la capacidad de la tabla como el umbral máximo del factor de carga son datos configurables. De no especificarse, se tomarán por defecto N=7 y el 80% como el
máximo.

La función hash viene definida de la siguiente manera:

• H(clave, colisiones) = H1 (clave) + H2 (clave, colisiones)
• H1 (clave) = clave mod N
• H2 (clave, colisiones) = colisiones * (7 – (clave mod 7)

Antes de insertar un dato, comprobamos que no se vaya a exceder el umbral de carga. De ser así, la tabla se redimensiona antes de la inserción. 
Los pasos seguidos en este caso es:

1. Duplica el tamaño de la tabla original: NT = 2N
2. Busca el siguiente número primo por encima de NT.
3. Recorre desde el principio hasta el final la tabla original, insertando los datos que se vayan encontrando en la nueva tabla hash.
4. Inserta el dato que ha forzado el redimensionamiento.
5. Sustituye la tabla original por la nueva tabla ampliada.

Aparte hemos generado una clase pruebas en la cual se pone a test lo antes mencionado.
