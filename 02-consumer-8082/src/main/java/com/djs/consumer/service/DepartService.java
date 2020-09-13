package com.djs.consumer.service;

import com.djs.consumer.entity.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@FeignClient(value = "djs-provider-depart",fallbackFactory = DepartFallbackFactory.class)  //指定当前Service绑定的提供者微服务名称
@RequestMapping("/provider/depart")
public interface DepartService {
    @PostMapping("/save")
    void saveDepart(Depart depart);

    @DeleteMapping("/del/{id}")
    void removeDepartById(@PathVariable int id);

    @PutMapping("/update")
    void modifyDepart(Depart depart);

    @GetMapping("/get/{id}")
    Depart getDepartById(@PathVariable int id);

    @GetMapping("/list")
    List<Depart> listAllDeparts();
}
