package com.tuempresa.facturacion.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import lombok.*;

/**
 * Calculador automático para números de factura secuenciales por año.
 * Implementa Video 4: Cálculos automáticos avanzados
 * Genera el siguiente número de factura para un año específico.
 */
public class CalculadorSiguienteNumeroParaAnyo
    implements ICalculator { // Un calculador debe implementar ICalculator

    @Getter @Setter
    int anyo; // Este valor se inyectará antes de calcular (desde Factura.anyo)

    /**
     * Calcula el siguiente número de factura para el año especificado.
     * Consulta la BD para encontrar el máximo número existente y suma 1.
     */
    public Object calculate() throws Exception { // Método que realiza el cálculo
        // Consulta JPA para obtener el número máximo de factura del año
        Query query = XPersistence.getManager() // Obtiene el EntityManager de OpenXava
            .createQuery("select max(f.numero) from Factura f where f.anyo = :anyo");

        // Establece el parámetro del año inyectado
        query.setParameter("anyo", anyo);

        // Ejecuta la consulta y obtiene el resultado
        Integer ultimoNumero = (Integer) query.getSingleResult();

        // Devuelve el siguiente número: 1 si no hay facturas, o último + 1
        return ultimoNumero == null ? 1 : ultimoNumero + 1;
    }

}
