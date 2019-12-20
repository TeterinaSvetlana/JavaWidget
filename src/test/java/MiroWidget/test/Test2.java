package MiroWidget.test;

import MiroWidget.WidgetController;
import MiroWidget.enities.Widget;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

//import static MiroWidget.WidgetController.widgetList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)

public class Test2 {
    private MockMvc mockMvc;

    @Mock
    public Widget widget;

    @Mock
    public static List<Widget> widgetList = new ArrayList<Widget>();

    @InjectMocks
    public WidgetController widgetControler;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(widgetControler)
                .build();


    }

    @Test
    public void testHelloWorld() throws Exception {
        Widget widget = new Widget();

        widget.setDate();
        widget.setId();
        widget.setIndex(1);
        widget.setX(1);
        widget.setY(1);
        widget.setHight(10);
        widget.setWidth(10);

        List<Widget> widgetList = new ArrayList<Widget>();
        widgetList.add(widget);

//        when(widget.getX()).thenReturn(1);
        mockMvc.perform(get("/widgets"))
                .andExpect(status().isOk());
                //.andExpect(content().string("hello"));

//        verify(widget).getX();
    }

    @Test
    public void testPost() throws Exception {
//        String json = "fetch(\n" +
//                "  '/widgets', \n" +
//                "  { \n" +
//                "    method: 'POST', \n" +
//                "    headers: { 'Content-Type': 'application/json' },\n" +
//                "    body: JSON.stringify({ x: 2, y: 1, width: 1, hight:1 })\n" +
//                "  }\n" +
//                ")";
        String json = "{ x: 2, y: 1, width: 1, hight:1 }";
        mockMvc.perform(post("/widgets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
//                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
//                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }
}
