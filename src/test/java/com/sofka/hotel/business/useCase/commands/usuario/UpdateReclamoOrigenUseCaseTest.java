package com.sofka.hotel.business.useCase.commands.usuario;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.usuario.commands.UpdateReclamoOrigen;
import com.sofka.hotel.domain.usuario.events.PedidoAdded;
import com.sofka.hotel.domain.usuario.events.ReclamoOrigenUpdated;
import com.sofka.hotel.domain.usuario.events.UsuarioCreated;
import com.sofka.hotel.domain.usuario.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateReclamoOrigenUseCaseTest {
    @InjectMocks
    private UpdateReclamoOrigenUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateReclamoOrigen(){

        UsuarioID usuarioID = UsuarioID.of("1");
        ReclamoID reclamoID = ReclamoID.of("2");
        Origen origen = new Origen("ruido");

        var command = new UpdateReclamoOrigen(usuarioID, reclamoID, origen);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getUsuarioID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (ReclamoOrigenUpdated) events.get(0);
        Assertions.assertEquals("ruido", event.getOrigen().value());
    }
    private List<DomainEvent> history(){

        var event1 = new UsuarioCreated(new UsuarioID("1"), new Nombre("Cris"));
        var event2 = new PedidoAdded(new PedidoID("2"), new Tipo("cena"));

        event1.setAggregateRootId("xxxxx");

        return List.of(event1,event2);
    }
}
