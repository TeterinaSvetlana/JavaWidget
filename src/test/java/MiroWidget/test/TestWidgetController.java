package MiroWidget.test;

import MiroWidget.Main;
import MiroWidget.enities.Widget;
import MiroWidget.WidgetController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestWidgetController {

    ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

    WidgetController widget = context.getBean ("widgetController", WidgetController.class);

    private static List<Widget> widgetList = new ArrayList();

    @Test
    public void testCreateWidget(){
        Widget tempWidget = widget.createWidget(10, 10, 100, 50,0);
        assertTrue((tempWidget.getWidth() == 100)&&(tempWidget.getHight() == 50)&&(tempWidget.getIndex() == 1)&&(tempWidget.getId() != null)&&(tempWidget.getDate() != null));
        assertTrue(widget.widgetList.size() == 1 );

        tempWidget = widget.createWidget(10, 10, 100, 50,0);
        assertTrue(tempWidget.getIndex() == 2);
        assertTrue(widget.widgetList.size() == 2 );

        widget.deleteWidget((tempWidget.getId()));
        assertTrue(widget.widgetList.size() == 1 );
    }

    @Test
    public void testUpdateWidget(){
        Widget tempWidget = widget.createWidget(100, 50, 100, 50, 2);

        UUID id = tempWidget.getId();
        Date dateTemp = tempWidget.getDate();
        Widget updWidget = widget.createWidget(1,1,1,1,1);

        widget.updateWidget((tempWidget.getId()), updWidget);
        assertTrue(updWidget.getId() == id);
        assertTrue(updWidget.getDate() != dateTemp);
        assertTrue(updWidget.getX() == 1);
    }

    @Test
    public void testDeleteWidget(){
        Widget tempWidget = widget.createWidget(0, 0, 10,10, 2);

        widget.deleteWidget((tempWidget.getId()));
        assertFalse(widget.widgetList.contains(tempWidget));
    }

    @Test
    public void testGetWidget(){
        Widget tempWidget = widget.createWidget(0, 0, 10,10, 2);

        Widget getWidget = widget.getWidget(tempWidget.getId());
        assertTrue(getWidget != null );

        widget.deleteWidget((tempWidget.getId()));
    }

    @Test
    public void testGetAllWidgets(){
        widget.createWidget(0, 0, 100, 50, 2);
        widget.createWidget(0, 0, 200, 250, 2);
        widget.createWidget(50, 50, 50, 50, 0);
        widget.createWidget(0, 0, 10, 50, 0);
        widget.createWidget(0, 0, 200, 250, 2);
        widget.getAllWidgets();
        List<Widget> sortedList = widget.getAllWidgets();

        // Check if sorting work
        for(int i = 0; i < sortedList.size()-1; i++) {
            assertTrue(sortedList.get(i).getIndex()<sortedList.get(i+1).getIndex());
        }
    }
}