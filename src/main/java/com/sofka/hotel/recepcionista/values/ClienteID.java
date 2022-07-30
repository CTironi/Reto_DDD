package com.sofka.hotel.recepcionista.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteID extends Identity {
    public ClienteID(){
    }
    private ClienteID(String id) {super(id);}

    public static ClienteID of(String id) {return new ClienteID(id);}
}
