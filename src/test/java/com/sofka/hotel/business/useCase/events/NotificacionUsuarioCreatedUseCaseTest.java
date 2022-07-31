package com.sofka.hotel.business.useCase.events;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.hotel.domain.usuario.events.UsuarioCreated;
import com.sofka.hotel.domain.usuario.events.UsuarioNotificacion;
import com.sofka.hotel.domain.usuario.values.Nombre;
import com.sofka.hotel.domain.usuario.values.UsuarioID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NotificacionUsuarioCreatedUseCaseTest {
    @InjectMocks
    private NotificacionUsuarioCreatedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void EnviarNotificacion(){

        var event = new UsuarioCreated(
                new UsuarioID("1"),
                new Nombre("Cristian"));

        event.setAggregateRootId("xxxxx");

        when(repository.getEventsBy("xxxxx")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("xxxxx")
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var notificacion = (UsuarioNotificacion) events.get(0);

        Assertions.assertEquals("Usuario Creado", notificacion.getMessageBody());

    }
}
