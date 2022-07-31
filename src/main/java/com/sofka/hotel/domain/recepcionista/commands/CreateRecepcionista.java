package com.sofka.hotel.domain.recepcionista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.recepcionista.values.RecepcionistaID;
import com.sofka.hotel.domain.recepcionista.values.NombreRecepcionista;

public class CreateRecepcionista extends Command {

    private final RecepcionistaID recepcionistaID;
    private final NombreRecepcionista nombreRecepcionista;

    public CreateRecepcionista(RecepcionistaID recepcionistaID, NombreRecepcionista nombreRecepcionista){
        this.recepcionistaID = recepcionistaID;
        this.nombreRecepcionista = nombreRecepcionista;
    }

    public RecepcionistaID getRecepcionistaID() {
        return recepcionistaID;
    }

    public NombreRecepcionista getNombreRecepcionista() {
        return nombreRecepcionista;
    }
}
