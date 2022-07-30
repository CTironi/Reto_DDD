package com.sofka.hotel.mucama.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.mucama.values.*;

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
