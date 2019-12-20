package MiroWidget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        WidgetController widgets = new WidgetController();

//        widgets.createWidget(50, 50, 100,100, 2);
//        widgets.createWidget(50, 100, 100, 100, 2);
//        widgets.createWidget(100, 100, 100,100, 2);
//        widgets.createWidget(400, 250, 100, 100, 2);
//        widgets.createWidget(500, 50, 0,0, 2);
//        widgets.createWidget(600, 250, 100, 100, 2);
//        widgets.createWidget(50, 50);
//        widgets.createWidget(10, 50);
//        widgets.createWidget(200, 250, 2);

        SpringApplication.run(Main.class, args);

//        ApplicationContext context = new AnnotationConfigApplicationContext();
//
//        WidgetController widgets = new WidgetController();
//
//        widgets.createWidget(100, 50, 2);
//        widgets.createWidget(200, 250, 2);
//        widgets.createWidget(50, 50);
//        widgets.createWidget(10, 50);
//        widgets.createWidget(200, 250, 2);
//        widgets.getAllWidgets();
//
//        System.out.println(widgetList.get(0).id);
//        widgets.deleteWidget(widgetList.get(0).id);
//        widgets.getAllWidgets();
    }
}
