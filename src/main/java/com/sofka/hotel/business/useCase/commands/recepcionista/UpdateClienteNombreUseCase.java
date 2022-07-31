package com.sofka.hotel.business.useCase.commands.recepcionista;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.recepcionista.Recepcionista;
import com.sofka.hotel.domain.recepcionista.commands.UpdateClienteNombre;

public class UpdateClienteNombreUseCase extends UseCase<RequestCommand<UpdateClienteNombre>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateClienteNombre> updateClienteNombreRequestCommand) {
        var command = updateClienteNombreRequestCommand.getCommand();
        Recepcionista recepcionista = Recepcionista.from(command.getRecepcionistaID(), repository().getEventsBy(command.getRecepcionistaID().value()));
        recepcionista.updateClienteNombre(command.getClienteID(), command.getNombreCliente());
        emit().onResponse(new ResponseEvents(recepcionista.getUncommittedChanges()));
    }
}
