package com.yourcompany.facturacion.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

/**
 * Entidad Cliente del sistema de facturación.
 * Representa a un cliente con su información básica y dirección.
 * Implementa Video 4: Entidades con relaciones embebidas (Direccion)
 */
@Entity  // Marca la clase como entidad JPA para persistencia en BD
@Getter @Setter // Genera automáticamente getters y setters con Lombok

@View(name="Simple", // Vista simplificada para referencias (Video 5: Navegación mejorada)
members="numero, nombre") // Solo muestra número y nombre en referencias

public class Cliente {

	// Clave primaria: número único del cliente (Video 4: Entidades complejas)
	@Id  // La propiedad numero es la clave. Las claves son obligatorias por defecto
    @Column(length=6)  // Longitud usada tanto en UI como en BD
    int numero;

    // Nombre del cliente, campo requerido con validación automática
    @Column(length=50) // Longitud máxima de 50 caracteres
    @Required  // Validación: mostrará error si se deja en blanco
    String nombre;

    // Dirección embebida: se almacena en la misma tabla que Cliente (Video 4: Relaciones)
    @Embedded // Referencia a clase embebida (no entidad separada)
    Direccion direccion; // Una referencia Java convencional
}
