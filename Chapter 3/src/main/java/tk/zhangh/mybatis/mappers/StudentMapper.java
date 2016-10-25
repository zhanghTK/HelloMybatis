package tk.zhangh.mybatis.mappers;

import tk.zhangh.mybatis.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by ZhangHao on 2016/10/23.
 */
public interface StudentMapper {

    List<Student> findAllStudents();

    Student findStudentById(Integer id);

    Student selectStudentWithAddress(int id);

    void insertStudent(Student student);

    void insertStudentWithMap(Map<String, Object> map);

    void updateStudent(Student student);

    int deleteStudent(int id);
}
