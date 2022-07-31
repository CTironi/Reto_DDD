package com.sofka.hotel.domain.recepcionista.values;

import co.com.sofka.domain.generic.Identity;

public class HabitacionID extends Identity {
    public HabitacionID(){
    }
    private HabitacionID(String id) {super(id);}

    public static HabitacionID of(String id) {return new HabitacionID(id);}
}
