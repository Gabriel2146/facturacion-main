package com.yourcompany.facturacion.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;
 
@Entity @Getter @Setter

public class Producto {
	@Id @Column(length=9)
    int numero;
 
    @Column(length=50) @Required
    String descripcion;
    
    @ManyToOne( // La referencia se almacena como una relación en la base de datos
            fetch=FetchType.LAZY, // La referencia se carga bajo demanda
            optional=true) // La referencia puede estar sin valor
        @DescriptionsList // Así la referencia se visualiza usando un combo
        Categoria categoria; // Una referencia Java convencional
    
    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    Autor autor;
}
