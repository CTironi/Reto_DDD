package com.sofka.hotel.usuario.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.usuario.values.Tipo;
import com.sofka.hotel.usuario.values.UsuarioID;

public class AddPedido extends Command {

    private final UsuarioID usuarioID;

    private final Tipo tipo;

    public AddPedido(UsuarioID usuarioID, Tipo tipo ) {

        this.usuarioID = usuarioID;
        this.tipo = tipo;
    }

    public UsuarioID getUsuarioID() {
        return usuarioID;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
