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
ISSUER=< Emisor de tokens de seguridad para la autenticación de la aplicación >
PUBLIC_KEY_LOCATION=< Ruta del archivo que contiene la clave pública para verificar la autenticidad de los tokens >
PRIVATE_KEY_LOCATION=< Ruta del archivo que contiene la clave privada para firmar los tokens de seguridad >
```

## Generación de claves JWT

Para asegurar la autenticación y la seguridad de la aplicación TodoMate, se requiere la generación de claves JWT (JSON Web Token). Siga estos pasos para generar las claves necesarias:

1. Cree un directorio llamado `jwt` en la raíz del proyecto (si aún no existe).

```shell script
mkdir jwt
```

2. Genere una clave privada RSA de 2048 bits y guárdela en el directorio jwt/rsaPrivateKey.pem.
```shell script
openssl genrsa -out jwt/rsaPrivateKey.pem 2048
```

3. Extraiga la clave pública correspondiente y guárdela en el archivo jwt/publicKey.pem.
```shell script
openssl rsa -pubout -in jwt/rsaPrivateKey.pem -out jwt/publicKey.pem
```

4. Convierta la clave privada al formato PKCS8 y guárdela en el archivo jwt/privateKey.pem.
```shell script
openssl pkcs8 -topk8 -nocrypt -inform pem -in jwt/rsaPrivateKey.pem -outform pem -out jwt/privateKey.pem
```

5. Asegúrese de que solo el propietario tenga permisos de lectura para las claves.
```shell script
chmod 600 jwt/rsaPrivateKey.pem
chmod 600 jwt/privateKey.pem
```
