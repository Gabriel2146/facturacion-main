# Sistema de Facturación con OpenXava y MySQL

## Actividad Autónoma: Laboratorio OpenXava - Videos 4, 5 y MySQL

### Contexto Académico
Esta práctica de laboratorio profundiza en el desarrollo de aplicaciones empresariales con OpenXava, enfocándose en funcionalidades avanzadas y la integración con sistemas de gestión de bases de datos. Esta experiencia práctica es esencial para comprender cómo aplicar estrategias de V&V en aplicaciones que manejan persistencia de datos, identificando puntos críticos de testing en la integración entre capas de aplicación, lógica de negocio y bases de datos relacionales.

### Objetivo
Desarrollar competencias prácticas avanzadas en OpenXava mediante la implementación completa de los videos 4 y 5, más la integración con MySQL, documentando exhaustivamente el proceso y analizando las implicaciones para testing de aplicaciones empresariales con acceso a bases de datos.

## Tabla de Contenidos
- [Requisitos](#requisitos)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Implementación Videos 4 y 5](#implementación-videos-4-y-5)
- [Integración con MySQL](#integración-con-mysql)
- [Testing y Verificación](#testing-y-verificación)
- [Recursos de Apoyo](#recursos-de-apoyo)
- [Entrega](#entrega)
- [Créditos](#créditos)

## Requisitos
Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes componentes:
- **Java JDK 11 o superior**
- **Apache Maven 3.6+**
- **MySQL 8.0+**
- **OpenXava Studio** (opcional, para desarrollo)

## Instalación y Ejecución

### Preparación del Entorno (20 minutos)
1. **Verificación de configuración previa**: Asegúrate de que los videos 1-3 estén funcionando correctamente
2. **Instalación y configuración de MySQL**:
   - Instala MySQL Server 8.0+
   - Crea la base de datos: `CREATE DATABASE facturaciondb;`
   - Configura usuario root sin contraseña (o ajusta en `context.xml`)

3. **Descarga de recursos adicionales**:
   - Driver JDBC MySQL incluido en `pom.xml`
   - MySQL Workbench para administración

### Ejecución del Proyecto
1. Clona este repositorio:
   ```bash
   git clone https://github.com/Anahi606/facturacion.git
   cd facturacion-main
   ```

2. Ejecuta con Maven:
   ```bash
   mvn clean compile
   mvn exec:java -Dexec.mainClass="com.yourcompany.facturacion.run.facturacion"
   ```

3. Accede a la aplicación en: `http://localhost:8080/facturacion`

## Estructura del Proyecto
```
facturacion-main/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/yourcompany/facturacion/
│   │   │       ├── modelo/           # Entidades JPA
│   │   │       │   ├── Cliente.java
│   │   │       │   ├── Producto.java
│   │   │       │   ├── Factura.java
│   │   │       │   ├── Detalle.java
│   │   │       │   ├── Categoria.java
│   │   │       │   ├── Autor.java
│   │   │       │   └── Direccion.java
│   │   │       ├── calculadores/     # Lógica de negocio
│   │   │       │   └── CalculadorSiguienteNumeroParaAnyo.java
│   │   │       └── run/
│   │   │           └── facturacion.java
│   │   ├── resources/
│   │   │   ├── META-INF/
│   │   │   │   └── persistence.xml   # Config JPA
│   │   │   ├── xava/                 # Config OpenXava
│   │   │   └── i18n/                 # Internacionalización
│   │   └── webapp/
│   │       ├── META-INF/
│   │       │   └── context.xml       # Config DataSource
│   │       └── xava/
│   └── test/
├── pom.xml                           # Dependencias Maven
├── data/                             # BD embebida (HSQLDB)
└── README.md
```

## Implementación Videos 4 y 5

### Video 4: Entidades con Relaciones Avanzadas (35 minutos)
**Análisis del contenido**: El video 4 introduce relaciones complejas entre entidades, carga perezosa y cálculos automáticos.

**Características implementadas**:
- **Relaciones muchos-a-uno**: Producto → Categoria, Producto → Autor
- **Entidades embebidas**: Direccion dentro de Cliente
- **Carga perezosa (Lazy Loading)**: Optimización de consultas
- **Cálculos automáticos**: Numeración secuencial de facturas por año

**Archivos clave**:
- `Cliente.java`: Entidad con dirección embebida
- `Producto.java`: Relaciones con categoria y autor
- `CalculadorSiguienteNumeroParaAnyo.java`: Lógica de numeración automática

### Video 5: Navegación y Vistas Mejoradas (35 minutos)
**Estudio de funcionalidades**: El video 5 mejora la experiencia de usuario con vistas personalizadas y navegación.

**Características implementadas**:
- **Vistas personalizadas**: Vista "Simple" para referencias
- **Listas descriptivas**: Combos desplegables para selección
- **Colecciones embebidas**: Detalles de factura como colección
- **Navegación mejorada**: Enlaces entre módulos

**Archivos clave**:
- `Factura.java`: Vista principal con colección de detalles
- `Cliente.java`: Vista simplificada para referencias

## Integración con MySQL (40 minutos)

### Configuración de Base de Datos
1. **Crear esquema**: Base de datos `facturaciondb` en MySQL
2. **Configurar conexión**: DataSource en `context.xml`
3. **Migración automática**: JPA genera tablas automáticamente

### Configuración Técnica
**persistence.xml**: Unidad de persistencia configurada para MySQL
```xml
<persistence-unit name="default">
    <non-jta-data-source>java://comp/env/jdbc/facturacionDS</non-jta-data-source>
    <properties>
        <property name="javax.persistence.schema-generation.database.action" value="update"/>
    </properties>
</persistence-unit>
```

**context.xml**: DataSource MySQL
```xml
<Resource name="jdbc/facturacionDS" auth="Container" type="javax.sql.DataSource"
    driverClassName="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/facturaciondb?useSSL=false&amp;serverTimezone=UTC"
    username="root" password=""/>
```

### Operaciones CRUD
- **Crear**: Nuevos clientes, productos, facturas
- **Leer**: Listados con filtros y búsqueda
- **Actualizar**: Modificación de entidades existentes
- **Eliminar**: Borrado con integridad referencial

## Testing y Verificación

### Pruebas Funcionales Básicas
- ✅ Creación de clientes con direcciones
- ✅ Gestión de productos con categorías
- ✅ Emisión de facturas con detalles
- ✅ Numeración automática de facturas
- ✅ Navegación entre módulos

### Herramientas de Testing Sugeridas
- **JUnit**: Testing unitario de componentes Java
- **Selenium**: Testing automatizado de interfaz web
- **MySQL Test Framework**: Verificación de integridad de datos
- **Postman**: Testing de APIs REST (si se implementan)

### Estrategias de V&V
- **Testing de integración**: Verificar conexiones BD
- **Testing de UI**: Validar formularios y navegación
- **Testing de datos**: Comprobar integridad referencial
- **Testing de rendimiento**: Consultas optimizadas

## Recursos de Apoyo

### Fuentes Técnicas Principales
- **Documentación OpenXava**: https://www.openxava.org/OpenXavaDoc/docs/index_es.html
- **Videos específicos**: Tutorials 4, 5 y MySQL integration
- **MySQL Official Documentation**: https://dev.mysql.com/doc/
- **OpenXava Forum**: https://sourceforge.net/p/openxava/discussion/
- **GitHub OpenXava**: https://github.com/openxava/openxava

### Documentación Adicional
- JPA/Hibernate Documentation
- Maven Documentation
- Tomcat Configuration Guide

## Entrega

### Formato
- **Informe técnico**: PDF profesional (4-5 páginas)
- **Evidencias**: Carpeta organizada con capturas y código
- **Video demo**: MP4 (opcional)
- **Proyecto**: Código fuente en GitHub

### Estructura del ZIP
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

### Fecha de Entrega
[Especificar según calendario académico]

### Plataforma
Aula virtual de la materia

## Créditos
- **Framework**: OpenXava 7.6
- **Base de Datos**: MySQL 8.0+
- **Build Tool**: Apache Maven
- **Servidor**: Apache Tomcat (embebido)
- **Documentación**: https://www.openxava.org/OpenXavaDoc/docs/index_es.html
- **MySQL Workbench**: https://www.mysql.com/products/workbench/

---

**Proyecto GitHub**: https://github.com/Anahi606/facturacion

**Estado del Proyecto**: ✅ Completo - Videos 4, 5 y MySQL integrados
