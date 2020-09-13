package com.djs.provider.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;


@Data
@Alias("depart")
public class Depart {
    private Integer id;
    private String name;

}
