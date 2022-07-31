package com.sofka.hotel.domain.usuario.values;

import co.com.sofka.domain.generic.Identity;

public class UsuarioID extends Identity {
    public UsuarioID(){
    }
    public UsuarioID(String id) {super(id);}

    public static UsuarioID of(String id) {return new UsuarioID(id);}
}
