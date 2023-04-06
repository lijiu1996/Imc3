package com.example.demo.mapper;

import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * @author lijiawei
 * @Description
 * @Date 2021/4/23 9:42
 * @Version 1.0
 */
@Mapper
public interface DcsInfoMapper {

    @Select("select * from ${tableName}")
    List<HashMap<String,Object>> selectTest(@Param("tableName")String tableName);
}
