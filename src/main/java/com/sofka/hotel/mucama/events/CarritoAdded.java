package com.sofka.hotel.mucama.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.mucama.values.CarritoID;
import com.sofka.hotel.mucama.values.Objetos;

public class CarritoAdded extends DomainEvent {

    private final CarritoID carritoID;
    private final Objetos objetos;


    public CarritoAdded(CarritoID carritoID, Objetos objetos){
        super("com.sofka.hotel.mucama.carritoadded");
        this.carritoID = carritoID;
        this.objetos = objetos;
    }

    public CarritoID getCarritoID() {
        return carritoID;
    }

    public Objetos getObjetos() {
        return objetos;
    }
}
