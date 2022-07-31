package com.sofka.hotel.domain.mucama.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.mucama.values.MucamaID;
import com.sofka.hotel.domain.mucama.values.Pedidos;
import com.sofka.hotel.domain.mucama.values.TareaID;

public class UpdateTareaPedidos extends Command {
    private final MucamaID mucamaID;
    private final TareaID tareaID;
    private final Pedidos pedidos;

    public UpdateTareaPedidos(MucamaID mucamaID, TareaID tareaID, Pedidos pedidos){
        this.mucamaID = mucamaID;
        this.tareaID = tareaID;
        this.pedidos = pedidos;
    }

    public MucamaID getMucamaID() {
        return mucamaID;
    }

    public TareaID getTareaID() {
        return tareaID;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }
}
