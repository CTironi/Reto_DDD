package com.sofka.hotel.recepcionista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.recepcionista.values.ClienteID;
import com.sofka.hotel.recepcionista.values.NombreCliente;

public class ClienteNombreUpdated extends DomainEvent {

    private final ClienteID clienteID;
    private final NombreCliente nombreCliente;

    public ClienteNombreUpdated(ClienteID clienteID, NombreCliente nombreCliente) {
        super("com.sofka.hotel.recepcionista.clientenombreupdated");
        this.clienteID = clienteID;
        this.nombreCliente = nombreCliente;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }
}
