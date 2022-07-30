package com.sofka.hotel.recepcionista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.recepcionista.values.*;

public class UpdateHabitacionClase extends Command {
    private final RecepcionistaID recepcionistaID;
    private final HabitacionID habitacionID;
    private final Clase clase;

    public UpdateHabitacionClase(RecepcionistaID recepcionistaID, HabitacionID habitacionID, Clase clase){
        this.recepcionistaID = recepcionistaID;
        this.habitacionID = habitacionID;
        this.clase = clase;
    }

    public RecepcionistaID getRecepcionistaID() {
        return recepcionistaID;
    }

    public HabitacionID getHabitacionID() {
        return habitacionID;
    }

    public Clase getClase() {
        return clase;
    }
}
