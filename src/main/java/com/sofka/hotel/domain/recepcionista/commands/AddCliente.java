package com.sofka.hotel.domain.recepcionista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.recepcionista.values.NombreCliente;
import com.sofka.hotel.domain.recepcionista.values.RecepcionistaID;

public class AddCliente extends Command {
    private final RecepcionistaID recepcionistaID;
    private final NombreCliente nombreCliente;


    public AddCliente(RecepcionistaID recepcionistaID, NombreCliente nombreCliente){
        this.recepcionistaID = recepcionistaID;
        this.nombreCliente = nombreCliente;
    }

    public RecepcionistaID getRecepcionistaID() {
        return recepcionistaID;
    }

    public NombreCliente getNombreCliente() {
        return nombreCliente;
    }
}
