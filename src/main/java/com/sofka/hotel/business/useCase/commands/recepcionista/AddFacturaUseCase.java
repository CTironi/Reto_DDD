package com.sofka.hotel.business.useCase.commands.recepcionista;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.recepcionista.Recepcionista;
import com.sofka.hotel.domain.recepcionista.commands.AddFactura;

public class AddFacturaUseCase extends UseCase<RequestCommand<AddFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddFactura> addFacturaRequestCommand) {
        var command = addFacturaRequestCommand.getCommand();
        Recepcionista recepcionista = Recepcionista.from(command.getRecepcionistaID(), repository().getEventsBy(command.getRecepcionistaID().value()));

        recepcionista.addFactura(command.getMonto());

        emit().onResponse(new ResponseEvents(recepcionista.getUncommittedChanges()));
    }
}
