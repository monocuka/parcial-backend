package com.services;

import com.dao.imp.OdontoDaoImpH2;
import com.model.Odontologo;
import com.service.OdontologoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class OdontologoServiceTest {
    @Test
        void todos() {
            OdontologoService odontologoService = new OdontologoService(new OdontoDaoImpH2());
            odontologoService.guarda(new Odontologo(213244, "Matilda", "jurado"));
            odontologoService.guarda(new Odontologo(3746463, "Martha", "Penia"));


            ArrayList<Odontologo> odontologos = odontologoService.todos();
            Assert.assertEquals(odontologos.size(), 2);

    }

}