package com.example.springbootvaadin.Service;

import com.example.springbootvaadin.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface StudentRepository extends JpaRepository<Student,Integer> {
    public List<Student> findById(Integer Id);
    public List<Student> findByNameLike(String name);

}
