package com.sofka.hotel.business.useCase.commands.mucama;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.mucama.Mucama;
import com.sofka.hotel.domain.mucama.commands.UpdateCarritoObjetos;

public class UpdateCarritoObjetosUseCase extends UseCase<RequestCommand<UpdateCarritoObjetos>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateCarritoObjetos> updateCarritoObjetosRequestCommandRequestCommand) {
        var command = updateCarritoObjetosRequestCommandRequestCommand.getCommand();
        Mucama mucama = Mucama.from(command.getMucamaID(), repository().getEventsBy(command.getMucamaID().value()));
        mucama.updateCarritoObjetos(command.getCarritoID(), command.getObjetos());
        emit().onResponse(new ResponseEvents(mucama.getUncommittedChanges()));
    }
}
