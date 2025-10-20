# Sistema de Facturación con OpenXava y MySQL

## Actividad Autónoma: Laboratorio OpenXava - Videos 4, 5 y MySQL

### Contexto Académico
Esta práctica de laboratorio profundiza en el desarrollo de aplicaciones empresariales con OpenXava, enfocándose en funcionalidades avanzadas y la integración con sistemas de gestión de bases de datos. Esta experiencia práctica es esencial para comprender cómo aplicar estrategias de V&V en aplicaciones que manejan persistencia de datos, identificando puntos críticos de testing en la integración entre capas de aplicación, lógica de negocio y bases de datos relacionales.

### Objetivo
Desarrollar competencias prácticas avanzadas en OpenXava mediante la implementación completa de los videos 4 y 5, más la integración con MySQL, documentando exhaustivamente el proceso y analizando las implicaciones para testing de aplicaciones empresariales con acceso a bases de datos.

## Tabla de Contenidos
- Requisitos
- Instalación y ejecución del Proyecto
- Estructura del Proyecto
- Configuración de Base de Datos
- Funcionalidades Implementadas
- Testing y Verificación
- Créditos
- Recursos de Apoyo

## Requisitos
Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes componentes:
- Java JDK 11 o superior
- Apache Maven 3.6+
- MySQL 8.0+
- OpenXava Studio (opcional para desarrollo)

## Configuración de Base de Datos
1. Ingresa a MySQL Workbench o línea de comandos
2. Crea una base de datos llamada `facturaciondb`:
   ```sql
   CREATE DATABASE facturaciondb;
   ```
3. Verifica la configuración en `src/main/webapp/META-INF/context.xml` (ya configurado para MySQL)

## Instalación y ejecución
1. Clona este repositorio:
   ```bash
   git clone https://github.com/Anahi606/facturacion.git
   ```

2. Accede al directorio del proyecto y ejecuta:
   ```bash
   mvn clean install
   ```

3. Ejecuta la aplicación desde OpenXava Studio o línea de comandos:
   - Desde IDE: Botón derecho en `facturacion.java` > Run As > Java Application
   - Desde línea de comandos: `mvn exec:java -Dexec.mainClass="com.yourcompany.facturacion.run.facturacion"`

4. Accede a la aplicación desde tu navegador en `http://localhost:8080/facturacion`

## Estructura del Proyecto
```
facturacion-main/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── yourcompany/
│   │   │   │   │   └── facturacion/
│   │   │   │   │       ├── modelo/          # Entidades JPA
│   │   │   │   │       │   ├── Factura.java
│   │   │   │   │       │   ├── Cliente.java
│   │   │   │   │       │   ├── Producto.java
│   │   │   │   │       │   ├── Detalle.java
│   │   │   │   │       │   ├── Categoria.java
│   │   │   │   │       │   ├── Autor.java
│   │   │   │   │       │   └── Direccion.java
│   │   │   │   │       └── calculadores/    # Lógica de negocio
│   │   │   │   │           └── CalculadorSiguienteNumeroParaAnyo.java
│   │   │   │   │       └── run/
│   │   │   │   │           └── facturacion.java
│   │   │   ├── com/
│   │   │   │   └── tuempresa/
│   │   │   │       └── facturacion/
│   │   │   │           └── calculadores/
│   │   │   │               └── CalculadorSiguienteNumeroParaAnyo.java
│   │   ├── resources/
│   │   │   ├── META-INF/
│   │   │   │   └── persistence.xml      # Configuración JPA
│   │   │   ├── xava/
│   │   │   │   ├── aplicacion.xml       # Configuración aplicación
│   │   │   │   ├── controladores.xml    # Controladores personalizados
│   │   │   │   ├── editores.xml         # Editores personalizados
│   │   │   │   └── dtds/                # Definiciones XML
│   │   │   ├── xava.properties         # Propiedades OpenXava
│   │   │   ├── naviox.properties       # Propiedades NaviOX
│   │   │   ├── naviox-users.properties # Usuarios
│   │   │   └── i18n/                   # Internacionalización
│   │   └── webapp/
│   │       ├── META-INF/
│   │       │   └── context.xml         # Configuración Tomcat/MySQL
│   │       ├── WEB-INF/
│   │       │   └── web.xml             # Configuración web
│   │       └── xava/
│   │           └── style/
│   │               └── custom.css      # Estilos personalizados
│   └── test/
│       └── resources/
│           └── xava-junit.properties   # Configuración testing
├── data/                               # Base de datos HSQLDB (desarrollo)
├── pom.xml                             # Configuración Maven
└── README.md
```

