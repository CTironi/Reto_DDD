package com.sofka.hotel.domain.recepcionista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.recepcionista.values.ClienteID;
import com.sofka.hotel.domain.recepcionista.values.NombreCliente;
import com.sofka.hotel.domain.recepcionista.values.RecepcionistaID;

public class UpdateClienteNombre extends Command {

    private final RecepcionistaID recepcionistaID;
    private final ClienteID clienteID;
    private final NombreCliente nombreCliente;

    public UpdateClienteNombre(RecepcionistaID recepcionistaID, ClienteID clienteID, NombreCliente nombreCliente){
        this.recepcionistaID = recepcionistaID;
        this.clienteID = clienteID;
        this.nombreCliente = nombreCliente;
    }

    public RecepcionistaID getRecepcionistaID() {
        return recepcionistaID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }
}
