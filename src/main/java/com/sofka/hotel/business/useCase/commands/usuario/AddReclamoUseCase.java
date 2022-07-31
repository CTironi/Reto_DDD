package com.sofka.hotel.business.useCase.commands.usuario;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.usuario.Usuario;
import com.sofka.hotel.domain.usuario.commands.AddReclamo;

public class AddReclamoUseCase extends UseCase<RequestCommand<AddReclamo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddReclamo> addReclamoRequestCommand) {
        var command = addReclamoRequestCommand.getCommand();
        Usuario usuario = Usuario.from(command.getUsuarioID(), repository().getEventsBy(command.getUsuarioID().value()));
        usuario.addReclamo(command.getOrigen(), command.getFecha());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }

}
