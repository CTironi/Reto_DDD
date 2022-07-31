package com.sofka.hotel.domain.usuario.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.usuario.values.PedidoID;
import com.sofka.hotel.domain.usuario.values.Tipo;


public class PedidoAdded extends DomainEvent {
    private final PedidoID pedidoID;

    private final Tipo tipo;

    public PedidoAdded(PedidoID pedidoID, Tipo tipo ) {
        super("com.sofka.hotel.domain.usuario.pedidoadded");
        this.pedidoID = pedidoID;
        this.tipo = tipo;
    }

    public PedidoID getPedidoID() {
        return pedidoID;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
