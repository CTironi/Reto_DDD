package com.sofka.hotel.business.useCase.commands.recepcionista;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.recepcionista.Recepcionista;
import com.sofka.hotel.domain.recepcionista.commands.AddCliente;

public class AddClienteUseCase extends UseCase<RequestCommand<AddCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddCliente> addClienteRequestCommand) {
        var command = addClienteRequestCommand.getCommand();
        Recepcionista recepcionista = Recepcionista.from(command.getRecepcionistaID(), repository().getEventsBy(command.getRecepcionistaID().value()));

        recepcionista.addCliente(command.getNombreCliente());

        emit().onResponse(new ResponseEvents(recepcionista.getUncommittedChanges()));
    }
}
