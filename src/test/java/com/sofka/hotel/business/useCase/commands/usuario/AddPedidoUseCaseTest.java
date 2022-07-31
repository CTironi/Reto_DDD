package com.sofka.hotel.business.useCase.commands.usuario;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.usuario.commands.AddPedido;
import com.sofka.hotel.domain.usuario.events.PedidoAdded;
import com.sofka.hotel.domain.usuario.events.UsuarioCreated;
import com.sofka.hotel.domain.usuario.values.Nombre;
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
public class AddPedidoUseCaseTest {
    @InjectMocks
    private AddPedidoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addPedido(){

        UsuarioID usuarioID = UsuarioID.of("1");
        Tipo tipo = new Tipo("cena");

        var command = new AddPedido(usuarioID, tipo);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getUsuarioID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PedidoAdded) events.get(0);
        Assertions.assertEquals("cena",event.getTipo().value());

    }
    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Cristian");
        UsuarioID usuarioID = new UsuarioID();
        var event = new UsuarioCreated(usuarioID, nombre);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}
