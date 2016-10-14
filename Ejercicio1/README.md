Ejercicio 1
-----------

Utiliza el CompletionService junto con un newFixedThreadExecutor para simular

la ejecución de un número de descargas que queremos que se realicen como máximo 2 a la vez.

Simularemos las descargas con sleep(), y el tiempo de descarga variará de entre 10 y 20 segundos.

Queremos que cada vez que se "descargue" un archivo nos lo imprima por pantalla.

Queremos imprimir el estado del thread pool después de cada descarga.
