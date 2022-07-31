package com.sofka.hotel.domain.recepcionista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.recepcionista.values.NombreRecepcionista;

public class RecepcionistaCreated extends DomainEvent {
    private final NombreRecepcionista nombreRecepcionista;

    public RecepcionistaCreated(NombreRecepcionista nombreRecepcionista){
        super("com.sofka.hotel.domain.recepcionista.recepcionistacreated");
        this.nombreRecepcionista = nombreRecepcionista;
    }

    public NombreRecepcionista getNombreRecepcionista() {
        return nombreRecepcionista;
    }
}
