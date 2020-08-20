package dir.v2.dao;

import dir.v2.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> getAllStudents() {
        // we connect to database and retrieves student details.
        List<Student> stuList = new ArrayList<>();
        Student obj1 = new Student();
        obj1.setName("Saurabh");
        obj1.setAge(23);
        obj1.setEmail("saurbh@hotmail.com");
        stuList.add(obj1);
        Student obj2 = new Student();
        obj2.setName("satya");
        obj2.setAge(23);
        obj2.setEmail("satya@hotmail.com");
        stuList.add(obj2);
        return stuList;
    }
}
