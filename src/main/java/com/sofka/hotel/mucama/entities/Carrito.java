package com.sofka.hotel.mucama.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.hotel.mucama.values.CarritoID;
import com.sofka.hotel.mucama.values.Objetos;

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
