package com.sofka.hotel.business.useCase.events;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.hotel.domain.usuario.Usuario;
import com.sofka.hotel.domain.usuario.events.ReclamoAdded;
import com.sofka.hotel.domain.usuario.values.UsuarioID;

public class NotificacionReclamoAddedUseCase extends UseCase<TriggeredEvent<ReclamoAdded>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ReclamoAdded> reclamoAddedTriggeredEvent) {
        var event = reclamoAddedTriggeredEvent.getDomainEvent();
        var usuario = Usuario.from(UsuarioID.of(event.aggregateRootId()),retrieveEvents());

        usuario.notificacionReclamoAdded("Reclamo Registrado");

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
