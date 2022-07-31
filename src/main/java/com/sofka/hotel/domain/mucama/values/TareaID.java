package com.sofka.hotel.domain.mucama.values;

import co.com.sofka.domain.generic.Identity;

public class TareaID extends Identity {
    public TareaID(){
    }
    public TareaID(String id) {super(id);}

    public static TareaID of(String id) {return new TareaID(id);}

}
