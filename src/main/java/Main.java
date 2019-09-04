import MiroWidget.Widget;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

import MiroWidget.ManageWidget;

import java.util.List;

import static MiroWidget.ManageWidget.widgetList;


public class Main {
    public static void main(String[] args) {
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
