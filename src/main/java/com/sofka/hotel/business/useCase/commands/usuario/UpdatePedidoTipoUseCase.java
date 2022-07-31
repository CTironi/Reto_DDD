package com.sofka.hotel.business.useCase.commands.usuario;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.usuario.Usuario;
import com.sofka.hotel.domain.usuario.commands.UpdatePedidoTipo;

public class UpdatePedidoTipoUseCase extends UseCase<RequestCommand<UpdatePedidoTipo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePedidoTipo> updatePedidoTipoRequestCommand) {
        var command = updatePedidoTipoRequestCommand.getCommand();
        Usuario usuario = Usuario.from(command.getUsuarioID(), repository().getEventsBy(command.getUsuarioID().value()));
        usuario.updatePedidoTipo(command.getPedidoID(), command.getTipo());
        emit().onResponse(new ResponseEvents(usuario.getUncommittedChanges()));
    }
}
