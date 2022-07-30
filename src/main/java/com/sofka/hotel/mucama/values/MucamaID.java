package com.sofka.hotel.mucama.values;

import co.com.sofka.domain.generic.Identity;

public class MucamaID extends Identity {
    public MucamaID(){
    }
    private MucamaID(String id) {super(id);}

    public static MucamaID of(String id) {return new MucamaID(id);}
}
