package com.sofka.hotel.domain.recepcionista.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.hotel.domain.recepcionista.values.ClienteID;
import com.sofka.hotel.domain.recepcionista.values.NombreCliente;

import java.util.Objects;

public class Cliente extends Entity<ClienteID> {
    protected NombreCliente nombreCliente;

    public Cliente(ClienteID clienteID, NombreCliente nombreCliente){
        super(clienteID);
        this.nombreCliente = nombreCliente;

    }

    public NombreCliente nombreCLiente() { return nombreCliente; }
    public void updateClienteNombre(NombreCliente nombreCliente){this.nombreCliente = Objects.requireNonNull(nombreCliente);}
}
