package com.sofka.hotel.business.useCase.commands.mucama;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.hotel.domain.mucama.commands.CreateMucama;
import com.sofka.hotel.domain.mucama.events.MucamaCreated;
import com.sofka.hotel.domain.mucama.values.MucamaID;
import com.sofka.hotel.domain.mucama.values.NombreMucama;
import com.sofka.hotel.domain.mucama.values.Piso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class CreateMucamaUseCaseTest {
    @InjectMocks
    private CreateMucamaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void CreateMucama(){


        MucamaID mucamaID = MucamaID.of("1");
        NombreMucama nombreMucama = new NombreMucama("vero");
        Piso piso = new Piso(2);

        var command = new CreateMucama(mucamaID, nombreMucama, piso);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(command.getMucamaID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (MucamaCreated) events.get(0);
        Assertions.assertEquals("vero", event.getNombreMucama().value());
    }
}
