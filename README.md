context-alarm
Este repositorio contiene dos proyectos principales: uno web implementado en Angular y otro móvil desarrollado en Android Studio.

Web
Descripción
El proyecto web está implementado en Angular versión 16.2.16. Esta aplicación ofrece diversas páginas y funcionalidades relacionadas con alarmas e informes.

Requisitos previos
Antes de comenzar, asegúrate de tener instalado:

Node.js (versión 14.15.0 o superior).

Angular CLI (versión 16.x): si no lo tienes instalado, puedes hacerlo con el siguiente comando:

bash
Copy code
npm install -g @angular/cli
Instrucciones de instalación
Clona el repositorio en tu máquina local:

bash
Copy code
git clone https://github.com/tuusuario/context-alarm.git
Ve al directorio del proyecto web:

bash
Copy code
cd context-alarm/web
Instala las dependencias del proyecto:

bash
Copy code
npm install
Cómo ejecutar la aplicación
Para ejecutar el servidor de desarrollo, utiliza el siguiente comando:

bash
Copy code
ng serve
La aplicación se ejecutará en http://localhost:4200/. A continuación, puedes acceder a las páginas implementadas en las siguientes rutas:

http://localhost:4200/home - Página principal.
http://localhost:4200/informes - Página de informes.
http://localhost:4200/alarmList - Página de lista de alarmas.
Compilar la aplicación
Para compilar la aplicación para producción, utiliza:

bash
Copy code
ng build
Los archivos compilados estarán en el directorio dist/ listos para ser desplegados.

Mobile
Descripción
El proyecto móvil está implementado en Android Studio. Es una aplicación para manejar alarmas e informes desde dispositivos móviles con Android.

Requisitos previos
Antes de comenzar, asegúrate de tener instalado:

Android Studio (última versión estable).
JDK (Java Development Kit) versión 11 o superior.
Un dispositivo o emulador Android configurado.
Instrucciones de instalación y ejecución
Clona el repositorio en tu máquina local si no lo has hecho ya:

bash
Copy code
git clone https://github.com/tuusuario/context-alarm.git
Abre Android Studio y selecciona "Open an existing project". Navega hasta el directorio del proyecto móvil:

bash
Copy code
cd context-alarm/mobile
Sincroniza el proyecto con los archivos Gradle. Android Studio generalmente lo hace automáticamente al abrir el proyecto, pero si no, puedes sincronizar manualmente seleccionando la opción "Sync Project with Gradle Files" en el menú superior.

Ejecutar la aplicación
Para ejecutar la aplicación en un dispositivo o emulador:

Asegúrate de tener configurado un emulador o conecta un dispositivo Android real en modo desarrollador.
Haz clic en el botón de "Run" en Android Studio o usa el atajo Shift + F10.
Selecciona el dispositivo o emulador en el que deseas ejecutar la aplicación.
La aplicación se instalará y ejecutará en el dispositivo/emulador seleccionado.
Recomendaciones y Buenas Prácticas
Configuración de Emulador: Si no tienes un dispositivo físico disponible, asegúrate de tener un emulador Android configurado correctamente. Para un rendimiento óptimo, habilita hardware acceleration (HAXM) si tu sistema lo permite.
Depuración en Dispositivo Real: Para una experiencia más cercana al usuario final, es recomendable probar la aplicación en un dispositivo Android real. Habilita el modo de desarrollador y la depuración USB en tu dispositivo para conectarlo a Android Studio.
Monitoreo de Logs: Utiliza la herramienta Logcat en Android Studio para monitorear los logs de la aplicación y detectar posibles errores durante la ejecución.
Configuración de Versiones y SDK: Asegúrate de que tu proyecto esté configurado con la versión correcta del SDK y que tus dependencias estén actualizadas para evitar problemas de compatibilidad.
