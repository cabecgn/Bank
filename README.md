# Bank Demo

Es un proyecto demo con los siguiente requerimientos:

generar los siguientes 3 endpoints:
- Uno que traiga las empresas que hicieron transferencias el último mes
- Otro que traiga las empresas que se adhirieron el último mes.
- El último que haga la adhesión de una empresa.
- Usando arquitectura hexagonal
- Base de datos relacional mysql (*)
- Datos de la empresa: CUIT, Razón Social, Fecha Adhesión
- Datos de la transferencia: Importe, Id Empresa, Cuenta Débito, Cuenta Crédito

(*)Se provee un Dockerfile con mysql para poder utilizar la app

# TODO:
- Seguridad- Más test unitarios
- Documentación (Swagger)

# Uso:
- Clonar repositorio: git@github.com:cabecgn/Bank.git
- Compilar proyecto: mvn package
- Ejecutar docker de mysql: docker-composite up -d
- Ejecutar app: java -jar target/Bank-0.0.1-SNAPSHOT.jar
- Abrir con Postman el archivo Bank.postman_collection.json que contiene los request de los endpoint
