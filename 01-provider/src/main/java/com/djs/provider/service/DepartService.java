package com.djs.provider.service;

import com.djs.provider.entity.Depart;

import java.util.List;

public interface DepartService {

    void saveDepart(Depart depart);

    void removeDepartById(int id);

    void modifyDepart(Depart depart);

    Depart getDepartById(int id);

    List<Depart> listAllDeparts();



}
