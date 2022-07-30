package com.sofka.hotel.recepcionista.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.recepcionista.values.*;

public class UpdateFacturaMonto extends Command {
    private final RecepcionistaID recepcionistaID;
    private final FacturaID facturaID;
    private final Monto monto;

    public UpdateFacturaMonto(RecepcionistaID recepcionistaID, FacturaID facturaID, Monto monto){
        this.recepcionistaID = recepcionistaID;
        this.facturaID = facturaID;
        this.monto = monto;
    }

    public RecepcionistaID getRecepcionistaID() {
        return recepcionistaID;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }

    public Monto getMonto() {
        return monto;
    }
}
