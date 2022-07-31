package com.sofka.hotel.business.useCase.commands.usuario;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.usuario.Usuario;
import com.sofka.hotel.domain.usuario.commands.AddPedido;

public class AddPedidoUseCase extends UseCase<RequestCommand<AddPedido>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddPedido> addPedidoRequestCommand) {
        var command = addPedidoRequestCommand.getCommand();
        Usuario usuario = Usuario.from(command.getUsuarioID(), repository().getEventsBy(command.getUsuarioID().value()));
        usuario.addPedido(command.getTipo());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
