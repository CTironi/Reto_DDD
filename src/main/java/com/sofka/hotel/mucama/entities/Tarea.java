package com.sofka.hotel.mucama.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.hotel.mucama.values.Equipaje;
import com.sofka.hotel.mucama.values.Limpieza;
import com.sofka.hotel.mucama.values.Pedidos;
import com.sofka.hotel.mucama.values.TareaID;


import java.util.Objects;

public class Tarea extends Entity<TareaID> {

    protected Pedidos pedidos;
    protected Limpieza limpieza;
    protected Equipaje equipaje;

    public Tarea(TareaID tareaID, Pedidos pedidos, Limpieza limpieza, Equipaje equipaje){
        super(tareaID);
        this.pedidos = pedidos;
        this.limpieza = limpieza;
        this.equipaje = equipaje;
    }

    public Pedidos pedidos() { return pedidos; }
    public void updateTareaPedidos(Pedidos pedidos){this.pedidos = Objects.requireNonNull(pedidos);}
    public Limpieza limpieza() { return limpieza; }
    public Equipaje equipaje() { return equipaje; }
}
