package com.sofka.hotel.domain.recepcionista.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofka.hotel.domain.recepcionista.values.FacturaID;
import com.sofka.hotel.domain.recepcionista.values.Monto;

import java.util.Objects;

public class Factura extends Entity<FacturaID> {
    protected Monto monto;

    public Factura(FacturaID facturaID, Monto monto){
        super(facturaID);
        this.monto = monto;

    }

    public Monto monto() { return monto; }
    public void updateFacturaMonto(Monto monto){this.monto = Objects.requireNonNull(monto);}
}
