package org.bedu.java.backend.Postwork.model;

import lombok.*;
import org.bedu.java.backend.Postwork.validation.GlobalInterface;
import org.bedu.java.backend.Postwork.validation.IdValidator;
import org.bedu.java.backend.Postwork.validation.NameValidator;

import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Pedido {
    @GlobalInterface(validators = {IdValidator.class},
            message = "El identificador del cliente debe ser un número positivo mayor que cero. " +
                    "No se permite utilizar números negativos ni el valor cero como identificador.")
            private Long id;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre del cliente es un campo obligatorio y debe tener al menos 3 letras y como máximo 50 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String cliente;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre del equipo es un campo obligatorio y debe tener al menos 3 letras y como máximo 20 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String equipo;

    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
             private String fecha;

    @GlobalInterface(validators = {IdValidator.class},
            message = "La potencia debe ser un número positivo mayor que cero. " +
                    "No se permite utilizar números negativos ni el valor cero como valor potencia.")
            private int potencia;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre del unidad de medida es un campo obligatorio y debe tener al menos 3 letras y como máximo 5 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String unidadMedida;

    @GlobalInterface(validators = {IdValidator.class},
            message = "Las RPM debe ser un número positivo mayor que cero. " +
                    "No se permite utilizar números negativos ni el valor cero como valor RPM.")
            private int rpm;

    @GlobalInterface(validators = {IdValidator.class},
            message = "La frecuencia debe ser un número positivo mayor que cero. " +
                    "No se permite utilizar números negativos ni el valor cero como valor frecuencia.")
            private int frecuencia;

    @GlobalInterface(validators = {IdValidator.class},
            message = "Los amperes debe ser un número positivo mayor que cero. " +
                    "No se permite utilizar números negativos ni el valor cero como valor potencia.")
            private int amperes;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre del armazon es un campo obligatorio y debe tener al menos 3 letras y como máximo 20 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String armazon;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre de la marca es un campo obligatorio y debe tener al menos 3 letras y como máximo 20 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String marca;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre de la serie es un campo obligatorio y debe tener al menos 3 letras y como máximo 20 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String serie;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre del desensamble es un campo obligatorio y debe tener al menos 3 letras y como máximo 50 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
             private String desensamble;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre del ensamble es un campo obligatorio y debe tener al menos 3 letras y como máximo 50 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String ensamble;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre del embobinado es un campo obligatorio y debe tener al menos 3 letras y como máximo 50 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String embobinado;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre de las pruebas es un campo obligatorio y debe tener al menos 3 letras y como máximo 50 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
             private String pruebas;

            private String notas;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre del estatus es un campo obligatorio y debe tener al menos 3 letras y como máximo 20 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String estatus;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre de la factura es un campo obligatorio y debe tener al menos 3 letras y como máximo 20 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String factura;

}
