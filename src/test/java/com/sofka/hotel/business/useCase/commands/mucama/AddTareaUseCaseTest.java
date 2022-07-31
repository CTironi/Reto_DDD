package com.sofka.hotel.business.useCase.commands.mucama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.mucama.commands.AddTarea;
import com.sofka.hotel.domain.mucama.events.TareaAdded;
import com.sofka.hotel.domain.mucama.values.*;
import com.sofka.hotel.domain.usuario.events.UsuarioCreated;
import com.sofka.hotel.domain.usuario.values.Nombre;
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
public class AddTareaUseCaseTest {
    @InjectMocks
    private AddTareaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addTarea(){

        MucamaID mucamaID = MucamaID.of("1");
        Pedidos pedidos = new Pedidos("cena al 210");
        Limpieza limpieza = new Limpieza("asdasdasd");
        Equipaje equipaje = new Equipaje("asdasdasd");

        var command = new AddTarea(mucamaID, pedidos, limpieza, equipaje);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getMucamaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TareaAdded) events.get(0);
        Assertions.assertEquals("cena al 210",event.getPedidos().value());

    }
    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Cristian");
        UsuarioID usuarioID = new UsuarioID();
        var event = new UsuarioCreated(usuarioID, nombre);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}
