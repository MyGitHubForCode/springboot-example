package com.example.springbootexample.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:
 * Description:
 * date: 2019/8/19 0019 14:14
 *
 * @author SS
 * @since JDK 1.8
 */
@Data
public class CityModel implements Serializable {
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private String population;

}
