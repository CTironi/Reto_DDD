package com.sofka.hotel.business.useCase.commands.recepcionista;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.recepcionista.Recepcionista;
import com.sofka.hotel.domain.recepcionista.commands.AddHabitacion;

public class AddHabitacionUseCase extends UseCase<RequestCommand<AddHabitacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddHabitacion> addHabitacionRequestCommand) {
        var command = addHabitacionRequestCommand.getCommand();
        Recepcionista recepcionista = Recepcionista.from(command.getRecepcionistaID(), repository().getEventsBy(command.getRecepcionistaID().value()));

        recepcionista.addHabitacion(command.getClase());

        emit().onResponse(new ResponseEvents(recepcionista.getUncommittedChanges()));
    }
}
