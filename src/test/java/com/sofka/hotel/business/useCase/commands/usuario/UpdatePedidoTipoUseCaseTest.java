package com.sofka.hotel.business.useCase.commands.usuario;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.usuario.commands.UpdatePedidoTipo;
import com.sofka.hotel.domain.usuario.events.PedidoAdded;
import com.sofka.hotel.domain.usuario.events.PedidoTipoUpdated;
import com.sofka.hotel.domain.usuario.events.UsuarioCreated;
import com.sofka.hotel.domain.usuario.values.Nombre;
import com.sofka.hotel.domain.usuario.values.PedidoID;
import com.sofka.hotel.domain.usuario.values.Tipo;
import com.sofka.hotel.domain.usuario.values.UsuarioID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdatePedidoTipoUseCaseTest {
    @InjectMocks
    private UpdatePedidoTipoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updatePedidoTipo(){

        UsuarioID usuarioID = UsuarioID.of("1");
        PedidoID pedidoID = PedidoID.of("2");
        Tipo tipo = new Tipo("cena");

        var command = new UpdatePedidoTipo(usuarioID, pedidoID, tipo);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getUsuarioID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (PedidoTipoUpdated) events.get(0);
        Assertions.assertEquals("cena", event.getTipo().value());
    }
    private List<DomainEvent> history(){

        var event1 = new UsuarioCreated(new UsuarioID("1"), new Nombre("Cris"));
        var event2 = new PedidoAdded(new PedidoID("2"), new Tipo("cena"));

        event1.setAggregateRootId("xxxxx");

        return List.of(event1,event2);
    }
}
