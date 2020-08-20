package dir.v2.service;

import dir.v2.Student;
import dir.v2.dao.StudentDao;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentDao studentDao;

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
