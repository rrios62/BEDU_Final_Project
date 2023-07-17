package org.bedu.java.backend.Postwork.runners;

import org.bedu.java.backend.Postwork.model.Cliente;
import org.bedu.java.backend.Postwork.persistence.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public abstract class ClienteRunner implements CommandLineRunner {
    private final IClienteRepository clienteRepository;

    @Autowired
    public ClienteRunner(IClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    @Override
    public void run(String... args)throws Exception{
        Cliente cliente1 = creaCliente(1l,"Lukasoft","Aaron Ríos", "aaron@mail.com","1234567890","Cantaros 4505");

    }

    private Cliente creaCliente(Long id,String nombre,String contacto,String correoContacto,String telefono,String direccion){
       Cliente cliente = new Cliente();
       cliente.setId(id);
       cliente.setNombre(nombre);
       cliente.setContacto(contacto);
       cliente.setCorreoContacto(correoContacto);
       cliente.setTelefono(telefono);
       cliente.setDireccion(direccion);
       return cliente;
    }
}
