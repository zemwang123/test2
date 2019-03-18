package com.example.springbootvaadin.UI;

import com.example.springbootvaadin.Entity.Student;
import com.example.springbootvaadin.Service.StudentService;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@SpringUI
public class StudentUI extends UI {
    private static final long serialVersionUID = 1L;

    @Resource
    private StudentService studentService;

    @Override
    protected void init(VaadinRequest request){
        String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();
        Button button1 = new Button("添加");
        Button button2 = new Button("删除");
        Button button3 = new Button("查询");
        Button button4 = new Button("修改");
        TextField textField3 = new TextField("学号:");
        TextField textField1 =  new TextField("姓名:");
        TextField textField2 = new TextField("年龄:");
        TextField textField4 = new TextField("年龄:");
        TextField textField5 = new TextField("姓名:");
        button1.addClickListener(e ->{
            Student student=new Student();
            student.setAge(Integer.valueOf(textField2.getValue()));
            student.setName(textField1.getValue());
            studentService.save(student);
            Notification.show("添加成功!",Notification.Type.WARNING_MESSAGE);
        });
        button2.addClickListener(e ->{
            try{
                studentService.delete(Integer.valueOf(textField3.getValue()));
                Notification.show("删除成功!",Notification.Type.WARNING_MESSAGE);
            }
            catch (Exception x){
                Notification.show("查无此学号!",Notification.Type.WARNING_MESSAGE);
            }

        });
        button3.addClickListener(e ->{
            try {
                Student student = studentService.findOne(Integer.valueOf(textField3.getValue()));
                textField4.setValue(student.getAge().toString());
                textField5.setValue(student.getName());
        }
          catch (Exception x){
               Notification.show("查无此学号!",Notification.Type.WARNING_MESSAGE);
           }
        });
        button4.addClickListener(e ->{
            Student student = new Student();
            student.setAge(Integer.valueOf(textField4.getValue()));
            student.setName(textField5.getValue());
            student.setId(Integer.valueOf(textField3.getValue()));
            studentService.save(student);
            Notification.show("修改成功!",Notification.Type.WARNING_MESSAGE);
        });
        VerticalLayout content1 = new VerticalLayout();
        setContent(content1);
        content1.addComponent(textField1);
        content1.addComponent(textField2);
        content1.addComponent(button1);
        content1.addComponent(textField3);
        content1.addComponent(button2);
        content1.addComponent(button3);
        content1.addComponent(textField4);
        content1.addComponent(textField5);
        content1.addComponent(button4);
        System.out.print(basepath);
    }

    @PostConstruct
    private void initUI(){
        // TODO

        registerListener();
    }

    private void registerListener(){

    }

}
