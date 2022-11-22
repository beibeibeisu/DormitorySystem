package com.fjl.service;

import com.fjl.pojo.absent;

import java.util.List;

public interface absentService {
    /**
     * 所有缺勤的学生
     * @return
     */
    List<absent>findAllAbsent();

    /**
     * 模糊条件查询
     * @param key
     * @param value
     * @return
     */
    List<absent>likeSearch(String key,String value);

    /**
     * 插入一条新的缺勤信息
     * @param absent
     * @return
     */
    int insertOne(absent absent);
}
