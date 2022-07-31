package com.sofka.hotel.business.useCase.commands.recepcionista;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.recepcionista.commands.UpdateHabitacionClase;
import com.sofka.hotel.domain.recepcionista.events.*;
import com.sofka.hotel.domain.recepcionista.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateHabitacionClaseUseCaseTest {
    @InjectMocks
    private UpdateHabitacionClaseUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateHabitacionClase(){

        RecepcionistaID recepcionistaID = RecepcionistaID.of("1");
        HabitacionID habitacionID = HabitacionID.of("2");
        Clase clase = new Clase("Suit");

        var command = new UpdateHabitacionClase(recepcionistaID, habitacionID, clase);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getRecepcionistaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (HabitacionClaseUpdated) events.get(0);
        Assertions.assertEquals("Suit", event.getClase().value());
    }
    private List<DomainEvent> history(){

        var event1 = new RecepcionistaCreated(new NombreRecepcionista("pepe"));
        var event2 = new HabitacionAdded(new HabitacionID(), new Clase("Suit"));

        event1.setAggregateRootId("xxxxx");

        return List.of(event1,event2);
    }
}
