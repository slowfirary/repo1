package com.djs.provider.service;

import com.djs.provider.entity.Depart;
import com.djs.provider.dao.DepartDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartServiceImpl implements DepartService{

    @Resource
    private DepartDao departDao;

    @Override
    public void saveDepart(Depart depart) {
         departDao.save(depart);
    }

    @Override
    public void removeDepartById(int id) {
        departDao.deleteById(id);
    }

    @Override
    public void modifyDepart(Depart depart) {
       departDao.modifyDepart(depart);
    }

    @Override
    public Depart getDepartById(int id) {
        return departDao.getDepartById(id);
    }

    @Override
    public List<Depart> listAllDeparts() {
        return departDao.findAll();
    }
}
