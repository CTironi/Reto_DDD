package com.sofka.hotel.mucama.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.mucama.values.*;

public class AddCarrito extends Command {
    private final MucamaID mucamaID;
    private final Objetos objetos;


    public AddCarrito(MucamaID mucamaID,Objetos objetos){
        this.mucamaID = mucamaID;
        this.objetos = objetos;
    }

    public MucamaID getMucamaID() {
        return mucamaID;
    }

    public Objetos getObjetos() {
        return objetos;
    }
}
