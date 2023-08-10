package com.dao;

import java.util.ArrayList;

public interface IDao <T>{

    T guardar(T t);

    ArrayList<T> listar();

}
