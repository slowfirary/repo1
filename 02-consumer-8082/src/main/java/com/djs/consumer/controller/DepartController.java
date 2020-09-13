package com.djs.consumer.controller;


import com.djs.consumer.entity.Depart;
import com.djs.consumer.service.DepartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer/depart")
public class DepartController {

    @Autowired
    private DepartService departService;


    @PostMapping("/save")
    public void saveHandle(Depart depart){
        departService.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable int id){
       departService.removeDepartById(id);
    }

    @PutMapping("/update")
    public void updateHandle(Depart depart){
        departService.modifyDepart(depart);
    }

    //服务降级,若当前处理器方法发生异常，则执行fallbackMethod中的方法
    @HystrixCommand(fallbackMethod = "getHystrixHandle")
    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable int id){
        Depart depart =  departService.getDepartById(id);
        if(depart == null){
            throw new RuntimeException("no this depart");
        }
           return depart;
    }

    @GetMapping("/list")
    public List<Depart> listHandle(){
        return departService.listAllDeparts();
    }

    public Depart getHystrixHandle(@PathVariable int id){
        Depart depart = new Depart();
        depart.setId(id);
        depart.setName("no this depart");
        return depart;
    }
}

