package com.yourcompany.facturacion.run;

import org.openxava.util.*;

/**
 * Clase principal para ejecutar la aplicación de facturación.
 * Punto de entrada del sistema OpenXava con integración MySQL.
 *
 * Implementa la configuración completa del servidor embebido Tomcat
 * con conexión a base de datos MySQL configurada en context.xml
 */

public class facturacion {

	public static void main(String[] args) throws Exception {
		// DBServer.start("facturacion-db"); // Para HSQLDB embebida (comentado)
		// Para MySQL: descomentar arriba y configurar src/main/webapp/META-INF/context.xml

		AppServer.run("facturacion"); // Inicia servidor Tomcat embebido en contexto /facturacion
	}

}
