package com.sofka.hotel.business.useCase.commands.mucama;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.mucama.Mucama;
import com.sofka.hotel.domain.mucama.commands.CreateMucama;

public class CreateMucamaUseCase extends UseCase<RequestCommand<CreateMucama>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateMucama> createMucamaRequestCommand) {
        var command = createMucamaRequestCommand.getCommand();

        var mucama = new Mucama( command.getMucamaID(), command.getNombreMucama(), command.getPiso());

        emit().onResponse(new ResponseEvents(mucama.getUncommittedChanges()));
    }
}
