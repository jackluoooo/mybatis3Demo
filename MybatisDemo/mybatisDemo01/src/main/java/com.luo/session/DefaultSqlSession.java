package com.luo.session;

import java.util.List;

/**
 * @author：罗金星 date 2019/2/14 13:33
 **/
public class DefaultSqlSession implements SqlSession {
    public <T> T selectOne(String statement, Object parameter) {
        return null;
    }

    public <E> List<E> selectList(String statement, Object parameter) {
        return null;
    }

    public <T> T getMapper(Class<T> type) {
        return null;
    }
}
