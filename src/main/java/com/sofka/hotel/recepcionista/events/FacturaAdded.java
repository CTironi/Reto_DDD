package com.sofka.hotel.recepcionista.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.recepcionista.values.FacturaID;
import com.sofka.hotel.recepcionista.values.Monto;


public class FacturaAdded extends DomainEvent {
    private final FacturaID facturaID;
    private final Monto monto;


    public FacturaAdded(FacturaID facturaID, Monto monto){
        super("com.sofka.hotel.recepcionista.facturaadded");
        this.facturaID = facturaID;
        this.monto = monto;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }

    public Monto getMonto() {
        return monto;
    }
}
