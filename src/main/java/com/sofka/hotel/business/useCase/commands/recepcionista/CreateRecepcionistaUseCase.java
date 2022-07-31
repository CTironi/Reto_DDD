package com.sofka.hotel.business.useCase.commands.recepcionista;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.recepcionista.Recepcionista;
import com.sofka.hotel.domain.recepcionista.commands.CreateRecepcionista;

public class CreateRecepcionistaUseCase extends UseCase<RequestCommand<CreateRecepcionista>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateRecepcionista> createRecepcionistaRequestCommand) {
        var command = createRecepcionistaRequestCommand.getCommand();

        var recepcionista = new Recepcionista(command.getRecepcionistaID(), command.getNombreRecepcionista());

        emit().onResponse(new ResponseEvents(recepcionista.getUncommittedChanges()));
    }
}
