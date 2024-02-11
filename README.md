# pp-todomate-api

Este proyecto, creado por **mrodriguezdev**, constituye el backend de el proyecto TodoMate. Para obtener más información sobre Quarkus, visita [quarkus.io](https://quarkus.io/)

> [!NOTE]
> **PP:** Este proyecto es personal y ha sido creado con propósitos personales. La abreviatura "PP" se refiere a "Proyecto Personal".

## Descripción del proyecto
TodoMateAPI es la columna vertebral robusta que respalda la aplicación TodoMateApp, un proyecto personal destinado a simplificar la gestión de tareas diarias. Esta API proporciona una infraestructura backend eficiente y segura, permitiendo a los usuarios de TodoMateApp crear, organizar y dar seguimiento a sus tareas pendientes de manera intuitiva.

## Documentación OpenAPI

La documentación OpenAPI proporciona una especificación detallada de la API del proyecto.

```shell script
url=PATH/documentacion
```

## Variables de Entorno

Para ejecutar y configurar este proyecto, se deben definir las siguientes variables de entorno:

```shell script
DB_TYPE=< Tipo de base de datos (ejemplo: mysql, postgresql, h2, mongodb) >
DB_USER=< Nombre de usuario para acceder a la base de datos >
DB_PASSWORD=< Contraseña asociada al usuario de la base de datos >
DB_HOST=< Dirección del servidor de la base de datos >
DB_PORT=< Número de puerto en el que el servidor de la base de datos está escuchando >
DB_NAME=< Nombre de la base de datos que la aplicación utilizará >
```