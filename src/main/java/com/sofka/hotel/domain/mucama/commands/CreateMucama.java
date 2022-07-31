package com.sofka.hotel.domain.mucama.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.hotel.domain.mucama.values.NombreMucama;
import com.sofka.hotel.domain.mucama.values.Piso;
import com.sofka.hotel.domain.mucama.values.MucamaID;


public class CreateMucama extends Command {

    private final MucamaID mucamaID;
    private final NombreMucama nombreMucama;
    private final Piso piso;

    public CreateMucama(MucamaID mucamaID, NombreMucama nombreMucama, Piso piso){
        this.mucamaID = mucamaID;
        this.nombreMucama = nombreMucama;
        this.piso = piso;
    }

    public MucamaID getMucamaID() {
        return mucamaID;
    }

    public NombreMucama getNombreMucama() {
        return nombreMucama;
    }

    public Piso getPiso() {
        return piso;
    }
}
