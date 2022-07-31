package com.sofka.hotel.domain.recepcionista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.recepcionista.values.Clase;
import com.sofka.hotel.domain.recepcionista.values.HabitacionID;
import com.sofka.hotel.domain.recepcionista.values.RecepcionistaID;


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
