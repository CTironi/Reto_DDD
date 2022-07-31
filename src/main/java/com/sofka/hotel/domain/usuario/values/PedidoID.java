package com.sofka.hotel.domain.usuario.values;

import co.com.sofka.domain.generic.Identity;

public class PedidoID extends Identity {
    public PedidoID(){
    }
    public PedidoID(String id) {super(id);}

    public static PedidoID of(String id) {return new PedidoID(id);}
}
