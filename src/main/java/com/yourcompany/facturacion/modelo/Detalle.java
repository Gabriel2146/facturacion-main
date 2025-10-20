package com.yourcompany.facturacion.modelo;

import javax.persistence.*;

import lombok.*;

/**
 * Clase embebida Detalle para líneas de factura.
 * Representa cada producto en una factura con su cantidad.
 * Implementa Video 5: Colecciones embebidas en Factura
 */
@Embeddable @Getter @Setter // Clase embebida, no entidad independiente
public class Detalle {

    // Cantidad del producto en la factura
    int cantidad;

    // Relación con Producto (carga perezosa, opcional)
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    Producto producto;

}
