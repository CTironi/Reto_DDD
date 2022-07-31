package com.sofka.hotel.business.useCase.commands.mucama;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.mucama.Mucama;
import com.sofka.hotel.domain.mucama.commands.AddTarea;


public class AddTareaUseCase extends UseCase<RequestCommand<AddTarea>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddTarea> addTareaRequestCommandRequestCommand) {
        var command = addTareaRequestCommandRequestCommand.getCommand();
        Mucama mucama = Mucama.from(command.getMucamaID(), repository().getEventsBy(command.getMucamaID().value()));

        mucama.addTarea(command.getPedidos(), command.getLimpieza(), command.getEquipaje());

        emit().onResponse(new ResponseEvents(mucama.getUncommittedChanges()));
    }
}
