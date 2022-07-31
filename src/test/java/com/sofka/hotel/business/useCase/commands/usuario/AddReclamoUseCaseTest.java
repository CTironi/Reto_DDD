package com.sofka.hotel.business.useCase.commands.usuario;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.usuario.commands.AddReclamo;
import com.sofka.hotel.domain.usuario.events.ReclamoAdded;
import com.sofka.hotel.domain.usuario.events.UsuarioCreated;
import com.sofka.hotel.domain.usuario.values.*;
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
public class AddReclamoUseCaseTest {
    @InjectMocks
    private AddReclamoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addReclamo(){

        UsuarioID usuarioID = UsuarioID.of("1");
        Origen origen = new Origen("ruido");
        Fecha fecha = new Fecha(LocalDate.of(1999, 10, 10));

        var command = new AddReclamo(usuarioID, origen, fecha);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getUsuarioID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ReclamoAdded) events.get(0);
        Assertions.assertEquals("ruido",event.getOrigen().value());

    }
    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Cristian");
        UsuarioID usuarioID = new UsuarioID();
        var event = new UsuarioCreated(usuarioID, nombre);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}
