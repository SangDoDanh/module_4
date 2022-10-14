package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentRepositoryImpl implements IStudentRepository{
    private static List<Student> studentList;
    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Nguyen Van A", "female", new String[]{"JAVA", "C#"}));
        studentList.add(new Student(2, "Nguyen Van B", "male", new String[]{"C#"}));
        studentList.add(new Student(3, "Nguyen Van C", "male", new String[]{"JAVA"}));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }
}
