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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

//    @Mock
//    private Widget widget;

//    @InjectMocks
    private static List<Widget> widgetList = new ArrayList();

//    @Mock
    private WidgetController widgetControler = new WidgetController();

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(widgetControler)
                .build();


    }



    @Test
    public void testHelloWorld() throws Exception {
        Widget widget = new Widget();
//        widget = new Widget();
        widget.setDate();
        widget.setId();
        widget.setIndex(1);
        widget.setX(12346);
        widget.setY(1);
        widget.setHight(10);
        widget.setWidth(10);

//        List<Widget> widgetList = new ArrayList<Widget>();
//        widgetList.add(widget);
        
        widgetControler.create(widget);

//        when(widgetControler.create(widget)).thenReturn(widget);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/widgets"))
                .andExpect(status().isOk())
                .andExpect(content().string("[{ x: 2, y: 1, width: 1, hight: 1, index: 1 }]"))
                .andReturn();
        System.out.println(mvcResult.getResponse());
//                .andExpect(content().string("[{ x: 2, y: 1, width: 1, hight: 1, index: 1 }]"));

//        verify(widgetControler).create(widget);
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
//        String json = "[{ x: 2, y: 1, width: 1, hight: 1, index: 1 }]";
        String json = "{\n" +
                "  \"x\": \"1\",\n" +
                "  \"y\": \"1\"\n" +
                "  \"width\": \"1\",\n" +
                "  \"hight\": \"1\"\n" +
                "}";
        mockMvc.perform(post("/widgets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.title", Matchers.is("Greetings")))
//                .andExpect(jsonPath("$.value", Matchers.is("Hello World")))
//                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }
}
