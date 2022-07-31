package com.sofka.hotel.domain.recepcionista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.recepcionista.values.Clase;
import com.sofka.hotel.domain.recepcionista.values.HabitacionID;

public class HabitacionClaseUpdated extends DomainEvent {

    private final HabitacionID habitacionID;
    private final Clase clase;

    public HabitacionClaseUpdated(HabitacionID habitacionID, Clase clase) {
        super("com.sofka.hotel.domain.recepcionista.habitacionclaseupdated");
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
