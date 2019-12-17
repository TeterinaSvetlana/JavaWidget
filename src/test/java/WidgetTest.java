import MiroWidget.Main;
import MiroWidget.WidgetController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class WidgetTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

    WidgetController widget = context.getBean ("manageWidget", WidgetController.class);

    @Test
    public void testCreateWidget(){
//        widget.createWidget(100, 50,1,1, 2);
//        Widget tempWidget = widget.widgetList.get(0);
//        assertTrue((tempWidget.getWidth() == 100)&&(tempWidget.getHight() == 50)&&(tempWidget.getIndex() == 2)&&(tempWidget.getId() != null)&&(tempWidget.getDate() != null));
//        assertTrue(widget.widgetList.size() != 0 );
//
//        widget.deleteWidget((tempWidget.getId()));
//
//        widget.createWidget(100, 50);
//        tempWidget = widget.widgetList.get(0);
//        assertTrue((tempWidget.getWidth() == 100)&&(tempWidget.getHight() == 50)&&(tempWidget.getIndex() == 1)&&(tempWidget.getId() != null)&&(tempWidget.getDate() != null));
//        assertTrue(widget.widgetList.size() != 0 );
//
//        widget.deleteWidget((tempWidget.getId()));
    }

    @Test
    public void testUpdateWidget(){
//        widget.createWidget(100, 50,1,1, 2);
//        Widget tempWidget = widget.widgetList.get(0);
//
//        Date dateTemp = tempWidget.getDate();
//        widget.updateWidget((tempWidget.getId()), 1, 1,1,1, 1);
//        assertTrue((tempWidget.getWidth() == 1)&&(tempWidget.getHight() == 1)&&(tempWidget.getIndex() == 1)&&(tempWidget.getId() != null)&&(tempWidget.getDate() != dateTemp));
//
//        widget.deleteWidget((tempWidget.getId()));
    }

    @Test
    public void testDeleteWidget(){
//        widget.createWidget(100, 50, 2);
//        Widget tempWidget = widget.widgetList.get(0);
//
//
//        widget.deleteWidget((tempWidget.getId()));
//        assertFalse(widget.widgetList.contains(tempWidget));
    }

    @Test
    public void testGetWidget(){
//        widget.createWidget(100, 50, 2);
//        Widget tempWidget = widget.widgetList.get(0);
//
//        Widget getWidget = widget.getWidget(tempWidget.getId());
//        assertTrue(getWidget != null );
//
//        widget.deleteWidget((tempWidget.getId()));
    }

    @Test
    public void testGetAllWidgets(){
//        widget.createWidget(100, 50, 2);
//        widget.createWidget(200, 250, 2);
//        widget.createWidget(50, 50);
//        widget.createWidget(10, 50);
//        widget.createWidget(200, 250, 2);
//        widget.getAllWidgets();
//        List<Widget> sortedList = widget.getAllWidgets();
//
//        for(int i = 0; i < sortedList.size()-1; i++) {
//            assertTrue(sortedList.get(i).getIndex()<sortedList.get(i+1).getIndex());
//        }
    }
}