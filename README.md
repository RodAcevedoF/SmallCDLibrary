# 🎵 Music Store Console App

Bienvenido a **Music Store**, una aplicación Java por consola para gestionar tus CDs y canciones favoritas. Organiza tu biblioteca musical, crea CDs y gestiona sus canciones ¡todo desde tu terminal!

---

## 🛠️ Características

- 📀 Crear y renombrar CDs
- 🎼 Añadir, sobrescribir o eliminar canciones de un CD
- 📚 Gestionar una biblioteca completa de CDs
- 🔍 Ver canciones por índice o listarlas todas
- 📊 Obtener estadísticas básicas (como cantidad de canciones por CD)

---

## 📦 Estructura del Proyecto

```
ra.dev.music_store
├── controller       # Controlador principal (interfaz por consola)
├── model            # Clases CD, Song y la biblioteca CDLibrary
├── service          # Lógica de negocio para CDs, canciones y biblioteca
└── MusicStoreApp    # Punto de entrada principal
```

---

## 🚀 Cómo Ejecutarlo

1. Asegúrate de tener Java 17+ instalado.
2. Clona el repositorio o copia el código.
3. Compila y ejecuta:

```bash
javac ra/dev/music_store/controller/LibraryController.java
java ra.dev.music_store.controller.LibraryController
```

---

## ✨ Vista previa

```
-------------------------------
----- Welcome to Music Store -----
-------------------------------
Choose an option:
1. Create CD Library
2. Add new CD
3. Rename current CD
4. Show all CDs
5. Select CD
6. Add song to current CD
...
```

---

## 🧩 Tecnologías usadas

- Java 17
- Programación orientada a objetos
- Patrón de diseño MVC básico (Model-Service-Controller)

---

## 💡 Próximas mejoras

- Guardado persistente (archivos o base de datos)
- Interfaz gráfica (Swing o JavaFX)
- Soporte para géneros musicales y duración de canciones

---

## 🤝 Autor

Creado con pasión por [TuNombre].  
¡Contribuciones y sugerencias son siempre bienvenidas!

---

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Puedes usarlo libremente con fines educativos o personales.