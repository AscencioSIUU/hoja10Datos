# Ruta Más Corta para Suministros Médicos

## Descripción del Problema

La pandemia de Covid-19 ha motivado el establecimiento de cordones sanitarios en varios lugares de la República. Estos son establecidos por una temporada y retirados cuando ya se ha contenido el virus en la localidad. Pero esto implica que los desplazamientos a lo largo de las carreteras del país son alterados dinámicamente.

El objetivo de este proyecto es planificar la ruta más corta entre los distintos hospitales y puestos de salud localizados en todo el territorio nacional. Se debe enviar suministros de salud e higiene como mascarillas N95, guantes, trajes desechables, test para detectar el coronavirus y medicamentos.

Para ello, se ha desarrollado un programa que utiliza un grafo dirigido, cuyos nodos son las ciudades (que pueden ser cabeceras municipales, aldeas o caseríos importantes, en donde existen hospitales y puestos de salud) de Guatemala y los arcos son la distancia, expresada en KM, que existe entre un par de ciudades. El programa debe ser capaz de actualizar dinámicamente el grafo para indicar que no existe conexión directa entre algún par de ciudades debido a desastres naturales o cordones sanitarios.

## Funcionalidades del Programa

El programa ofrece las siguientes funcionalidades:
1. Calcular la ruta más corta entre dos ciudades.
2. Indicar la ciudad que queda en el centro del grafo.
3. Modificar el grafo indicando interrupciones de tráfico o nuevas conexiones.
4. Finalizar el programa.

## Autor

- **Nombre**: Ernesto Ascencio
- **Carné**: 23009

## Archivos del Proyecto

### Código Fuente
- `App.java`: Contiene el menú principal del programa y la interacción con el usuario.
- `Edge.java`: Representa una arista en el grafo.
- `FileParser.java`: Se encarga de leer y parsear el archivo `guategrafo.txt`.
- `FloydAlgorithm.java`: Implementa el algoritmo de Floyd-Warshall para encontrar las rutas más cortas.
- `Graph.java`: Representa el grafo y contiene métodos para agregar y eliminar aristas.
- `GraphCenter.java`: Contiene el algoritmo para encontrar el centro del grafo.
- `Vertex.java`: Representa un vértice en el grafo.

### Pruebas Unitarias
- `EdgeTest.java`: Pruebas unitarias para la clase `Edge`.
- `FileParserTest.java`: Pruebas unitarias para la clase `FileParser`.
- `FloydAlgorithmTest.java`: Pruebas unitarias para la clase `FloydAlgorithm`.
- `GraphTest.java`: Pruebas unitarias para la clase `Graph`.
- `GraphCenterTest.java`: Pruebas unitarias para la clase `GraphCenter`.
- `VertexTest.java`: Pruebas unitarias para la clase `Vertex`.

### Archivo de Datos
- `guategrafo.txt`: Archivo de texto que contiene las rutas entre las ciudades en el siguiente formato:
```console
Ciudad1 Ciudad2 KM
Mixco Antigua 30
Antigua Escuintla 25
Escuintla SantaLucia 15
```
## Instrucciones de Uso
Descarga:
```console
https://github.com/AscencioSIUU/hoja10Datos.git 
```
1. Coloca todos los archivos del proyecto en el mismo directorio.
2. Asegúrate de que `guategrafo.txt` esté en el directorio raíz del proyecto.
3. Compila y ejecuta `App.java` desde tu entorno de desarrollo o línea de comandos.
4. Disfruta
   