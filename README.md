# Taller-7-FIS
## 01. ¿Qué responsabilidades tiene exactamente esta clase?

Esta clase tiene **demasiadas responsabilidades al mismo tiempo**. No solo calcula, sino que también:

- muestra el menú en consola,
- lee datos del usuario,
- decide qué operación ejecutar,
- realiza las operaciones aritméticas,
- valida errores de entrada o de dominio,
- imprime resultados en pantalla,
- y además controla el ciclo principal del programa.

O sea, en una sola clase se mezclan responsabilidades de:

- **interfaz de usuario**,
- **lógica del programa**,
- **reglas de validación**,
- **y operaciones matemáticas**.

Eso va en contra del principio de **responsabilidad única** porque la clase tiene demasiados motivos para cambiar.

---

## 02. Si cambio la forma de imprimir en consola, ¿qué pasa con las operaciones?

En esta implementación, todo queda **fuertemente acoplado**. Entonces, si cambias la forma de imprimir en consola, seguramente terminas tocando la misma clase donde también están las operaciones.

Por ejemplo, si en vez de usar `System.out.println()` quieres:

- imprimir con otro formato,
- guardar resultados en archivo,
- mostrar un menú distinto,
- o pasar luego a interfaz gráfica,

igual tendrías que modificar la clase principal.

Las operaciones matemáticas en teoría seguirían siendo las mismas, pero como están metidas dentro de la misma clase, **quedan arrastradas por cualquier cambio de presentación**. Ese es el problema: no están aisladas.

---

## 03. Si quiero tener 2 menús distintos, ¿qué debería modificar?

Tendria que modificar directamente la misma clase, probablemente:

- el método `mostrarMenu()`,
- la lógica del `switch`,
- y posiblemente también la forma en que se leen y ejecutan las opciones.

Si lo quisiera asi, por ejemplo:

- un menú básico,
- y otro menú avanzado,

 Tocaría meter más condicionales dentro de la misma clase. Eso hace que el código crezca desordenado y cada vez sea más difícil de mantener.

En otras palabras, para agregar dos menús distintos no solo cambias la parte visual, sino también el flujo del programa, porque todo está amarrado en el mismo sitio.

---

## 04. ¿Cómo adiciono operaciones nuevas (ej. Potencia)? ¿Rompe algo más?

Para agregar una operación nueva como **potencia**, tocaría modificar varias partes de la clase:

1. agregar una nueva opción en `mostrarMenu()`,
2. agregar un nuevo `case` en el `switch` del `main`,
3. decidir si se reutiliza `operarBinaria()` o si se crea otro método,
4. posiblemente agregar nuevas validaciones si la operación lo requiere.

O sea, **sí toca modificar código existente**. Eso muestra que la clase no está realmente preparada para extenderse sin ser alterada.

No necesariamente “rompe” algo de inmediato, pero sí aumenta el riesgo de:

- equivocarse en el menú,
- duplicar lógica,
- meter más validaciones mezcladas,
- o dañar el flujo principal del programa.

Mientras más operaciones agregues, más grande y más frágil se vuelve esa clase.

---

## 05. ¿Qué pasa si ingreso validaciones de dominio (ej. no dividir por cero, no logaritmos negativos)? ¿Dónde irían en este desastre?

En esta versión, esas validaciones terminan repartidas dentro de los mismos métodos que calculan o ejecutan operaciones.

Por ejemplo:

- la división valida si el divisor es cero dentro de `operarBinaria()`,
- la raíz valida si el número es negativo dentro de `raizCuadrada()`,
- el logaritmo valida si el número es menor o igual a cero dentro de `logaritmoNatural()`.

El problema es que las validaciones quedan **dispersas** y mezcladas con:

- entrada de datos,
- cálculo,
- y salida por consola.

Entonces el código se vuelve más difícil de leer y mantener. Si después cambias una regla de negocio o quieres reutilizar una operación en otro contexto, tengo que ir a buscar la validación perdida dentro de ese mismo “bloque gigante”.

----------------------------------------------------------------------

## En resumen

La clase funciona para un ejercicio pequeño de consola, pero su diseño concentra demasiadas cosas en un solo lugar. Eso hace que cualquier cambio, incluso uno aparentemente simple, termine afectando partes que no deberían depender entre sí.

Entonces:

- no está bien separada por responsabilidades,
- no escala bien,
- no es fácil de extender,
- y cada nueva mejora obliga a seguir metiendo cosas en la misma clase.

Para un programa corto puede pasar, pero si la idea es acercarse a **SoLiD**, esta clase sirve más como ejemplo de lo que **no** conviene dejar crecer demasiado.



## ¿Qué pasa si ingreso validaciones de dominio (ej. no dividir por cero, no logaritmos negativos)? ¿Dónde irían en este desastre?
----------------------------------------
En esa clase actual, esas validaciones terminarían mezcladas dentro de cada método de operación o incluso dentro del switch, o sea, todavía más acoplado.

Por ejemplo:

* División por cero: dentro de la lógica de división.
* Logaritmo de número ≤ 0: dentro del método de logaritmo.
* Raíz de número negativo: dentro del método de raíz.

El problema no es que “no se pueda”, sino que:

La clase ya hace demasiadas cosas
1. muestra menú
2. lee datos
3. decide qué operación ejecutar
4. calcula
5. imprime resultados
6. valida reglas matemáticas
7. Las validaciones quedan regadas
8. Cada operación empieza a meter sus propios if, sus propios mensajes de error y su propio manejo de casos especiales.
9. Cambiar reglas se vuelve incómodo
10. Si mañana decides que los errores no se imprimen sino que se lanzan como excepción, toca tocar varias partes del código.

En ese “desastre”, irían pegadas a cada operación, porque es ahí donde tiene sentido matemático validarlas. Pero desde diseño, eso evidencia que la clase está violando responsabilidad única, porque ya no solo calcula: también controla flujo, interfaz y reglas de dominio.