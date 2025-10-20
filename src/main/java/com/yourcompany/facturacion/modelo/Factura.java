package com.yourcompany.facturacion.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.tuempresa.facturacion.calculadores.*;

import lombok.*;

/**
 * Entidad principal del sistema de facturación.
 * Representa una factura con sus detalles, cliente y cálculos automáticos.
 * Implementa Video 4: Funcionalidades avanzadas con cálculos automáticos
 * Implementa Video 5: Colecciones embebidas para detalles de factura
 */
@Entity @Getter @Setter
@View(members= // Vista por defecto para la interfaz web generada automáticamente
"anyo, numero, fecha;" + // Primera fila: año, número y fecha
"cliente;" + // Segunda fila: cliente (referencia)
"detalles;" + // Tercera fila: colección de detalles
"observaciones" // Cuarta fila: observaciones
)
public class Factura {

    // Clave primaria UUID generada automáticamente (Video 4: Entidades complejas)
    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden // No se muestra en la UI
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;

    // Año de la factura con valor por defecto del año actual
    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class) // Calculador automático
    int anyo;

    // Número secuencial por año, calculado automáticamente (Video 4: Cálculos automáticos)
    @Column(length=6)
    @DefaultValueCalculator(value=CalculadorSiguienteNumeroParaAnyo.class,
        properties=@PropertyValue(name="anyo") // Inyección del año para el cálculo
    )
    int numero;

    // Fecha requerida con valor por defecto de fecha actual
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate fecha;

    // Observaciones opcionales con editor de texto grande
    @TextArea
    String observaciones;

    // Relación muchos-a-uno con Cliente (Video 4: Referencias)
    @ManyToOne(fetch=FetchType.LAZY, optional=false) // Carga perezosa, requerida
    @ReferenceView("Simple") // Vista simplificada para mostrar el cliente
    Cliente cliente;

    // Colección embebida de detalles (Video 5: Colecciones embebidas)
    @ElementCollection // No es una entidad separada, se almacena en la tabla de Factura
    @ListProperties("producto.numero, producto.descripcion, cantidad") // Columnas a mostrar
    Collection<Detalle> detalles;

}
