package com.sofka.hotel.usuario.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.usuario.values.Fecha;
import com.sofka.hotel.usuario.values.Origen;
import com.sofka.hotel.usuario.values.UsuarioID;

public class AddReclamo extends Command {

    private final UsuarioID usuarioID;

    private final Origen origen;

    private final Fecha fecha;

    public AddReclamo(UsuarioID usuarioID, Origen origen, Fecha fecha){
        this.usuarioID = usuarioID;
        this.origen = origen;
        this.fecha = fecha;
    }

    public UsuarioID getUsuarioID() {
        return usuarioID;
    }

    public Origen getOrigen() {
        return origen;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
