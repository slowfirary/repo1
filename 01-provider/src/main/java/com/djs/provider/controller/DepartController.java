package com.djs.provider.controller;


import com.djs.provider.entity.Depart;
import com.djs.provider.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider/depart")
public class DepartController {

    @Autowired
    private DepartService departService;

    @PostMapping("/save")
    public void saveHandle(@RequestBody Depart depart){
        departService.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable int id){
        departService.removeDepartById(id);
    }

    @PutMapping("/update")
    public void updateHandle(@RequestBody Depart depart){
        departService.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable int id){
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandle(){
        return departService.listAllDeparts();
    }
}
