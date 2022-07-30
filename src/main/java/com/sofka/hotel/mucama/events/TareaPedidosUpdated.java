package com.sofka.hotel.mucama.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.mucama.values.Pedidos;
import com.sofka.hotel.mucama.values.TareaID;

public class TareaPedidosUpdated extends DomainEvent {

    private final TareaID tareaID;
    private final Pedidos pedidos;

    public TareaPedidosUpdated(TareaID tareaID, Pedidos pedidos) {
        super("com.sofka.hotel.mucama.tareapedidosupdated");
        this.tareaID = tareaID;
        this.pedidos = pedidos;
    }

    public TareaID getTareaID() {
        return tareaID;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }
}
