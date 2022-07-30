package com.sofka.hotel.recepcionista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.recepcionista.values.NombreRecepcionista;

public class RecepcionistaCreated extends DomainEvent {
    private final NombreRecepcionista nombreRecepcionista;

    public RecepcionistaCreated(NombreRecepcionista nombreRecepcionista){
        super("com.sofka.hotel.recepcionista.recepcionistacreated");
        this.nombreRecepcionista = nombreRecepcionista;
    }

    public NombreRecepcionista getNombreRecepcionista() {
        return nombreRecepcionista;
    }
}
