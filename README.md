# Spring One to Many

## Paso 0
  Crea la base de datos chochos si no la tienes previamente creada

  ```psql -U postgres```
```sql
CREATE USER chochos WITH PASSWORD ‘chochos’;
CREATE DATABASE chochos OWNER chochos;
```

## Paso1
Revisa el commit: 5a0f4fd36f8133f8c9cb3e790ff9a2b1ba6502d4
Encontrarás lo siguiente
* Veras que se modificó el Modelo producto
* Se cambió de lugar el controlador a una carpeta llamada controllers
* Encontraras una nueva entidad con sus respectivos Modelo, repositorio y controlador

Busca en el código de los modelos la siguientes anotaciones:

``` java
@JsonBackReference
@ManyToOne(fetch=FetchType.LAZY)
```
```java
@JsonManagedReference
@OneToMany(mappedBy = "producto",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
```

Responde la siguiente pregunta en un archivo llamado entregable en la raíz del repositorio (crea el archivo)
¿En la base de datos creada por JPA qué entidad tendrá la llave foranea?
¿Cuál es la diferencia en tre una Lista y un Set?
Revisa los Ids de las entidades ¿Por qué son de tipo String y qué te imaginas que van a guardar esos valores?

## Paso2

Corre Spring y prueba los enpoints de agregar un producto y agregar un comentario

> [!NOTE]  
> Puedes usar postman si te sientes más cómodo
> Si tienes error por la base de datos prueba borrando las tablas previamente creadas
> Un endpoint es la URL a mandar a llamar, puedes verlos en los controladores como ```  @PostMapping("comentario/{productId}"`

```bash
curl --location 'localhost:8080/productos' \
--header 'Content-Type: application/json' \
--data '{ "nombre":"Proteina Fresa 2.2 kg",
 "descripcion":"Proteina de suero de leche en polvo sabor nieve de fresas con crema 35g/scope", 
 "lote":"12345", 
 "precioUnitario":500.5,
 "fechaCaducidad":"2026-05-04"}'
```

> [!CAUTION]
> Para el url del comentario usa el id que te genera la respuesta del proceso anterior

```bash
curl --location 'localhost:8080/comentario/{idProducto}' \
--header 'Content-Type: application/json' \
--data '{
"username":"usuario1",
"comentario_corto":"corto",
"estrellas":4,
"comentario_largo":"largo", 
"imagen1":"http://urlimagen1.jpeg",
"imagen2":"http://urlimagen2.jpeg"
}'
```
## Paso3
Lista todos los productos
>Deberás ver el p´roducto con un arreglo con el comentario agregado


## Paso4
Revis ala base datos y ve las tablas creadas
Compara las respuestas de tu archivo entregable con los resultados de estas pruebas, si es necesario corrije tus respuestas.


