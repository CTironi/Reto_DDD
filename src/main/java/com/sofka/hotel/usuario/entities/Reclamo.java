package com.sofka.hotel.usuario.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.hotel.usuario.values.Fecha;
import com.sofka.hotel.usuario.values.Origen;
import com.sofka.hotel.usuario.values.ReclamoID;
import com.sofka.hotel.usuario.values.Tipo;

import java.util.Objects;


public class Reclamo extends Entity<ReclamoID> {

    protected Origen origen;

    protected Fecha fecha;

    public Reclamo(ReclamoID reclamoID, Origen origen, Fecha fecha){
        super(reclamoID);
        this.origen = origen;
        this.fecha = fecha;
    }

    public Origen origen() { return origen; }
    public void updateReclamoOrigen(Origen origen){
        this.origen = Objects.requireNonNull(origen);
    }
    public Fecha fecha() { return fecha; }
}
