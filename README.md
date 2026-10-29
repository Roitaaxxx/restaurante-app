# Sistema de Gestión para Restaurante de Comidas Rápidas

**Repositorio del proyecto:** “Sistema de Gestión para Restaurante de Comidas Rápidas”

Este proyecto fue desarrollado en Java aplicando los principios fundamentales de la Programación Orientada a Objetos (POO). Permite automatizar la administración del menú, la toma de pedidos (en mesa y a domicilio), el cálculo de impuestos/propinas, la gestión de descuentos configurables y el control de facturación del establecimiento.

---

## Descripción del Proyecto

El sistema fue diseñado para solucionar problemas de establecimientos de comidas rápidas, el cual permite gestionar:

1. **Menú de Productos:** Administración y disponibilidad en tiempo real.
2. **Pedidos en Mesa:** Seguimiento dinámico por estado de mesa y facturación flexible con propinas personalizadas.
3. **Pedidos a Domicilio:** Registro de clientes, cálculo del costo según la zona de entrega y desglose independiente en la factura.
4. **Descuentos Configurables:** Promociones automáticas por día de la semana sin necesidad de recompilar o modificar el código fuente.

---

## Características Principales

* **Gestión del menú:** Categorización de productos (hamburguesas, perros calientes, bebidas, combos, etc.), edición de información y control del estado de disponibilidad.
* **Control de Mesas y Estados:** Monitoreo visual y en tiempo real de los estados de cada mesa (Libre, Ocupada, En Facturación).
* **Módulo de Pedidos Dinámicos:** Adición progresiva de ítems a un pedido activo.
* **Sistema de Facturación:**
  * Cálculo de subtotales e impuestos aplicables.
  * Opciones flexibles de propina (porcentaje sugerido como 10%, valor fijo o sin propina).
  * Recargo dinámico por zona de cobertura en domicilios.
* **Descuentos Dinámicos por Día:** Configuración de promociones especiales.
* **Persistencia de Datos:** Almacenamiento seguro mediante archivos para guardar clientes, ventas e historial.
* **Interfaz Gráfica de Usuario (GUI):** Entorno amigable desarrollado con Java Swing/JavaFX.

---

## Conceptos de POO Aplicados

* **Encapsulamiento:** Ocultamiento de datos mediante atributos privados con métodos getters y setters, manteniendo la integridad del sistema.
* **Herencia y Clases Abstractas:** Estructuración de clases base como `Pedido` (con enfoque en `PedidoMesa` y `PedidoDomicilio`).
* **Polimorfismo e Interfaces:** Manejo genérico de cálculo de totales, descuentos y estrategias de pago.
* **Relaciones entre Clases:** Asociación, agregación y composición claras.
* **Persistencia con Archivos:** Manejo de excepciones y lectura/escritura de archivos en disco para conservación de información.

---

## Tecnologías Utilizadas

* **Lenguaje:** Java
* **GUI:** JavaFX y CSS
* **Persistencia:** Archivos de Texto
* **IDE:** NetBeans

---

## Equipo de Desarrollo

Este proyecto fue desarrollado por estudiantes de Ingeniería de Sistemas que cursan actualmente Programación Orientada a Objetos en la Universidad de Cartagena:

* **Andrea Carolina Roa Buelvas** - `0222520025`
* **Nellys Johana Guerrero López** - `0222520025`
* **Mariana Beltrán Tirado** - `0222320018`