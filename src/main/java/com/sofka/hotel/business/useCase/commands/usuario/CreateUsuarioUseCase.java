package com.sofka.hotel.business.useCase.commands.usuario;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.usuario.Usuario;
import com.sofka.hotel.domain.usuario.commands.CreateUsuario;

public class CreateUsuarioUseCase extends UseCase<RequestCommand<CreateUsuario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateUsuario> createUsuarioRequestCommand) {
        var command = createUsuarioRequestCommand.getCommand();

        var usuario = new Usuario(command.getUsuarioID(), command.getNombre());

        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
