package com.sofka.hotel.business.useCase.commands.recepcionista;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.recepcionista.Recepcionista;
import com.sofka.hotel.domain.recepcionista.commands.UpdateFacturaMonto;

public class UpdateFacturaMontoUseCase extends UseCase<RequestCommand<UpdateFacturaMonto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateFacturaMonto> updateFacturaMontoRequestCommand) {
        var command = updateFacturaMontoRequestCommand.getCommand();
        Recepcionista recepcionista = Recepcionista.from(command.getRecepcionistaID(), repository().getEventsBy(command.getRecepcionistaID().value()));
        recepcionista.updateFacturaMonto(command.getFacturaID(), command.getMonto());
        emit().onResponse(new ResponseEvents(recepcionista.getUncommittedChanges()));
    }
}
