package com.sofka.hotel.usuario.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.usuario.values.Origen;
import com.sofka.hotel.usuario.values.ReclamoID;
import com.sofka.hotel.usuario.values.UsuarioID;

public class UpdateReclamoOrigen extends Command {

    private final UsuarioID usuarioID;

    private final ReclamoID reclamoID;

    private final Origen origen;

    public UpdateReclamoOrigen(UsuarioID usuarioID, ReclamoID reclamoID, Origen origen){
        this.usuarioID = usuarioID;
        this.reclamoID = reclamoID;
        this.origen = origen;
    }

    public UsuarioID getUsuarioID() {
        return usuarioID;
    }

    public ReclamoID getReclamoID() {
        return reclamoID;
    }

    public Origen getOrigen() {
        return origen;
    }
}
