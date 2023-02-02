package com.andyron.cache.mapper;

import com.andyron.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author Andy Ron
 */
@Mapper
public interface EmployeeMapper {

    @Select("Select * From employee Where id = #{id}")
    public Employee getEmpById(Integer id);

    @Update("Update employee Set lastName=#{lastName}, email=#{email}, gender=#{gender}, d_id=#{dId} WHERE id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("Delete From employee Where id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("Insert INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);


}
