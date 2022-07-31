package com.sofka.hotel.domain.recepcionista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.recepcionista.values.Monto;
import com.sofka.hotel.domain.recepcionista.values.RecepcionistaID;

public class AddFactura extends Command {
    private final RecepcionistaID recepcionistaID;
    private final Monto monto;


    public AddFactura(RecepcionistaID recepcionistaID, Monto monto){
        this.recepcionistaID = recepcionistaID;
        this.monto = monto;
    }

    public RecepcionistaID getRecepcionistaID() {
        return recepcionistaID;
    }

    public Monto getMonto() {
        return monto;
    }
}
