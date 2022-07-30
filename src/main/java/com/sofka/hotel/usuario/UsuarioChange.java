package com.sofka.hotel.usuario;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.hotel.usuario.entities.Pedido;
import com.sofka.hotel.usuario.entities.Reclamo;
import com.sofka.hotel.usuario.events.*;

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
