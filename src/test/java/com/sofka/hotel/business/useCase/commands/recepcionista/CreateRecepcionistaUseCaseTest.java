package com.sofka.hotel.business.useCase.commands.recepcionista;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.hotel.domain.recepcionista.commands.CreateRecepcionista;
import com.sofka.hotel.domain.recepcionista.events.RecepcionistaCreated;
import com.sofka.hotel.domain.recepcionista.values.NombreRecepcionista;
import com.sofka.hotel.domain.recepcionista.values.RecepcionistaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateRecepcionistaUseCaseTest {
    @InjectMocks
    private CreateRecepcionistaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void CreateRecepcionista(){


        RecepcionistaID recepcionistaID = RecepcionistaID.of("1");
        NombreRecepcionista nombreRecepcionista = new NombreRecepcionista("pepe");

        var command = new CreateRecepcionista(recepcionistaID, nombreRecepcionista);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getRecepcionistaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (RecepcionistaCreated) events.get(0);
        Assertions.assertEquals("pepe", event.getNombreRecepcionista().value());
    }
}
