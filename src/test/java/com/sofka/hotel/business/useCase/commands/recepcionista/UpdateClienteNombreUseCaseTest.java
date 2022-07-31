package com.sofka.hotel.business.useCase.commands.recepcionista;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.recepcionista.commands.UpdateClienteNombre;
import com.sofka.hotel.domain.recepcionista.events.ClienteAdded;
import com.sofka.hotel.domain.recepcionista.events.ClienteNombreUpdated;
import com.sofka.hotel.domain.recepcionista.events.RecepcionistaCreated;
import com.sofka.hotel.domain.recepcionista.values.ClienteID;
import com.sofka.hotel.domain.recepcionista.values.NombreCliente;
import com.sofka.hotel.domain.recepcionista.values.NombreRecepcionista;
import com.sofka.hotel.domain.recepcionista.values.RecepcionistaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateClienteNombreUseCaseTest {
    @InjectMocks
    private UpdateClienteNombreUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateClienteNombre(){

        RecepcionistaID recepcionistaID = RecepcionistaID.of("1");
        ClienteID clienteID = ClienteID.of("2");
        NombreCliente nombreCliente = new NombreCliente("Eddi");

        var command = new UpdateClienteNombre(recepcionistaID, clienteID, nombreCliente);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getRecepcionistaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        var event = (ClienteNombreUpdated) events.get(0);
        Assertions.assertEquals("Eddi", event.getNombreCliente().value());
    }
    private List<DomainEvent> history(){

        var event1 = new RecepcionistaCreated(new NombreRecepcionista("pepe"));
        var event2 = new ClienteAdded(new ClienteID(), new NombreCliente("Eddi"));

        event1.setAggregateRootId("xxxxx");

        return List.of(event1,event2);
    }
}
