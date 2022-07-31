package com.sofka.hotel.domain.recepcionista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.recepcionista.values.Clase;
import com.sofka.hotel.domain.recepcionista.values.RecepcionistaID;

public class AddHabitacion extends Command {
    private final RecepcionistaID recepcionistaID;
    private final Clase clase;


    public AddHabitacion(RecepcionistaID recepcionistaID, Clase clase){
        this.recepcionistaID = recepcionistaID;
        this.clase = clase;
    }

    public RecepcionistaID getRecepcionistaID() {
        return recepcionistaID;
    }

    public Clase getClase() {
        return clase;
    }
}
