package MiroWidget;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component ;

@Component
public class ManageWidget {

    @Autowired
    public static List<Widget> widgetList = new ArrayList();

    public void createWidget(int x, int y, int z){
        Widget widget = new Widget();
        widget.setId();
        widget.setDate();
        widget.setIndex(z);
        widget.setHight(y);
        widget.setWidth(x);

        widgetList.add(widget);

        for (Widget w : widgetList) {
            if (z <= w.getIndex() && widget.id != w.id) {
                w.z++;
            }
        }
    }

    public void createWidget(int x, int y){
        //Date date = new Date();
        Widget widget = new Widget();
        widget.setId();
        widget.setDate();
        widget.setHight(y);
        widget.setWidth(x);
        int z = 0;
        for (Widget w : widgetList) {
            if (z <= w.getIndex()) {
               z = w.getIndex();
            }
        }
        z++;
        widget.setIndex(z);
        widgetList.add(widget);
    }

    public Widget getWidget(UUID id){
        for(Widget widget: widgetList){
            if(widget.getId() == id){
                return widget;
            }
        }
        return null;
    }

    public synchronized void updateWidget(UUID id, int x, int y, int z){
        Widget widget = getWidget(id);

        widget.setWidth(x);
        widget.setHight(y);
        widget.setIndex(z);

        widget.setDate();
    }

    public List<Widget> getAllWidgets(){
        List<Widget> sortedList = new ArrayList<Widget>();
        sortedList = widgetList;
        Collections.sort(sortedList, new WidgetComparator());
        for (Widget widget : sortedList) {
            System.out.println("Id: " + widget.getId() +" Index: " + widget.getIndex() + " x " + widget.getWidth() + " y: " + widget.getHight() + " Date " + widget.getDate());
        }
        return sortedList;
    }

    public void deleteWidget(UUID id){
        for (Widget w : widgetList)
        {
            if (w.getId() == id)
            {
                int index = widgetList.indexOf(w);
                widgetList.remove(index);
                break;
            }
        }
    }
}
