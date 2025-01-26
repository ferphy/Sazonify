# 🍳 Sazonify

**Sazonify** es una aplicación de recetas que te ayuda a explorar, buscar, y descubrir nuevas ideas culinarias. Con funcionalidades como búsquedas por categorías, ordenación por popularidad y resultados personalizados, esta app aprovecha la API de Spoonacular para ofrecer una experiencia culinaria completa.

---

## 🚀 Funcionalidades

### Pantalla Principal:
- **Recetas por Categorías:** Explora recetas de desayunos, almuerzos, postres, y más.
- **Recetas Populares:** Descubre las recetas más populares según los datos de Spoonacular.
- **Recetas Rápidas:** Encuentra recetas que puedes preparar en 15 minutos o menos.
- **Búsqueda por Ingredientes:** Ingresa los ingredientes que tienes en casa y obtén recetas relevantes.

### Pantalla Detalle:
- Detalles completos de la receta, incluidos ingredientes, pasos de preparación, y tiempo total.

---

## 🛠️ Tecnologías Utilizadas

### Frontend:
- **Kotlin:** Lenguaje principal para la app.
- **Jetpack Compose:** Framework moderno de UI declarativa de Android.

### Backend/API:
- **Spoonacular API:** Base de datos de recetas.
  - [Documentación oficial](https://spoonacular.com/food-api).

### Dependencias Clave:
- **Retrofit:** Llamadas a la API.
- **Hilt:** Inyección de dependencias.
- **StateFlow:** Manejo de estados reactivos.

---

## 🏗️ Arquitectura

- **MVVM (Model-View-ViewModel):** Separación clara de la lógica de negocios y la UI.
- **Repository Pattern:** Para manejar las llamadas a la API.
- **StateFlow:** Para manejar estados reactivos y actualizaciones en tiempo real.

---

## 🔧 Configuración

### Paso 1: Clona este Repositorio
```bash
git clone https://github.com/tu-usuario/sazonify.git
```

### Paso 2: Obtén una API Key de Spoonacular
1. Ve a [Spoonacular API](https://spoonacular.com/food-api).
2. Regístrate e inicia sesión.
3. Crea un nuevo proyecto y copia tu API Key.

---
### Paso 3: Configura la API Key
1. Abre el archivo `local.properties` (crea uno si no existe).
2. Agrega tu clave:
   ```properties
   SPOONACULAR_API_KEY=your_api_key_here
### Paso 4: Configura Variables de Entorno (Opcional)
Si prefieres usar variables de entorno, sigue estos pasos:

#### Mac/Linux:
```bash
export SPOONACULAR_API_KEY=your_api_key_here
```
#### Windows:
```cmd
set SPOONACULAR_API_KEY=your_api_key_here
```
### Paso 5: Ejecuta la App
1. Abre el proyecto en Android Studio.
2. Conéctate a un dispositivo o emulador.
3. Presiona **Run**.

---

## 🖼️ Capturas de Pantalla

### Pantalla Principal
![Pantalla Principal](https://via.placeholder.com/600x400?text=Pantalla+Principal)

### Pantalla Detalle
![Pantalla Detalle](https://via.placeholder.com/600x400?text=Pantalla+Detalle)

---

## 🌟 Próximas Funcionalidades
- Guardar recetas como favoritas.
- Modo oscuro.
- Lista de compras generada automáticamente.
- Compatibilidad con múltiples idiomas.

---

## 📜 Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

---

## 🤝 Contribuciones
¡Contribuciones, problemas y solicitudes de características son bienvenidos! Para contribuir:

1. Haz un fork del proyecto.
2. Crea una nueva rama:
   ```bash
   git checkout -b mi-nueva-funcionalidad
   ```

### Realiza los cambios y confirma:
```bash
git commit -m 'Añadir nueva funcionalidad'
```

### Envía los cambios a tu fork:
```bash
git push origin mi-nueva-funcionalidad
```
### Crea un Pull Request

---

## ✨ Créditos
- **API:** [Spoonacular API](https://spoonacular.com/food-api)
- **Desarrollador:** Fernando González.




