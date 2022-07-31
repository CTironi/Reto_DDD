package com.sofka.hotel.business.useCase.commands.recepcionista;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.hotel.domain.recepcionista.Recepcionista;
import com.sofka.hotel.domain.recepcionista.commands.UpdateHabitacionClase;

public class UpdateHabitacionClaseUseCase extends UseCase<RequestCommand<UpdateHabitacionClase>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateHabitacionClase> updateHabitacionClaseRequestCommand) {
        var command = updateHabitacionClaseRequestCommand.getCommand();
        Recepcionista recepcionista = Recepcionista.from(command.getRecepcionistaID(), repository().getEventsBy(command.getRecepcionistaID().value()));
        recepcionista.updateHabitacionClase(command.getHabitacionID(), command.getClase());
        emit().onResponse(new ResponseEvents(recepcionista.getUncommittedChanges()));
    }
}
