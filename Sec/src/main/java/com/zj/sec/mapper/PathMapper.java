package com.zj.sec.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PathMapper {
    @Select("select p.id from path p,path_role pr where pr.rid=#{rid} and p.id=pr.pid")
    List<String> getPathByRole();
}
