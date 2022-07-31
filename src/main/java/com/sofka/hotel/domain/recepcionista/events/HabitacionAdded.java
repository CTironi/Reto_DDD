package com.sofka.hotel.domain.recepcionista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.recepcionista.values.Clase;
import com.sofka.hotel.domain.recepcionista.values.HabitacionID;

public class HabitacionAdded extends DomainEvent {

    private final HabitacionID habitacionID;
    private final Clase clase;


    public HabitacionAdded(HabitacionID habitacionID, Clase clase){
        super("com.sofka.hotel.domain.recepcionista.habitacionadded");
        this.habitacionID = habitacionID;
        this.clase = clase;
    }

    public HabitacionID getHabitacionID() {
        return habitacionID;
    }

    public Clase getClase() {
        return clase;
    }
}
