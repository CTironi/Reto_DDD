package com.sofka.hotel.domain.usuario.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.hotel.domain.usuario.values.PedidoID;
import com.sofka.hotel.domain.usuario.values.Tipo;

import java.util.Objects;

public class Pedido extends Entity<PedidoID> {

    protected Tipo tipo;

    public Pedido(PedidoID pedidoID, Tipo tipo){
        super(pedidoID);
        this.tipo = tipo;
    }

    public Tipo tipo(){ return tipo; }

    public void updatePedidoTipo(Tipo tipo){
        this.tipo = Objects.requireNonNull(tipo);
    }
}
