package com.sofka.hotel.business.useCase.commands.usuario;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.usuario.Usuario;
import com.sofka.hotel.domain.usuario.commands.UpdateReclamoOrigen;

public class UpdateReclamoOrigenUseCase extends UseCase<RequestCommand<UpdateReclamoOrigen>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateReclamoOrigen> updateReclamoOrigenRequestCommand) {
        var command = updateReclamoOrigenRequestCommand.getCommand();
        Usuario usuario = Usuario.from(command.getUsuarioID(), repository().getEventsBy(command.getUsuarioID().value()));
        usuario.updateReclamoOrigen(command.getReclamoID(), command.getOrigen());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
