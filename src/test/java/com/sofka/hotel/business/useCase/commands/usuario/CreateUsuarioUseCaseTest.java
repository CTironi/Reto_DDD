package com.sofka.hotel.business.useCase.commands.usuario;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.hotel.domain.usuario.commands.CreateUsuario;
import com.sofka.hotel.domain.usuario.events.UsuarioCreated;
import com.sofka.hotel.domain.usuario.values.Nombre;
import com.sofka.hotel.domain.usuario.values.UsuarioID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateUsuarioUseCaseTest {
    @InjectMocks
    private CreateUsuarioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void CreateUsuario(){


        UsuarioID usuarioID = UsuarioID.of("1");
        Nombre nombre = new Nombre("Cris");

        var command = new CreateUsuario(usuarioID, nombre);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getUsuarioID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (UsuarioCreated) events.get(0);
        Assertions.assertEquals("Cris", event.getNombre().value());
    }
}
