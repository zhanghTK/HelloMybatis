package tk.zhangh.mybatis.mappers;

import org.apache.ibatis.annotations.*;
import tk.zhangh.mybatis.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by ZhangHao on 2016/10/28.
 */
public interface StudentMapper {

    @Select("select * from students")
    @Results({
            @Result(id = true, column = "stud_id", property = "studId"),
            @Result(column = "name", property = "name"),
            @Result(column = "email", property = "email"),
            @Result(column = "addr_id", property = "address.addrId")
    })
    List<Student> findAllStudents();

    @Select("select stud_id as studId, name, email, addr_id as 'address.addrId', phone from students")
    List<Map<String, Object>> findAllStudentsMap();

    @Select("select stud_id as studId, name, email, addr_id as 'address.addrId', phone from students where stud_id=#{id}")
    Student findStudentById(Integer id);

    @Select("select stud_id as studId, name, email, addr_id as 'address.addrId', phone from students where stud_id=#{id}")
    Map<String, Object> findStudentMapById(Integer id);

    @Select("select stud_id, name, email, a.addr_id, street, city, state, zip, country" +
            " FROM students s left outer join addresses a on s.addr_id=a.addr_id" +
            " where stud_id=#{studId} ")
    @ResultMap("tk.zhangh.mybatis.mappers.StudentMapper.StudentWithAddressResult")
    Student selectStudentWithAddress(int studId);

//    insert语句，返回插入行数
    @Insert("insert into students(name,email,addr_id, phone) values(#{name},#{email},#{address.addrId},#{phone})")
//    指定主键，并且自动生成主键
    @Options(useGeneratedKeys = true, keyProperty = "studId")
    void insertStudent(Student student);

    @Insert("insert into students(name,email,addr_id, phone) values(#{name},#{email},#{address.addrId},#{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "studId")
    void insertStudentWithMap(Map<String, Object> map);

//    update语句
    @Update("update students set name=#{name}, email=#{email}, phone=#{phone} where stud_id=#{studId}")
    void updateStudent(Student student);

    @Delete("delete from students where stud_id=#{studId}")
    int deleteStudent(int studId);

}
