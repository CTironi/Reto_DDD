package com.sofka.hotel.mucama.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.mucama.values.NombreMucama;

public class MucamaCreated extends DomainEvent {
    private final NombreMucama nombreMucama;

    public MucamaCreated(NombreMucama nombreMucama){
        super("com.sofka.hotel.mucama.mucamacreated");
        this.nombreMucama = nombreMucama;
    }

    public NombreMucama getNombreMucama() {
        return nombreMucama;
    }
}
