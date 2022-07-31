package com.sofka.hotel.business.useCase.events;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.hotel.domain.usuario.Usuario;
import com.sofka.hotel.domain.usuario.events.UsuarioCreated;
import com.sofka.hotel.domain.usuario.values.UsuarioID;

public class NotificacionUsuarioCreatedUseCase extends UseCase<TriggeredEvent<UsuarioCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<UsuarioCreated> usuarioCreatedTriggeredEvent) {
        var event = usuarioCreatedTriggeredEvent.getDomainEvent();

        var usuario = Usuario.from(UsuarioID.of(event.aggregateRootId()), this.retrieveEvents());

        usuario.notifyUsuarioCreado("Se creo el Usuario");

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
