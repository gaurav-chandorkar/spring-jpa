package com.studentdb.jpademo.repository;

import com.studentdb.jpademo.entity.Student;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);

    @Query("SELECT s from Student s where s.email=?1")
    Student getStudentByEmail(String email);

    @Query(value ="SELECT * FROM STUDENT WHERE email=?1",
    nativeQuery = true)
    Student getStudentByEmailNative(String email);


    @Query(value ="SELECT * FROM STUDENT WHERE email=:email1",
            nativeQuery = true)
    Student getStudentByEmailNativeNamedParam(@Param("email1") String email);

    @Modifying
    @Transactional
    @Query(value = "update student set LAST_NAME=?1 where email=?2", nativeQuery = true)
    int updateStudentNameByEmailId(String lastName, String email);
}
