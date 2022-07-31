package com.sofka.hotel.domain.usuario.values;

import co.com.sofka.domain.generic.Identity;

public class ReclamoID extends Identity {
    public ReclamoID(){
    }
    private ReclamoID(String id) {super(id);}

    public static ReclamoID of(String id) {return new ReclamoID(id);}

}
