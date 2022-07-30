package com.sofka.hotel.usuario.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.usuario.values.PedidoID;
import com.sofka.hotel.usuario.values.Tipo;

public class PedidoTipoUpdated extends DomainEvent {

    private final PedidoID pedidoID;

    private final Tipo tipo;

    public PedidoTipoUpdated(PedidoID pedidoID, Tipo tipo){
        super("com.sofka.hotel.usuario.pedidotipoupdated");
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
