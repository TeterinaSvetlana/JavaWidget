package MiroWidget.test;

import MiroWidget.WidgetController;
import MiroWidget.enities.Area;
import MiroWidget.enities.Widget;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(WidgetController.class)

public class TestApi {
    @Autowired
    private MockMvc mockMvc;

    private static List<Widget> widgetList = new ArrayList();

    private WidgetController widgetControler = new WidgetController();

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(widgetControler)
                .build();

        Widget widget = widgetControler.createWidget(1,1,10,10,1);

        widgetControler.create(widget);
        widgetList.add(widget);

    }

    @Test
    public void testGetAllWidgets() throws Exception {
        Widget widget = new Widget();

        widget.setDate();
        widget.setId();
        widget.setIndex(1);
        widget.setX(12346);
        widget.setY(1);
        widget.setHight(10);
        widget.setWidth(10);

        widgetControler.create(widget);

        mockMvc.perform(MockMvcRequestBuilders.get("/widgets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].x", Matchers.is(12346)));
    }

    @Test
    public void getWidgetById() throws Exception
    {
        UUID id = widgetList.get(0).getId();
        mockMvc.perform( MockMvcRequestBuilders
                .get("/widgets/{id}", id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(String.valueOf(id)));
    }

    @Test
    public void testCreateWidget() throws Exception {
         Date date = new Date();
         UUID id = UUID.randomUUID();

        mockMvc.perform( MockMvcRequestBuilders
                .post("/widgets")
                .content(asJsonString(new Widget(2,2,2,2,2,date, id)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.x").exists());
    }

    @Test
    public void updateWidget() throws Exception {
        UUID id = widgetList.get(0).getId();
        mockMvc.perform( MockMvcRequestBuilders
                .put("/widgets/{id}", id)
                .content(asJsonString(new Widget(5,5,5,5,5)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("x").value("5"))
                .andExpect(MockMvcResultMatchers.jsonPath("y").value("5"))
                .andExpect(MockMvcResultMatchers.jsonPath("width").value("5"));
    }

    @Test
    public void deleteEmployeeAPI() throws Exception {
        UUID id = widgetList.get(0).getId();
        mockMvc.perform( MockMvcRequestBuilders.delete("/widgets/{id}", id) )
                .andExpect(status().isOk());
    }

    @Test
    public void tesGetWidgetsInArea() throws Exception {
        // Create area and new widgets.
        mockMvc.perform( MockMvcRequestBuilders
                .post("/widgets/area")
                .content(asJsonString(new Area(100, 100, 200, 250)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.x1").exists());

        mockMvc.perform( MockMvcRequestBuilders
                .post("/widgets")
                .content(asJsonString(new Widget(150, 150, 100, 100, 0)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform( MockMvcRequestBuilders
                .post("/widgets")
                .content(asJsonString(new Widget(150, 200, 100, 100, 0)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform( MockMvcRequestBuilders
                .post("/widgets")
                .content(asJsonString(new Widget(200, 200, 100, 100, 0)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Check if rule is working.
        mockMvc.perform(MockMvcRequestBuilders.get("/widgets/area"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
