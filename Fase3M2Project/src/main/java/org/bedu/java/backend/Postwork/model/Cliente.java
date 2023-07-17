package org.bedu.java.backend.Postwork.model;

import lombok.*;

import org.bedu.java.backend.Postwork.validation.EmailValidator;
import org.bedu.java.backend.Postwork.validation.GlobalInterface;
import org.bedu.java.backend.Postwork.validation.IdValidator;
import org.bedu.java.backend.Postwork.validation.NameValidator;
import org.bedu.java.backend.Postwork.validation.PhoneNumberValidator;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Cliente {
    @GlobalInterface(validators = {IdValidator.class},
            message = "El identificador del cliente debe ser un número positivo mayor que cero. " +
                    "No se permite utilizar números negativos ni el valor cero como identificador.")
        private long id;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre del cliente es un campo obligatorio y debe tener al menos 3 letras y como máximo 50 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
        private String nombre;

    @GlobalInterface(validators = {NameValidator.class},
            message = "El nombre del contacto es un campo obligatorio y debe tener al menos 3 letras y como máximo 50 letras." +
                    " Asegúrate de proporcionar un nombre válido que cumpla con estos requisitos")
        private String contacto;    

    @GlobalInterface(validators = {EmailValidator.class},
            message = "El correo electrónico proporcionado no es válido. " +
                    "Asegúrate de ingresar una dirección de correo electrónico válida siguiendo el formato estándar " +
                    "(por ejemplo, nombre@dominio.com)")
        private String correoContacto;
    
    @GlobalInterface(validators = {PhoneNumberValidator.class},
            message = "El correo electrónico proporcionado no es válido. " +
                    "Asegúrate de ingresar una dirección de correo electrónico válida siguiendo el formato estándar " +
                    "(por ejemplo, nombre@dominio.com)")
        private String telefono;
   
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotBlank(message = "La dirección es obligatoriaes un campo obligatorio " +
            "Asegúrate de proporcionar la dirección correspondiente")
        private String direccion;


}
