package com.sofka.hotel.usuario.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.usuario.values.Origen;
import com.sofka.hotel.usuario.values.ReclamoID;

public class ReclamoOrigenUpdated extends DomainEvent {

    private final ReclamoID reclamoID;

    private final Origen origen;

    public ReclamoOrigenUpdated(ReclamoID reclamoID, Origen origen){
        super("com.sofka.hotel.usuario.reclamoorigenupdated");
        this.reclamoID = reclamoID;
        this.origen = origen;
    }

    public ReclamoID getReclamoID() {
        return reclamoID;
    }

    public Origen getOrigen() {
        return origen;
    }

}
