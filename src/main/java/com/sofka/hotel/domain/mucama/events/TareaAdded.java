package com.sofka.hotel.domain.mucama.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.mucama.values.Equipaje;
import com.sofka.hotel.domain.mucama.values.Limpieza;
import com.sofka.hotel.domain.mucama.values.Pedidos;
import com.sofka.hotel.domain.mucama.values.TareaID;

public class TareaAdded extends DomainEvent {

    private final TareaID tareaID;
    private final Pedidos pedidos;
    private final Limpieza limpieza;
    private final Equipaje equipaje;


    public TareaAdded(TareaID tareaID, Pedidos pedidos, Limpieza limpieza, Equipaje equipaje){
        super("com.sofka.hotel.domain.mucama.tareaadded");
        this.tareaID = tareaID;
        this.pedidos = pedidos;
        this.limpieza = limpieza;
        this.equipaje = equipaje;
    }

    public TareaID getTareaID() {
        return tareaID;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public Limpieza getLimpieza() {
        return limpieza;
    }

    public Equipaje getEquipaje() {
        return equipaje;
    }
}
