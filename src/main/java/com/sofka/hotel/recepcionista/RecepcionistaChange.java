package com.sofka.hotel.recepcionista;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.hotel.recepcionista.entities.Cliente;
import com.sofka.hotel.recepcionista.entities.Factura;
import com.sofka.hotel.recepcionista.entities.Habitacion;
import com.sofka.hotel.recepcionista.events.*;

public class RecepcionistaChange extends EventChange {
    RecepcionistaChange(Recepcionista recepcionista) {
        apply((RecepcionistaCreated event) -> {
            recepcionista.nombreRecepcionista = event.getNombreRecepcionista();
        });
        apply((ClienteAdded event) -> {
            recepcionista.cliente = new Cliente(event.getClienteID(), event.getNombreCliente());
        });
        apply((FacturaAdded event) -> {
            recepcionista.factura = new Factura(event.getFacturaID(), event.getMonto());
        });
        apply((HabitacionAdded event) -> {
            recepcionista.habitacion = new Habitacion(event.getHabitacionID(), event.getClase());
        });
        apply((ClienteNombreUpdated event) -> {
            recepcionista.cliente.updateClienteNombre(event.getNombreCliente());
        });
        apply((FacturaMontoUpdated event) -> {
            recepcionista.factura.updateFacturaMonto(event.getMonto());
        });
        apply((HabitacionClaseUpdated event) -> {
            recepcionista.habitacion.updateHabitacionClase(event.getClase());
        });
}
