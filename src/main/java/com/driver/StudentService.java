package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student) {
        studentRepository.addStudent(student);

    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        studentRepository.addStudentTeacherPair(student,teacher);
    }

    public Student getStudentByName(String name) {
        Student student = studentRepository.getStudentByName(name);
        return student;
    }

    public Teacher getTeacherByName(String name) {
        Teacher teacher = studentRepository.getTeacherByName(name);
        return teacher;
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        List<Student> ans = studentRepository.getStudentsByTeacherName(teacher);


        List<String> ansList = new ArrayList<>();
        for(int i=0; i<ans.size(); i++){
            ansList.add(ans.get(i).getName());
        }
        return ansList;
    }

    public List<String> getAllStudents() {
        List<String> students = studentRepository.getAllStudents();

        return students;
    }

    public void deleteTeacherByName(String teacher) {
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
