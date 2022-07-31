package com.sofka.hotel.domain.mucama.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.mucama.values.Equipaje;
import com.sofka.hotel.domain.mucama.values.Limpieza;
import com.sofka.hotel.domain.mucama.values.MucamaID;
import com.sofka.hotel.domain.mucama.values.Pedidos;

public class AddTarea extends Command {
    private final MucamaID mucamaID;
    private final Pedidos pedidos;
    private final Limpieza limpieza;
    private final Equipaje equipaje;

    public AddTarea(MucamaID mucamaID, Pedidos pedidos, Limpieza limpieza, Equipaje equipaje){
        this.pedidos = pedidos;
        this.limpieza = limpieza;
        this.mucamaID = mucamaID;
        this.equipaje = equipaje;
    }

    public MucamaID getMucamaID() {
        return mucamaID;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public Limpieza getLimpieza() {
        return limpieza;
    }

    public Equipaje getEquipaje() {
        return equipaje;
    }
}
