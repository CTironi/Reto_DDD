package com.sofka.hotel.domain.recepcionista;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.hotel.domain.recepcionista.entities.Cliente;
import com.sofka.hotel.domain.recepcionista.entities.Factura;
import com.sofka.hotel.domain.recepcionista.entities.Habitacion;
import com.sofka.hotel.domain.recepcionista.events.*;
import com.sofka.hotel.domain.recepcionista.values.*;



import java.util.List;

public class Recepcionista extends AggregateEvent<RecepcionistaID> {
    protected NombreRecepcionista nombreRecepcionista;
    protected Cliente cliente;
    protected Habitacion habitacion;
    protected Factura factura;

    public Recepcionista(RecepcionistaID recepcionistaID, NombreRecepcionista nombreRecepcionista) {
        super(recepcionistaID);
        appendChange(new RecepcionistaCreated(nombreRecepcionista)).apply();
    }
    private Recepcionista(RecepcionistaID recepcionistaID) {
        super(recepcionistaID);
        subscribe(new RecepcionistaChange(this));
    }
    public static Recepcionista from(RecepcionistaID recepcionistaID, List<DomainEvent> domainEvents) {
        Recepcionista recepcionista = new Recepcionista(recepcionistaID);
        domainEvents.forEach(recepcionista::applyEvent);
        return recepcionista;
    }

    ///events

    public void addCliente(NombreCliente nombreCliente){
        ClienteID clienteID = new ClienteID();
        appendChange(new ClienteAdded(clienteID, nombreCliente)).apply();
    }
    public void addFactura(Monto monto){
        FacturaID facturaID = new FacturaID();
        appendChange(new FacturaAdded(facturaID, monto)).apply();
    }
    public void addHabitacion(Clase clase){
        HabitacionID habitacionID = new HabitacionID();
        appendChange(new HabitacionAdded(habitacionID,clase)).apply();
    }
    public void updateClienteNombre(ClienteID clienteID, NombreCliente nombreCliente){
        appendChange(new ClienteNombreUpdated(clienteID, nombreCliente)).apply();
    }
    public void updateFacturaMonto(FacturaID facturaID, Monto monto){
        appendChange(new FacturaMontoUpdated(facturaID, monto)).apply();
    }
    public void updateHabitacionClase(HabitacionID habitacionID, Clase clase){
        appendChange(new HabitacionClaseUpdated(habitacionID, clase)).apply();
    }

    public NombreRecepcionista getNombreRecepcionista() {
        return nombreRecepcionista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Factura getFactura() {
        return factura;
    }
}
