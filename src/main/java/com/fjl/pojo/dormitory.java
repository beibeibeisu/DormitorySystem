package com.fjl.pojo;

import lombok.Data;

@Data
public class dormitory {
    private Integer id;
    private Integer buildingId;
    private String name;
    private  Integer type;
    private Integer available;
    private String telephone;
    private String buildingName;
}
