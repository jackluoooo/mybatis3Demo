package com.luo.config;

import lombok.Data;

import java.util.Map;

/**
 * @author：罗金星 date 2019/2/14 9:30
 **/
@Data
public class Configuration {
    private String jdbcDriver;
    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;

    private Map<String,MapperStatement> map;

}
