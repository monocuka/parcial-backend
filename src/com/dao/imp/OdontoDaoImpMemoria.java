package com.dao.imp;

import com.dao.IDao;
import com.model.Odontologo;

import java.util.ArrayList;

public class OdontoDaoImpMemoria implements IDao<Odontologo> {

    private ArrayList<Odontologo> OdontologosMemoria = new ArrayList<>();

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(OdontologosMemoria.size()+1);
        OdontologosMemoria.add(odontologo);
        return odontologo;    }

    @Override
    public ArrayList<Odontologo> listar() {
        return OdontologosMemoria;
    }
}
