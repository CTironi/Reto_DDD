package com.sofka.hotel.domain.mucama.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.mucama.values.CarritoID;
import com.sofka.hotel.domain.mucama.values.MucamaID;
import com.sofka.hotel.domain.mucama.values.Objetos;

public class UpdateCarritoObjetos extends Command {

    private final MucamaID mucamaID;
    private final CarritoID carritoID;
    private final Objetos objetos;

    public UpdateCarritoObjetos(MucamaID mucamaID, CarritoID carritoID, Objetos objetos){
        this.mucamaID = mucamaID;
        this.carritoID = carritoID;
        this.objetos = objetos;
    }

    public MucamaID getMucamaID() {
        return mucamaID;
    }

    public CarritoID getCarritoID() {
        return carritoID;
    }

    public Objetos getObjetos() {
        return objetos;
    }
}
