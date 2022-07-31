package com.sofka.hotel.business.useCase.commands.mucama;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.mucama.Mucama;
import com.sofka.hotel.domain.mucama.commands.UpdateTareaPedidos;

public class UpdateTareaPedidosUseCase extends UseCase<RequestCommand<UpdateTareaPedidos>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateTareaPedidos> updateTareaPedidosRequestCommand) {
        var command = updateTareaPedidosRequestCommand.getCommand();
        Mucama mucama = Mucama.from(command.getMucamaID(), repository().getEventsBy(command.getMucamaID().value()));
        mucama.updateTareaPedidos(command.getTareaID(), command.getPedidos());
        emit().onResponse(new ResponseEvents(mucama.getUncommittedChanges()));
    }
}
