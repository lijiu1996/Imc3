package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/4/23 10:24
 * @Version 1.0
 */
@Mapper
public interface DcsInfoTwoMapper {

    /**
     * 根据标签needSend 来获取数据库表信息
     * @param needSend
     * @param tableName
     * @return
     */
    List<LinkedHashMap<String,Object>> getSendInfoByFlag(@Param("needSend") int needSend, @Param("tableName")String tableName);

}
