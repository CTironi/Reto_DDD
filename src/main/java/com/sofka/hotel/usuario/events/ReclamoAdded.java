package com.sofka.hotel.usuario.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.usuario.values.Fecha;
import com.sofka.hotel.usuario.values.Origen;
import com.sofka.hotel.usuario.values.ReclamoID;

public class ReclamoAdded extends DomainEvent {

    private final ReclamoID reclamoID;

    private final Origen origen;

    private final Fecha fecha;

    public ReclamoAdded(ReclamoID reclamoID, Origen origen, Fecha fecha){
        super("com.sofka.hotel.usuario.reclamoadded");
        this.reclamoID = reclamoID;
        this.origen = origen;
        this.fecha = fecha;
    }

    public ReclamoID getReclamoID() {
        return reclamoID;
    }

    public Origen getOrigen() {
        return origen;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
