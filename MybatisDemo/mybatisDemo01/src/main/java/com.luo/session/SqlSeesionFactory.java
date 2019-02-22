package com.luo.session;

import com.luo.config.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSession;

/**
 * @author：罗金星 date 2019/2/14 9:33
 **/
public class SqlSeesionFactory {
    /**
     * config 全局唯一
     */
    private final Configuration configuration = new Configuration();

    public SqlSeesionFactory() {
        // loadDbInfo(); 获取数据库信息
        // loadMappersInfo();获取Mapper
        configuration.setJdbcDriver("**");
    }

    public SqlSession openSession(Configuration configuration) {
//        return new DefaultSqlSession(configuration);
        return null;
    }
}
