4) Implementar la clase Evento que posea los siguientes atributos: tipo (info, advertencia, error), descripción y codigo. Utilizar una pila para almacenar los eventos recientes del sistema. El programa debe implementar los siguientes métodos:
	
	1. [x] registrarEvento: recibe como parámetro la pila y el evento, debe agregar el evento a la pila.
	
	2. [x] eliminarEventosDeTipo: recibe como parámetro la pila y el tipo, elimina todos los eventos del tipo especificado (por ejemplo "info"). El resto de los elementos de la pila no debe alterarse.
	
	3. [x] buscarEventoPorCodigo: recibe como parámetro la pila y un código, devuelve el primer evento que coincida con el código (sin modificar la pila).
	
	4. [x] contarErrores: recibe como parámetro la pila y devuelve cuántos eventos son del tipo "error".