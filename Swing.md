# Curso de Java Swing

Este curso está diseñado para enseñar el desarrollo de interfaces gráficas en Java utilizando la biblioteca Swing. Está dirigido a programadores con conocimientos básicos de Java que deseen aprender a crear aplicaciones de escritorio.

---

## Módulo 1: Introducción a Java Swing

### Contenido:

* **¿Qué es Swing?**: Swing es una biblioteca gráfica para Java que permite la creación de interfaces gráficas de usuario (GUI). Es parte de Java Foundation Classes (JFC) y proporciona componentes ricos e independientes de la plataforma.
* **Historia y evolución**: Swing fue introducido como una mejora de AWT, proporcionando más flexibilidad y un mejor control del aspecto visual.
* **Comparación entre AWT, Swing y JavaFX**: Swing mejora a AWT con más componentes y mejor apariencia. JavaFX es más moderno, pero Swing sigue siendo ampliamente usado en aplicaciones legacy.
* **Arquitectura de Swing**: Swing sigue un modelo de arquitectura MVC (Modelo-Vista-Controlador). Los componentes son ligeros y se renderizan completamente en Java.
* **Primer programa con JFrame**: Uso básico de `JFrame` para crear una ventana.

```java
import javax.swing.*;

public class VentanaBasica {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi primera ventana");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

---

## Módulo 2: Componentes Básicos

### Contenido:

* **JLabel**: Muestra texto estático.
* **JButton**: Botones clicables.
* **JTextField**: Entrada de texto en una sola línea.
* **JCheckBox, JRadioButton**: Selección múltiple o única.
* **JComboBox**: Lista desplegable.
* **ActionListener**: Interfaz para manejar eventos de acción.

### Ejemplo de uso:

```java
JButton boton = new JButton("Saludar");
boton.addActionListener(e -> JOptionPane.showMessageDialog(null, "¡Hola Mundo!"));
```

### Actividades:

* Crear un formulario de ingreso que capture nombre y edad.
* Mostrar un mensaje con la información ingresada al presionar un botón.

---

## Módulo 3: Layout Managers

### Contenido:

* **FlowLayout**: Componentes alineados horizontalmente.
* **BorderLayout**: Distribuye en norte, sur, este, oeste y centro.
* **GridLayout**: Rejilla de filas y columnas.
* **JPanel**: Contenedor que puede usar su propio layout.

### Ejemplo:

```java
JPanel panel = new JPanel(new GridLayout(2, 2));
panel.add(new JLabel("Usuario:"));
panel.add(new JTextField(10));
```

### Actividades:

* Crear una calculadora con botones organizados en una cuadrícula.
* Interfaz con un panel superior de búsqueda y panel central de resultados.

---

## Módulo 4: Componentes Avanzados

### Contenido:

* **JList**: Lista de elementos.
* **JTable**: Tabla con filas y columnas.
* **JTree**: Árbol jerárquico.
* **JScrollPane**: Añade barras de desplazamiento.
* **Modelos de datos**: ListModel, TableModel, etc.

### Ejemplo:

```java
String[] items = {"Item 1", "Item 2"};
JList<String> lista = new JList<>(items);
```

### Actividades:

* Mostrar una lista de productos seleccionables.
* Crear una tabla de usuarios con nombre, edad y correo.

---

## Módulo 5: Menús y Barras de Herramientas

### Contenido:

* **JMenuBar, JMenu, JMenuItem**: Menús desplegables.
* **JToolBar**: Barra con botones de acceso rápido.
* **Acciones y atajos**: Accesos con teclas.

### Ejemplo:

```java
JMenu menu = new JMenu("Archivo");
menu.add(new JMenuItem("Salir"));
JMenuBar barra = new JMenuBar();
barra.add(menu);
frame.setJMenuBar(barra);
```

### Actividades:

* Crear un menú con opciones de archivo y edición.
* Añadir una barra con botones para guardar y abrir.

---

## Módulo 6: Diálogos y Ventanas Emergentes

### Contenido:

* **JOptionPane**: Cuadros de diálogo predefinidos.
* **JDialog**: Ventanas personalizadas.
* **Comunicación entre ventanas**: Pasar datos entre frames.

### Ejemplo:

```java
String nombre = JOptionPane.showInputDialog("¿Cuál es tu nombre?");
```

### Actividades:

* Mostrar una confirmación antes de eliminar datos.
* Crear un formulario de configuración en un JDialog.

---

## Módulo 7: Personalización y Look and Feel

### Contenido:

* **UIManager**: Cambiar apariencia de la interfaz.
* **Componentes personalizados**: Subclases de JComponent.
* **Iconos e imágenes**: Uso de `ImageIcon`.

### Ejemplo:

```java
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
```

### Actividades:

* Cambiar a un Look and Feel moderno.
* Personalizar botones con imágenes.

---

## Módulo 8: Proyecto Final

### Objetivo:

Desarrollar una aplicación de escritorio completa utilizando los conocimientos adquiridos.

### Propuesta:

Sistema de gestión de tareas con:

* Ventana principal con menú (Archivo, Tareas)
* Lista de tareas con JList o JTable
* Formularios para añadir/editar tareas
* Almacenamiento en archivo de texto usando `FileWriter` y `BufferedReader`

### Ejemplo de estructura:

* `Main.java`: lanza la aplicación.
* `Tarea.java`: clase modelo.
* `GestorTareas.java`: lógica de negocio.
* `InterfazTareas.java`: interfaz gráfica.

---

## Recursos Adicionales

* Documentación oficial de Java Swing
* Oracle Java Tutorials
* Libros recomendados: "Core Java Volume I", "Swing" de Manning
* Repositorios de ejemplo en GitHub

---

## Requisitos Previos

* Conocimientos básicos de Java
* Uso de IDEs como IntelliJ IDEA o Eclipse

## Herramientas Recomendadas

* JDK 8 o superior
* IDE: IntelliJ IDEA, Eclipse, NetBeans
* Herramientas para diseño visual (opcional): WindowBuilder, NetBeans GUI Builder
