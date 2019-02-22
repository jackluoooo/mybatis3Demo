package com.luo.config;

import lombok.Data;

/**
 * @author：罗金星 date 2019/2/14 9:26
 **/
@Data
public class MapperStatement {
    private String namespace;
    private String sourceId;
    private String resultType;
    private String sql;
}
