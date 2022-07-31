package com.sofka.hotel.business.useCase.commands.mucama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.mucama.commands.UpdateTareaPedidos;
import com.sofka.hotel.domain.mucama.events.*;
import com.sofka.hotel.domain.mucama.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateTareaPedidosUseCaseTest {
    @InjectMocks
    private UpdateTareaPedidosUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateTareaPedidos(){

        MucamaID mucamaID = MucamaID.of("1");
        TareaID tareaID = TareaID.of("2");
        Pedidos pedidos = new Pedidos("Cena al 220");
        Limpieza limpieza = new Limpieza("Limpiar 190");
        Equipaje equipaje = new Equipaje("Organizar equipaje 200");

        var command = new UpdateTareaPedidos(mucamaID, tareaID, pedidos);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getMucamaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (TareaPedidosUpdated) events.get(0);
        Assertions.assertEquals("cena al 220", event.getPedidos().value());
    }
    private List<DomainEvent> history(){

        var event1 = new MucamaCreated(new NombreMucama("Vero"));
        var event2 = new TareaAdded(new TareaID("2"), new Pedidos("cena al 220"), new Limpieza("Limpiar 190"), new Equipaje("Organizar equipaje 200"));

        event1.setAggregateRootId("xxxxx");

        return List.of(event1,event2);
    }

}
