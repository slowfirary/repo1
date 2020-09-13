package com.djs.provider.controller;


import com.djs.provider.entity.Depart;
import com.djs.provider.service.DepartService;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider/depart")
public class DepartController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Resource
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

    @GetMapping("/discovery")
    public Object discoveryHandle(){
        //获取微服务列表中所有微服务名称
        List<String> springApplicationNames = discoveryClient.getServices();
        for(String name : springApplicationNames){
            //获取所有提供指定微服务名称服务的主机
            List<ServiceInstance> instances = discoveryClient.getInstances(name);
            for(ServiceInstance instance:instances){
                System.out.println(instance.getHost()+":"+instance.getPort()+"/"+instance.getServiceId());
            }
        }
        return springApplicationNames;
    }
}
