package com.yourcompany.facturacion.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

/**
 * Entidad Producto del sistema de facturación.
 * Representa un producto con su información básica y relaciones con categoría y autor.
 * Implementa Video 4: Relaciones muchos-a-uno con carga perezosa
 * Implementa Video 5: Listas descriptivas para combos en UI
 */
@Entity @Getter @Setter

public class Producto {
	// Clave primaria: número único del producto
	@Id @Column(length=9)
    int numero;

    // Descripción del producto, campo requerido
    @Column(length=50) @Required
    String descripcion;

    // Relación muchos-a-uno con Categoria (Video 4: Referencias)
    @ManyToOne( // La referencia se almacena como una relación en la BD
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda (optimización)
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // La referencia se visualiza usando un combo desplegable
        Categoria categoria; // Una referencia Java convencional

    // Relación muchos-a-uno con Autor (Video 4: Referencias)
    @ManyToOne(fetch=FetchType.LAZY) // Carga perezosa por defecto
    @DescriptionsList // Combo desplegable para selección
    Autor autor;
}
