package com.sofka.hotel.domain.usuario;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.hotel.domain.usuario.events.*;
import com.sofka.hotel.domain.usuario.entities.Pedido;
import com.sofka.hotel.domain.usuario.entities.Reclamo;


public class UsuarioChange extends EventChange {
    UsuarioChange(Usuario usuario){
        apply((UsuarioCreated event) ->{
            usuario.nombre = event.getNombre();

        });
        apply((PedidoAdded event) -> {
            usuario.pedido = new Pedido(event.getPedidoID(), event.getTipo());
        });
        apply((PedidoTipoUpdated event) -> {
            usuario.pedido.updatePedidoTipo(event.getTipo());
        });
        apply((ReclamoAdded event) -> {
            usuario.reclamo = new Reclamo(event.getReclamoID(), event.getOrigen(), event.getFecha());
        });
        apply((ReclamoOrigenUpdated event) -> {
            usuario.reclamo.updateReclamoOrigen(event.getOrigen());
        });
    }
}
