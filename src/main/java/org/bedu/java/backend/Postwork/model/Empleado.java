package org.bedu.java.backend.Postwork.model;

import lombok.*;
import org.bedu.java.backend.Postwork.validation.GlobalInterface;
import org.bedu.java.backend.Postwork.validation.IdValidator;
import org.bedu.java.backend.Postwork.validation.NameValidator;
import org.bedu.java.backend.Postwork.validation.PhoneNumberValidator;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Empleado {
    @GlobalInterface(validators = {IdValidator.class},
            message = "El identificador del empleado debe ser un número positivo mayor que cero. " +
                    "No se permite utilizar números negativos ni el valor cero como identificador.")
            private long idEmpleado;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre del empleado es un campo obligatorio y debe tener al menos 3 letras y como máximo 50 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String nombreEmpleado;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El cargo del empleado es un campo obligatorio y debe tener al menos 3 letras y como máximo 50 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
            private String cargo;

    @GlobalInterface(validators = {PhoneNumberValidator.class},
            message = "El teléfono proporcionado no es válido. " +
                    "Asegúrate de ingresar un teléfono válido siguiendo el formato estándar " +
                    "(por ejemplo, 1234567890)")
            private String telefono;


    private String actividad;

    @GlobalInterface(validators = {IdValidator.class},
            message = "El numero del empleado debe ser un número positivo mayor que cero. " +
                    "No se permite utilizar números negativos ni el valor cero como identificador.")
            private int numeroEmpleado;

}