## Funcionalidades Implementadas

### Video 4: Funcionalidades Avanzadas
- **Entidades Complejas**: Modelos con relaciones JPA complejas
- **Cálculos Automáticos**: Calculador para números de factura por año
- **Vistas Personalizadas**: Configuración de vistas con anotaciones @View
- **Validaciones**: Uso de @Required y otras validaciones
- **Referencias**: Relaciones @ManyToOne y @OneToMany

### Video 5: Integración y Navegación
- **Colecciones Embebidas**: @ElementCollection para detalles de factura
- **Navegación Mejorada**: Configuración de vistas con @ReferenceView
- **Listas Descriptivas**: @DescriptionsList para combos
- **Controladores**: Herencia de controladores Typical

### Integración MySQL
- **Configuración JDBC**: Driver MySQL Connector/J incluido
- **DataSource**: Configurado en context.xml para pooling de conexiones
- **Persistencia JPA**: Hibernate como proveedor JPA
- **Migración Automática**: schema-generation update activado

## Testing y Verificación

### Pruebas Funcionales
1. **CRUD Completo**: Verificar operaciones en todas las entidades
2. **Relaciones**: Comprobar integridad referencial
3. **Cálculos**: Validar generador de números de factura
4. **Interfaz Web**: Verificar UI generada automáticamente

### Pruebas de Integración
1. **Conectividad MySQL**: Verificar conexión a base de datos
2. **Transacciones**: Comprobar atomicidad de operaciones
3. **Performance**: Evaluar tiempos de respuesta

### Herramientas de Testing Recomendadas
- **JUnit**: Para testing unitario de calculadores
- **Selenium**: Para testing automatizado de UI
- **Postman**: Para testing de APIs REST (si se implementan)

## Créditos
- **Framework**: OpenXava 7.6
- **Base de Datos**: MySQL 8.0+
- **ORM**: Hibernate JPA
- **Servidor**: Apache Tomcat (embebido)

## Recursos de Apoyo

### Fuentes Técnicas Principales
- **Documentación OpenXava**: https://www.openxava.org/OpenXavaDoc/docs/index_es.html
- **Documentación MySQL**: https://dev.mysql.com/doc/
- **Tutoriales OpenXava**: Videos 4, 5 y MySQL integration
- **Foro OpenXava**: https://openxava.openxava.org/
- **GitHub OpenXava**: https://github.com/openxava/openxava

### Herramientas de Testing Sugeridas
- **JUnit**: Testing unitario
- **Selenium**: Testing de interfaz web
- **MySQL Test Framework**: Verificación de integridad de datos
- **Postman**: Testing de APIs

## Entregables del Laboratorio

### Estructura del ZIP de Entrega
```
Apellido_Nombre_LabOpenXavaAvanzado/
├── Informe_Tecnico_OpenXava.pdf
├── Evidencias/
│   ├── Video4/
│   │   ├── screenshots/
│   │   └── codigo/
│   ├── Video5/
│   │   ├── screenshots/
│   │   └── codigo/
│   ├── MySQL_Integration/
│   │   ├── screenshots/
│   │   ├── scripts_sql/
│   │   └── configuracion/
│   └── Proyecto_Completo/
├── demo_video.mp4 (opcional)
└── README.txt (instrucciones de ejecución)
```

### Formato de Entrega
- **Informe Técnico**: PDF profesional (4-5 páginas)
- **Evidencias**: Carpeta organizada con screenshots y código
- **Video Demo**: MP4 opcional mostrando funcionamiento
- **Proyecto**: Código fuente completo en GitHub

## Conclusiones

Este proyecto demuestra la implementación completa de una aplicación empresarial usando OpenXava con integración MySQL, cubriendo:

1. **Arquitectura MVC**: Separación clara de responsabilidades
2. **Persistencia JPA**: Mapeo objeto-relacional con Hibernate
3. **Interfaz Automática**: Generación de UI a partir de anotaciones
4. **Integración DB**: Configuración completa con MySQL
5. **Testing**: Estrategias para verificar funcionalidad completa

La implementación sigue las mejores prácticas de desarrollo con OpenXava, proporcionando una base sólida para aplicaciones empresariales que requieren persistencia de datos y interfaces web generadas automáticamente.

---

**Repositorio GitHub**: 
**Versión OpenXava**: 7.6
**Base de Datos**: MySQL 8.0+
**Java**: JDK 11+
