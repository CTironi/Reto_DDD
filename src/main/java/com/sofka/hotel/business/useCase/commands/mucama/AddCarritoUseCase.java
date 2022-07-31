package com.sofka.hotel.business.useCase.commands.mucama;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.mucama.Mucama;
import com.sofka.hotel.domain.mucama.commands.AddCarrito;


public class AddCarritoUseCase extends UseCase<RequestCommand<AddCarrito>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddCarrito> addCarritoRequestCommand) {
        var command = addCarritoRequestCommand.getCommand();
        Mucama mucama = Mucama.from(command.getMucamaID(), repository().getEventsBy(command.getMucamaID().value()));

        mucama.addCarrito(command.getObjetos());

        emit().onResponse(new ResponseEvents(mucama.getUncommittedChanges()));
    }
}
