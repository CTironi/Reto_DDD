package com.sofka.hotel.mucama.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.mucama.values.*;

public class TareaAdded extends DomainEvent {

    private final TareaID tareaID;
    private final Pedidos pedidos;
    private final Limpieza limpieza;
    private final Equipaje equipaje;


    public TareaAdded(TareaID tareaID, Pedidos pedidos, Limpieza limpieza, Equipaje equipaje){
        super("com.sofka.hotel.mucama.tareaadded");
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
