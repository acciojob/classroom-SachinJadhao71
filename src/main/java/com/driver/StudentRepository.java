package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String, Student> studentDb = new HashMap<>();

    HashMap<String,Teacher> teacherDb = new HashMap<>();

    HashMap<Teacher, List<Student>> teacherStudentPair = new HashMap<>();

    public void addStudent(Student student) {

        studentDb.put(student.getName(), student);
    }


    public void addTeacher(Teacher teacher) {
        teacherDb.put(teacher.getName(),teacher);
    }


    public void addStudentTeacherPair(String studentName, String teacherName) {
        Student student = new Student();

        for(String name : studentDb.keySet()){
            if(name.equals(studentName)){
                student = studentDb.get(name);
            }
        }

        Teacher teacher = new Teacher();

        for(String name : teacherDb.keySet()){
            if(name.equals(teacherName)){
                teacher = teacherDb.get(name);
            }
        }

        List<Student> students = new ArrayList<>();
        students.add(student);

        teacherStudentPair.put(teacher,students);
    }

    public Student getStudentByName(String studentName) {

        for(String name : studentDb.keySet()){
            if(name.equals(studentName)){
                return studentDb.get(name);
            }
        }

        return null;
    }

    public Teacher getTeacherByName(String teacherName) {

        for(String name : teacherDb.keySet()){
            if(name.equals(teacherName)){
                return teacherDb.get(name);
            }
        }

        return null;

    }

    public List<Student> getStudentsByTeacherName(String teacherName) {

        for(Teacher teacher : teacherStudentPair.keySet()){
            if(teacher.getName().equals(teacherName)){
                return teacherStudentPair.get(teacher);
            }
        }

        return new ArrayList<>();
    }

    public List<String> getAllStudents() {

        List<String> students = new ArrayList<>();

        for(String name : studentDb.keySet()){
            students.add(name);
        }

        return students;
    }

    public void deleteTeacherByName(String teacherName) {

        for(Teacher teacher : teacherStudentPair.keySet()){
            if(teacher.getName().equals(teacherName)){
                teacherStudentPair.remove(teacher);
                break;
            }
        }

        for(String name : teacherDb.keySet()){
            if(name.equals(teacherName)){
                teacherDb.remove(name);
                break;
            }
        }

    }

    public void deleteAllTeachers() {

        for(Teacher teacher : teacherStudentPair.keySet()){
            teacherStudentPair.remove(teacher);
        }

        for(String name : teacherDb.keySet()){
            teacherDb.remove(name);
        }
    }
}
