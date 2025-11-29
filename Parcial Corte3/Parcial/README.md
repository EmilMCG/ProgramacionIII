# Spring Boot Web Project (skeleton)

Esta es una plantilla mínima de **Spring Boot** para entregar el ejercicio solicitado:
- Rutas: `/` y `/pruebas`
- Plantillas Thymeleaf (`index.html`, `pruebas.html`)
- Ejemplos de persistencia:
  - **MongoDB** (Spring Data MongoDB) — perfil `mongo`
  - **Supabase** (Postgres via JDBC) — perfil `supabase`
  - **Firebase** (Firebase Admin SDK) — perfil `firebase`

## Cómo usar

### 1. Construir
Necesitas tener Maven instalado.
```bash
mvn clean package -DskipTests
```

El jar resultante estará en `target/springboot-web-0.0.1-SNAPSHOT.jar`.

### 2. Ejecutar localmente

#### MongoDB (perfil `mongo`)
Asegúrate de tener MongoDB en `mongodb://localhost:27017/springbootdb` o editar `application-mongo.properties`.
```bash
java -jar -Dspring.profiles.active=mongo target/springboot-web-0.0.1-SNAPSHOT.jar
```

#### Supabase / Postgres (perfil `supabase`)
Configura la URL JDBC, usuario y contraseña en `src/main/resources/application-supabase.properties` o mediante variables de entorno.
```bash
java -jar -Dspring.profiles.active=supabase target/springboot-web-0.0.1-SNAPSHOT.jar
```
Crea una tabla `items` en la base de datos:
```sql
CREATE TABLE items (
  id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
  name text,
  description text
);
```

#### Firebase (perfil `firebase`)
Proporciona el path al service account JSON como propiedad de sistema:
```bash
java -Dfirebase.service.account=/path/to/serviceAccount.json -Dspring.profiles.active=firebase -jar target/springboot-web-0.0.1-SNAPSHOT.jar
```
> Nota: el servicio Firebase en este esqueleto solo inicializa el SDK; llama a la API de Firebase desde código adicional si la necesitas.

## Deploy / Hosting (sugerencia)
Puedes desplegar en proveedores que soporten aplicaciones Java:
- **Render.com** (soporta Docker y servicios web)
- **Railway.app**
- **Heroku** (si sigue disponible; hoy en día cambia sus políticas)
- **DigitalOcean App Platform**

Sugerencia rápida con Render (usando Dockerfile): crea un servicio web, conecta el repo y define el puerto `8080`. Añade las variables de entorno necesarias (por ejemplo para Supabase o Firebase service account como secreto).

## Notas finales
- Este proyecto es una **plantilla**: ajusta la configuración (URLs, credenciales, service account) y añade validaciones/seguridad según tu requerimiento.
- Si quieres, puedo:
  - Añadir endpoints REST para CRUD completo.
  - Conectar a tu instancia real de Supabase, MongoDB o Firebase (si me das datos de conexión).
  - Empaquetarlo/crear un repo Git y desplegarlo a Render — puedo dejar instrucciones automáticas para hacerlo.

