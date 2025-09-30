✅ ¿QUÉ HACE LA CLASE HELPER?  
-----------------------------  
* Es una clase utilitaria que te permite:  
	- Leer distintos tipos de datos desde el teclado.  
	- Validar que la entrada sea válida (número, texto, carácter, etc.).  
	- Imprimir arrays.  
	- Obtener los nombres de un enum.  
+ Esta clase evita que tengas que escribir validaciones repetitivas cada vez que lees datos del usuario.  

🧩 1. Objetos estáticos  
------------------------  
+ **static** *Random* random = **new** *Random()*;  
+ **static** *Scanner* scanner = **new** *Scanner(System.in)*;  

	- Se usa un solo Scanner y un solo Random para toda la clase.  
	- El `Scanner` es para *leer entradas del usuario*.  
	- El `Random` se puede usar para *generar números aleatorios* (aunque no se usa en este código).  

🧾 2. Entrada de datos  
----------------------  
🔢 getInteger(...)  
------------------  
   > ***public static Integer getInteger(String inputMessage)***  
📌 ¿Qué hace?  
- Pide al usuario un número entero (int) por consola.  
- Repite la pregunta hasta que el usuario ingrese un número válido.  

📌 ¿Cómo se usa?  
 >>> `int edad = Helper.getInteger("Ingrese su edad: ");`  

📌 ¿Qué devuelve?  
- Devuelve un Integer (ejemplo: 25).  

🧮 getDouble(...) y getFloat(...)  
----------------------------------  
- Funcionan igual que getInteger, pero para números con decimales:  
- **getDouble** devuelve un *Double*.  
- **getFloat** devuelve un *Float*.  

📌 Ejemplo:  
 >>> `double sueldo = Helper.getDouble("Ingrese su sueldo: ");`  

🔢 getLong(...)  
---------------  
- Similar a **getInteger**, pero devuelve un número más grande (*long*).  
- Se usa cuando se espera un número muy largo (como un número de cuenta bancaria, DNI largo, etc.).  

📌 Ejemplo:  
 >>> `long dni = Helper.getLong("Ingrese su DNI: ");`  

🅰️ getString(...)  
-----------------  
   > `public static String getString(String mensaje)`  

📌 ¿Qué hace?  
- Pide al usuario que escriba una cadena de texto.  
- **Rechaza** entradas vacías.  

 >>> `String nombre = Helper.getString("Ingrese su nombre: ");`  

🔤 getCharacter(...)  
--------------------  
- Este grupo de métodos permite leer **un solo carácter**. Tiene varias sobrecargas, con o sin mensajes de error personalizados.  

📌 Ejemplo de uso:  
 >>> `char opcion = Helper.getCharacter("Ingrese una letra (S/N): ");`  

🧰 3. Métodos auxiliares para Arrays  
-------------------------------------  
📌 ***printOneDimensionArray(...)***  
- Imprime un **arreglo unidimensional** (*Object[]*) con formato.  

📌 Ejemplo:  
 >>> `String[] nombres = {"Ana", "Luis", "Pedro"};`  
 >>> `Helper.printOneDimensionArray("Nombres: ", nombres, "\n");`  

📤 Salida esperada:  
 >>> `Nombres: [Ana,Luis,Pedro]`  

📌 ***printTwoDimensionArray(...)***  
- Imprime un **arreglo bidimensional** (*Object[][]*), como una *matriz*.  

📌 Ejemplo:  
 >>> `Integer[][] notas = { {7, 8}, {9, 10} };`  
 >>> `Helper.printTwoDimensionArray("Notas: ", notas, "\n");`  

📤 Salida esperada:  
 >>> `Notas: [[7,8],[9,10]]`  

📋 4. Métodos para Enums  
------------------------  
🧾 ***getEnumNames(Class<? extends Enum<?>> e)***n  

📌 ¿Qué hace?  
- Devuelve un *array de String* con los nombres de los valores de un *enum*.  

📌 Ejemplo:  
 >>> `enum Color { ROJO, VERDE, AZUL }`  
 >>> `String[] nombres = Helper.getEnumNames(Color.class);`  
 >>> `System.out.println(Arrays.toString(nombres));`  

📤 Salida esperada:  
 >>> `[ROJO, VERDE, AZUL]`  

✅ Resumen por tipo  
-------------------  
**Método**							**Tipo de dato que devuelve**	**Qué hace**  
getInteger(...)					Integer						Pide un número entero  
getLong(...)					Long						Pide un número largo  
getDouble(...)					Double						Pide un número decimal  
getFloat(...)					Float						Pide un número decimal (float)  
getString(...)					String						Pide una cadena no vacía  
getCharacter(...)				Character					Pide un solo carácter  
printOneDimensionArray(...)		void						Imprime un array de 1 dimensión  
printTwoDimensionArray(...)		void						Imprime un array de 2 dimensiones  
getEnumNames(...)				String[]					Devuelve los nombres de un enum  

🧠 ¿Cómo usarla en tu código?  
-----------------------------  
* *int* opcion = ***Helper.getInteger("Ingrese una opción: ")***;  
* *String* nombre = ***Helper.getString("Ingrese nombre del componente: ")***;  
* *double* precio = ***Helper.getDouble("Ingrese precio: ")***;  