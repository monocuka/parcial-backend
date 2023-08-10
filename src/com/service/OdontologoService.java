package com.service;

import com.dao.IDao;
import com.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class OdontologoService {

    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);

    private IDao<Odontologo> odontologoDao;

    public OdontologoService(IDao<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo guarda(Odontologo odontologo){
        LOGGER.info("Guardando Odontologo:"+odontologo);
        return odontologoDao.guardar(odontologo);
    }

    public ArrayList<Odontologo> todos(){
        LOGGER.info("Listar Odontologos");
        return odontologoDao.listar();
    }
}
