package com.sofka.hotel.domain.recepcionista.values;

import co.com.sofka.domain.generic.Identity;

public class RecepcionistaID extends Identity {
    public RecepcionistaID(){
    }
    private RecepcionistaID(String id) {super(id);}

    public static RecepcionistaID of(String id) {return new RecepcionistaID(id);}
}
