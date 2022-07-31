package com.sofka.hotel.business.useCase.commands.recepcionista;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.recepcionista.commands.AddCliente;
import com.sofka.hotel.domain.recepcionista.events.ClienteAdded;
import com.sofka.hotel.domain.recepcionista.values.NombreCliente;
import com.sofka.hotel.domain.recepcionista.values.RecepcionistaID;
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
public class AddClienteUseCaseTest {
    @InjectMocks
    private AddClienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void addCliente(){

        RecepcionistaID recepcionistaID = RecepcionistaID.of("1");
        NombreCliente nombreCliente = new NombreCliente("Eddi");

        var command = new AddCliente(recepcionistaID, nombreCliente);

        when(repository.getEventsBy("1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getRecepcionistaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ClienteAdded) events.get(0);
        Assertions.assertEquals("Eddi",event.getNombreCliente().value());

    }
    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Cristian");
        UsuarioID usuarioID = new UsuarioID();
        var event = new UsuarioCreated(usuarioID, nombre);
        event.setAggregateRootId("xxxxx");
        return List.of(event);
    }
}
