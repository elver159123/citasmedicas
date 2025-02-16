# Citas Médicas App

## Descripción
Citas Médicas es un prototipo de una aplicación móvil para la gestión de citas médicas. Permite a los usuarios explorar categorías médicas y ver una lista de doctores destacados. 
Tanto doctores como pacientes pueden registrarse, solicitar y gestionar citas médicas. 
La aplicación está desarrollada en **Kotlin** utilizando **Android Jetpack (ViewModel, LiveData)** y **RecyclerView** para mostrar los datos dinámicamente.

## Características
- Lista de categorías médicas.
- Visualización de doctores destacados.
- Registro de doctores y pacientes.
- Solicitud y gestión de citas médicas.
- Navegación entre pantallas.
- Uso de **ViewModel** y **LiveData** para la gestión de datos.
- Interfaz moderna con **RecyclerView** para mostrar información de manera eficiente.
- Uso de **Firebase** como base de datos para almacenar información de los doctores.

## Tecnologías utilizadas
- **Kotlin**
- **Android Jetpack** (ViewModel, LiveData)
- **RecyclerView**
- **ViewBinding**
- **Firebase** (Base de datos en la nube)

## Estructura del Proyecto
```
com.sigfred.citasmedicas
├── Activity
│   ├── MainActivity.kt
│   ├── TopDoctorsActivity.kt
├── Adapter
│   ├── CategoryAdapter.kt
│   ├── TopDoctorAdapter.kt
├── ViewModel
│   ├── MainViewModel.kt
├── binding
│   ├── ActivityMainBinding.kt
├── res
│   ├── layout
│   │   ├── activity_main.xml
│   │   ├── item_category.xml
│   │   ├── item_top_doctor.xml
```

## Instalación y Configuración
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/elver159123/citas-medicas.git
   ```
2. Abrir el proyecto en **Android Studio**.
3. Sincronizar dependencias y ejecutar la aplicación en un emulador o dispositivo físico.
4. Configurar **Firebase** en el proyecto y asegurarse de que las credenciales sean correctas.

## Uso
1. Al abrir la aplicación, se mostrará una lista de categorías médicas y doctores destacados.
2. Se puede navegar entre pantallas y explorar más información sobre los doctores.
3. Los doctores y pacientes pueden registrarse y gestionar sus citas médicas.
4. La aplicación carga los datos mediante **ViewModel** y **LiveData**, actualizando la UI dinámicamente.
5. La información de los doctores se almacena en **Firebase**.

##Imagenes de Funcionamiento

## Capturas de pantalla
![Pantalla de inicio](/imagenes/Image.png)
![Pantalla de interfas](/imagenes/Imagen2.png)
![Pantalla doctor](/imagenes/Imagen3.png)
![Pantalla lista de doctores](/imagenes/Imagen4.png)
![Pantalla compartir ](/imagenes/Imagen5.png)


## Autor
**Andy Yanacallo**


