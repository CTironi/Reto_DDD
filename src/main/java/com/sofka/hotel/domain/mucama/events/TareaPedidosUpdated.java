package com.sofka.hotel.domain.mucama.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.mucama.values.Pedidos;
import com.sofka.hotel.domain.mucama.values.TareaID;

public class TareaPedidosUpdated extends DomainEvent {

    private final TareaID tareaID;
    private final Pedidos pedidos;

    public TareaPedidosUpdated(TareaID tareaID, Pedidos pedidos) {
        super("com.sofka.hotel.domain.mucama.tareapedidosupdated");
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
