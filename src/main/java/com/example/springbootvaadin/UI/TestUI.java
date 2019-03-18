package com.example.springbootvaadin.UI;

import com.example.springbootvaadin.Entity.Student;
import com.example.springbootvaadin.Service.StudentService;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;




public class TestUI extends UI {
    @Resource
    private StudentService studentService;
    VerticalLayout content = new VerticalLayout();
    HorizontalLayout con = new HorizontalLayout();
    HorizontalLayout content1 = new HorizontalLayout();
    HorizontalLayout subcontent = new HorizontalLayout();
    VerticalLayout navigation = new VerticalLayout();
    Label label = new Label("   导航栏");
    Button stu = new Button("学生");
    Window subwindow = new Window("添加");
    Window subwindow2 = new Window("修改");
    TextField nameText2 = new TextField("姓名");
    TextField ageText2 = new TextField("年龄");
    Button confirm2 = new Button("确定");
    HorizontalLayout subcontent2 = new HorizontalLayout();
    VerticalLayout subcontent3 = new VerticalLayout();
    TextField nameText = new TextField("姓名");
    TextField ageText = new TextField("年龄");
    Button confirm = new Button("确定");
    Grid<Student> grid = new Grid();
    TextField textField = new TextField();
    Button addBtn = new Button("添加");
    Button delBtn = new Button("删除");
    Button getBtn = new Button("查找");
    Button updBtn = new Button("修改");
    VerticalLayout subcontent1 = new VerticalLayout();


    protected void init(VaadinRequest request){
        subwindow.setContent(subcontent1);
        subwindow2.setContent(subcontent3);
        subcontent3.addComponents(subcontent2,confirm2);
        subcontent2.addComponents(nameText2,ageText2);
        subcontent1.addComponents(subcontent,confirm);
        subcontent.addComponents(nameText,ageText);
        navigation.addComponents(label,stu);
        subwindow.center();
        subwindow2.center();
        initgrd();
        initlistenner();
        content1.addComponents(textField,addBtn,delBtn,getBtn,updBtn);
        con.addComponents(navigation,content);
        setContent(con);
        content.addComponent(content1);
        content.addComponent(grid);
        content.setVisible(false);
        flush(grid);
        subcontent1.setMargin(new MarginInfo(true,true,true,true));
    }



    protected void initgrd(){
        grid.setWidth("1000px");
        grid.setHeight("300px");
        grid.addColumn(Student::getName).setCaption("stuName");
        grid.addColumn(Student::getAge).setCaption("stuAge");
        grid.addColumn(Student::getId).setCaption("stuId");
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
    }

    protected void flush(Grid grid){
        List<Student> students = studentService.findAll();
        grid.setItems(students);
    }

    protected void initlistenner(){
        delBtn.addClickListener(e ->{
            Set<Student> students=grid.getSelectedItems();
            if (students==null){
                return;
            }
            for(Student s : students){
                studentService.delete(s.getId());
            }
            flush(grid);
            Notification.show("删除成功",Notification.Type.WARNING_MESSAGE);
        });

        addBtn.addClickListener(e->{
            con.setEnabled(false);
            addWindow(subwindow);
        });

        getBtn.addClickListener(e->{
            if (textField.getValue().trim()==null||textField.getValue().trim()==""){
                flush(grid);
                return;
            }
            else {
            List<Student> students=studentService.findBy(textField.getValue());
            grid.setItems(students);
            }
        });

        confirm.addClickListener(e->{
            Student student = new Student(Integer.valueOf(ageText.getValue()),nameText.getValue());
            studentService.save(student);
            flush(grid);
            removeWindow(subwindow);
            con.setEnabled(true);
            ageText.setValue("");
            nameText.setValue("");
            Notification.show("添加成功",Notification.Type.WARNING_MESSAGE);
        });

        updBtn.addClickListener(e->{
             Set<Student> students = grid.getSelectedItems();
             if (students.size()!=1){
                 Notification.show("所选学生只能为一个！",Notification.Type.WARNING_MESSAGE);
                 return;
             }
             addWindow(subwindow2);
            con.setEnabled(false);
             for (Student s:students)
             {
                 nameText2.setValue(s.getName());
                 ageText2.setValue(s.getAge().toString());
             }
             confirm2.addClickListener(ev->{
                for (Student s:students){
                    s.setAge(Integer.valueOf(ageText2.getValue()));
                    s.setName(nameText2.getValue());
                    studentService.saveandflush(s);
                    removeWindow(subwindow2);
                    nameText2.setValue("");
                    ageText2.setValue("");
                    con.setEnabled(true);
                    flush(grid);
                }
             });
        });
        stu.addClickListener(e->{
           content.setVisible(!(content.isVisible()));
        });

        subwindow.addCloseListener(e->{
           con.setEnabled(true);
        });
        subwindow2.addCloseListener(e->{
           con.setEnabled(true);
        });
    }
}


