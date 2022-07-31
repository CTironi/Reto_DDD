package com.sofka.hotel.domain.mucama.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.hotel.domain.mucama.values.CarritoID;
import com.sofka.hotel.domain.mucama.values.Objetos;

import java.util.Objects;

public class Carrito extends Entity<CarritoID> {

    protected Objetos objetos;

    public Carrito(CarritoID carritoID, Objetos objetos){
        super(carritoID);
        this.objetos = objetos;

    }

    public Objetos objetos() { return objetos; }
    public void updateCarritoObjetos(Objetos objetos){this.objetos = Objects.requireNonNull(objetos);}

}
