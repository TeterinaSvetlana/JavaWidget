package MiroWidget.test;

import MiroWidget.Main;
import MiroWidget.WidgetController;
import MiroWidget.enities.Widget;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static MiroWidget.WidgetController.widgetList;


//@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)

@WebMvcTest(WidgetController.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestWidgetController {

//    ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
//
//    WidgetController widget = context.getBean ("manageWidget", WidgetController.class);

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WidgetController widgetController;

    @Test
    public void getArrivals() throws Exception {
        Widget widget = new Widget();
        widget.setDate();
        widget.setId();
        widget.setIndex(1);
        widget.setX(1);
        widget.setY(1);
        widget.setHight(10);
        widget.setWidth(10);
//        arrival.setCity("Yerevan");
        widgetList.add(widget);
//        List<Widget> allWidgets = singletonList(widget);
//        given(WidgetController.getAllWidgets()).willReturn(widgetList);
        mvc.perform(get("widgets")
//                .with(user("blaze").password("Q1w2e3r4"))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].x", is(widget.getX())));
    }

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