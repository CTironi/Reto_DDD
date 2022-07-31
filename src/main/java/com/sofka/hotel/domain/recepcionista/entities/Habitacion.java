package com.sofka.hotel.domain.recepcionista.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.hotel.domain.recepcionista.values.Clase;
import com.sofka.hotel.domain.recepcionista.values.HabitacionID;

import java.util.Objects;

public class Habitacion extends Entity<HabitacionID> {
    protected Clase clase;

    public Habitacion(HabitacionID habitacionID, Clase clase){
        super(habitacionID);
        this.clase = clase;

    }

    public Clase clase() { return clase; }
    public void updateHabitacionClase(Clase clase){this.clase = Objects.requireNonNull(clase);}
}
