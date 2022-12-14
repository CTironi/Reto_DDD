package com.sofka.hotel.domain.usuario;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.usuario.events.*;
import com.sofka.hotel.domain.usuario.entities.Pedido;
import com.sofka.hotel.domain.usuario.entities.Reclamo;
import com.sofka.hotel.domain.usuario.values.*;


import java.util.List;
import java.util.Objects;

public class Usuario extends AggregateEvent<UsuarioID> {

    protected Pedido pedido;
    protected Reclamo reclamo;
    protected Nombre nombre;

    public Usuario(UsuarioID usuarioID, Nombre nombre) {
        super(usuarioID);
        appendChange(new UsuarioCreated(usuarioID, nombre)).apply();
    }
    private Usuario(UsuarioID usuarioID) {
        super(usuarioID);
        subscribe(new UsuarioChange(this));
    }
    public static Usuario from(UsuarioID usuarioID, List<DomainEvent> domainEvents) {
        Usuario usuario = new Usuario(usuarioID);
        domainEvents.forEach(usuario::applyEvent);
        return usuario;
    }

    //eventos

    public void addPedido( Tipo tipo ){
        PedidoID pedidoID = new PedidoID();
        appendChange(new PedidoAdded(pedidoID,tipo)).apply();
    }

    public void addReclamo(Origen origen, Fecha fecha ){
        ReclamoID reclamoID = new ReclamoID();
        appendChange(new ReclamoAdded(reclamoID, origen, fecha)).apply();
    }
    public void updateReclamoOrigen(ReclamoID reclamoID, Origen origen){
        appendChange(new ReclamoOrigenUpdated(reclamoID, origen)).apply();
    }
    public void updatePedidoTipo(PedidoID pedidoID, Tipo tipo){
        appendChange(new PedidoTipoUpdated(pedidoID, tipo)).apply();
    }
    public void notifyUsuarioCreado(String notification){
        Objects.requireNonNull(notification);
        appendChange(new UsuarioNotificacion(notification)).apply();
    }
    public void notificacionReclamoAdded(String message){
        Objects.requireNonNull(message);
        appendChange(new ReclamoAddedNotificacion(message)).apply();
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Reclamo getReclamo() {
        return reclamo;
    }
}
