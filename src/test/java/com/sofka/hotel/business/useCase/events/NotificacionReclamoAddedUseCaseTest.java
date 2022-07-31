package com.sofka.hotel.business.useCase.events;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.hotel.domain.usuario.events.ReclamoAdded;
import com.sofka.hotel.domain.usuario.events.ReclamoAddedNotificacion;
import com.sofka.hotel.domain.usuario.values.Fecha;
import com.sofka.hotel.domain.usuario.values.Origen;
import com.sofka.hotel.domain.usuario.values.ReclamoID;
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
public class NotificacionReclamoAddedUseCaseTest {
    @InjectMocks
    private NotificacionReclamoAddedUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void EnviarNotificacion(){

        var event = new ReclamoAdded(new ReclamoID() , new Origen("ruido"), new Fecha(LocalDate.of(1999, 10, 10)));

        event.setAggregateRootId("xxx");

        when(repository.getEventsBy("xxx")).thenReturn(List.of(event));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("xxx")
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var notificacion = (ReclamoAddedNotificacion) events.get(0);

        Assertions.assertEquals("Reclamo Registrado",notificacion.getMessage());

    }
}
