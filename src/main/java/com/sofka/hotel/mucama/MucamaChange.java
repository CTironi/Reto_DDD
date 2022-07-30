package com.sofka.hotel.mucama;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.hotel.mucama.entities.Carrito;
import com.sofka.hotel.mucama.entities.Tarea;
import com.sofka.hotel.mucama.events.*;


public class MucamaChange extends EventChange {
    MucamaChange(Mucama mucama) {
        apply((MucamaCreated event) -> {
            mucama.nombreMucama = event.getNombreMucama();
        });
        apply((CarritoAdded event) -> {
            mucama.carrito = new Carrito(event.getCarritoID(), event.getObjetos());
        });
        apply((TareaAdded event) -> {
            mucama.tarea = new Tarea(event.getTareaID(), event.getPedidos(), event.getLimpieza(), event.getEquipaje());
        });
        apply((CarritoObjetosUpdated event) -> {
            mucama.carrito.updateCarritoObjetos(event.getObjetos());
        });
        apply((TareaPedidosUpdated event) -> {
            mucama.tarea.updateTareaPedidos(event.getPedidos());
        });
    }
}
