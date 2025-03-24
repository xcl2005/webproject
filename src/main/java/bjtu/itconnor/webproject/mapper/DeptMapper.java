package bjtu.itconnor.webproject.mapper;

import bjtu.itconnor.webproject.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("Select id,name,create_time,update_time from dept order by update_time desc")
    List<Dept> findAll();

    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept (name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    void addById(Dept dept);

    @Update("update dept set name = #{name},update_time=#{updateTime} where id = #{id}")
        // 错误写成update_time=#{update_time} 导致BuG Fixed on3/23/2025
    void updateById(Dept dept);

    @Select("select name,create_time,update_time from dept where id = #{id}")
    Dept findById(Integer id);
}
