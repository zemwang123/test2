package com.example.springbootvaadin.UI;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.slider.SliderOrientation;
import com.vaadin.ui.Label;
import com.vaadin.ui.Slider;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class Test extends UI {
    protected void init(VaadinRequest request){
        /*VerticalLayout con = new VerticalLayout();
        setContent(con);
        TextField textField = new TextField();
        Label echo = new Label();

        textField.addValueChangeListener(event -> {
            String origin = event.isUserOriginated()
                    ? "user"
                    : "application";
            String message = origin
                    + " entered the following: "
                    + event.getValue();
            Notification.show(message);
        });
        con.addComponents(textField);*/





        /*VerticalLayout con = new VerticalLayout();
        setContent(con);
        ListSelect<String> select = new ListSelect<>("My Select");
        con.addComponents(select);
        select.setItems("Io", "Europa", "Ganymedes", "Callisto");

        select.addSelectionListener(event ->
                con.addComponent(new Label("Selected " +
                        event.getNewSelection())));*/


       /* VerticalLayout con = new VerticalLayout();
        setContent(con);
        TwinColSelect<String> select =
                new TwinColSelect<>("Select Targets");

// Put some items in the select
        select.setItems("Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune");

// Few items, so we can set rows to match item count
        select.setRows(select.getRows());

// Preselect a few items
        select.select("Venus", "Earth", "Mars");
        con.addComponents(select);
// Handle value changes
        select.addSelectionListener(event ->
                con.addComponent(
                        new Label("Selected: " + event.getNewSelection())));*/


        /*VerticalLayout con = new VerticalLayout();
        com.vaadin.ui.MenuBar barmenu = new MenuBar();
        con.addComponent(barmenu);
        MenuBar.MenuItem drinks = barmenu.addItem("Beverages", null, null);

// Submenu item with a sub-submenu
        MenuBar.MenuItem hots = drinks.addItem("Hot", null, null);
        hots.addItem("Tea", null);
        hots.addItem("Coffee",null);

// Another submenu item with a sub-submenu
        MenuBar.MenuItem colds = drinks.addItem("Cold", null, null);
        colds.addItem("Milk",      null);
        colds.addItem("Weissbier", null);

// Another top-level item
        MenuBar.MenuItem snacks = barmenu.addItem("Snacks", null, null);
        snacks.addItem("Weisswurst", null);
        snacks.addItem("Bratwurst",  null);
        snacks.addItem("Currywurst", null);

// Yet another top-level item
        MenuBar.MenuItem servs = barmenu.addItem("Services", null, null);
        servs.addItem("Car Service", null);
        con.addComponents(barmenu);
        setContent(con);*/


        /*ProgressBar bar = new ProgressBar(0.0f);
        bar.setIndeterminate(true);
        VerticalLayout con = new VerticalLayout();
        setContent(con);
        con.addComponents(bar);
        con.addComponents(new Button("Increase",clickEvent -> {
            float current = bar.getValue();
            if (current < 1.0f)
                bar.setValue(current + 0.10f);
        }));*/


        VerticalLayout con = new VerticalLayout();
        setContent(con);
        Slider slider = new Slider(1,100);
        slider.setOrientation(SliderOrientation.VERTICAL);
        Label slidervalue = new Label();
        con.addComponents(slider,slidervalue);
        slider.addValueChangeListener(event ->{
           float value = event.getValue().floatValue();
           slidervalue.setValue(String.valueOf(value));
        });
    }

}
