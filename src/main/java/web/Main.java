package web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import MiroWidget.ManageWidget;

import static MiroWidget.ManageWidget.widgetList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext();

        ManageWidget widgets = new ManageWidget();

        widgets.createWidget(100, 50, 2);
        widgets.createWidget(200, 250, 2);
        widgets.createWidget(50, 50);
        widgets.createWidget(10, 50);
        widgets.createWidget(200, 250, 2);
        widgets.getAllWidgets();

        System.out.println(widgetList.get(0).id);
        widgets.deleteWidget(widgetList.get(0).id);
        widgets.getAllWidgets();
    }
}
