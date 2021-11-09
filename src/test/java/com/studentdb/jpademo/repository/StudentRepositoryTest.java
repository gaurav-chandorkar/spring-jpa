package com.studentdb.jpademo.repository;

import com.studentdb.jpademo.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .email("rahul@gmail")
                .firstName("Rahul")
                .lastName("Chan")
                .guardianName("Gaurav")
                .guardianEmail("gaurav@gmail")
                .guardianMobile("88999223311")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {

        List<Student> studentList = studentRepository.findAll();
        System.out.println(" printing all " + studentList);
    }

    @Test
    public void searchByFirstName() {

        List<Student> studentList = studentRepository.findByFirstName("Sayali");
        System.out.println(" printing result " + studentList);

    }

    @Test
    public void getStudentByEmail() {
        System.out.println(" By email " + studentRepository.getStudentByEmail("rahul@gmail"));
    }

    @Test
    public void getStudentByEmailNative() {
        System.out.println(" By email " + studentRepository.getStudentByEmailNative("rahul@gmail"));
    }

    @Test
    public void getStudentByEmailNativeNamedParam() {
        System.out.println(" By email by named param " + studentRepository.getStudentByEmailNativeNamedParam("sayali@gmail"));
    }

    @Test
    public void updateStudentNameByEmailId() {
        int i = studentRepository.updateStudentNameByEmailId("Chandorkar", "rahul@gmail");
        System.out.println(" update status " + i);
    }
}