/*package com.sofka.hotel.business.useCase.commands.mucama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.mucama.commands.UpdateCarritoObjetos;
import com.sofka.hotel.domain.mucama.events.CarritoAdded;
import com.sofka.hotel.domain.mucama.events.CarritoObjetosUpdated;
import com.sofka.hotel.domain.mucama.events.MucamaCreated;
import com.sofka.hotel.domain.mucama.values.CarritoID;
import com.sofka.hotel.domain.mucama.values.MucamaID;
import com.sofka.hotel.domain.mucama.values.NombreMucama;
import com.sofka.hotel.domain.mucama.values.Objetos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateCarritoObjetosUseCaseTest {
    @InjectMocks
    private UpdateCarritoObjetos useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateCarritoObjetos(){

        MucamaID mucamaID = MucamaID.of("1");
        CarritoID carritoID = CarritoID.of("2");
        Objetos objetos = new Objetos("escoba");

        var command = new UpdateCarritoObjetos(mucamaID, carritoID, objetos);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getMucamaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (CarritoObjetosUpdated) events.get(0);
        Assertions.assertEquals("escoba", event.getObjetos().value());
    }
    private List<DomainEvent> history(){

        var event1 = new MucamaCreated(new NombreMucama("Vero"));
        var event2 = new CarritoAdded(new CarritoID("2"), new Objetos("escoba"));

        event1.setAggregateRootId("xxxxx");

        return List.of(event1,event2);
    }
}*/
