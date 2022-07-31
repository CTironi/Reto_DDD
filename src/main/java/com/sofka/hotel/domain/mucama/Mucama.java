package com.sofka.hotel.domain.mucama;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.mucama.entities.Carrito;
import com.sofka.hotel.domain.mucama.entities.Tarea;
import com.sofka.hotel.domain.mucama.events.*;
import com.sofka.hotel.domain.mucama.values.*;


import java.util.List;

public class Mucama extends AggregateEvent<MucamaID> {

    protected NombreMucama nombreMucama;
    protected Tarea tarea;
    protected Carrito carrito;
    protected Piso piso;

    public Mucama(MucamaID mucamaID, NombreMucama nombreMucama, Piso piso) {
        super(mucamaID);
        appendChange(new MucamaCreated(nombreMucama)).apply();
    }
    private Mucama(MucamaID mucamaID) {
        super(mucamaID);
        subscribe(new MucamaChange(this));
    }
    public static Mucama from(MucamaID mucamaID, List<DomainEvent> domainEvents) {
        Mucama mucama = new Mucama(mucamaID);
        domainEvents.forEach(mucama::applyEvent);
        return mucama;
    }

    ///events

    public void addCarrito(Objetos objetos){
        CarritoID carritoID = new CarritoID();
        appendChange(new CarritoAdded(carritoID, objetos)).apply();
    }
    public void addTarea(Pedidos pedidos, Limpieza limpieza, Equipaje equipaje){
        TareaID tareaID = new TareaID();
        appendChange(new TareaAdded(tareaID, pedidos,limpieza,equipaje)).apply();
    }
    public void updateCarritoObjetos(CarritoID carritoID, Objetos objetos){
        appendChange(new CarritoObjetosUpdated(carritoID, objetos)).apply();
    }
    public void updateTareaPedidos(TareaID tareaID, Pedidos pedidos){
        appendChange(new TareaPedidosUpdated(tareaID, pedidos)).apply();
    }

    public NombreMucama getNombreMucama() {
        return nombreMucama;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public Piso getPiso() {
        return piso;
    }
}
