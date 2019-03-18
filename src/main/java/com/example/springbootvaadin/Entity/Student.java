package com.example.springbootvaadin.Entity;

import javax.persistence.*;

@Entity
@Table(name = "student2")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "s_id")
    private Integer id;
    @Column(name = "s_age")
    private Integer age;
    @Column(name = "s_name")
    private String name;

    public Student(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Student() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
