package com.sofka.hotel.usuario.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.usuario.values.PedidoID;
import com.sofka.hotel.usuario.values.Tipo;
import com.sofka.hotel.usuario.values.UsuarioID;

public class UpdatePedidoTipo extends Command {

    private final UsuarioID usuarioID;

    private final PedidoID pedidoID;

    private final Tipo tipo;

    public UpdatePedidoTipo(UsuarioID usuarioID, PedidoID pedidoID, Tipo tipo){
        this.usuarioID = usuarioID;
        this.pedidoID = pedidoID;
        this.tipo = tipo;
    }

    public UsuarioID getUsuarioID() {
        return usuarioID;
    }

    public PedidoID getPedidoID() {
        return pedidoID;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
