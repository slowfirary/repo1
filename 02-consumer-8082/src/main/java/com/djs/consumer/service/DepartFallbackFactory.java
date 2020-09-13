package com.djs.consumer.service;

import com.djs.consumer.entity.Depart;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DepartFallbackFactory implements FallbackFactory<DepartService> {
    @Override
    public DepartService create(Throwable throwable) {
        //返回feign接口的匿名内部类
        return new DepartService() {
            @Override
            public void saveDepart(Depart depart) {

            }

            @Override
            public void removeDepartById(int id) {

            }

            @Override
            public void modifyDepart(Depart depart) {

            }

            @Override
            public Depart getDepartById(int id) {
                return new Depart(id,"fallback");
            }

            @Override
            public List<Depart> listAllDeparts() {
                return null;
            }
        };
    }
}
