package com.sofka.hotel.mucama.values;

import co.com.sofka.domain.generic.Identity;

public class CarritoID extends Identity {
    public CarritoID(){
    }
    private CarritoID(String id) {super(id);}

    public static CarritoID of(String id) {return new CarritoID(id);}
}
