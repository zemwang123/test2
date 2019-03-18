package com.example.springbootvaadin.Service;

import com.example.springbootvaadin.Entity.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Transactional
    public void save(Student student){
        studentRepository.save(student);
    }
    @Transactional
    public void delete(Integer id){
        studentRepository.delete(id);
    }
    @Transactional
    public Student findOne(Integer id){
        return studentRepository.findOne(id);
    }

    @Transactional
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @Transactional
    public List<Student> findBy(String text){
        List<Student> students = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(text);
        if( isNum.matches() ){
            students = studentRepository.findById(Integer.valueOf(text));
            if ( students!=null ){
                return students;
            }
        }
        else
            students = studentRepository.findByNameLike("%"+text+"%");
        return students;
    }
    @Transactional
    public void saveandflush(Student student){
        studentRepository.saveAndFlush(student);
    }
}
