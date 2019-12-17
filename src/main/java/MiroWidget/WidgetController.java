package MiroWidget;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.*;

import MiroWidget.enities.Area;
import MiroWidget.enities.Widget;
import MiroWidget.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("widgets")
public class WidgetController {

    @Autowired
    public static List<Widget> widgetList = new ArrayList();

    @Autowired
    public static List<Widget> selectedWidgets = new ArrayList();
    public Area area;

//    @PostMapping
    public Widget createWidget(int x, int y, int width, int hight, int z){
        Widget widget = new Widget();
        widget.setId();
        widget.setDate();
        widget.setIndex(z);
        widget.setY(y);
        widget.setX(x);
        widget.setHight(hight);
        widget.setWidth(width);

        widgetList.add(widget);

        for (Widget w : widgetList) {
            if (z <= w.getIndex() && widget.getId() != w.getId()) {
                w.setIndex(w.getIndex()+ 1);
            }
        }

        return widget;
    }

//    @PostMapping
    public Widget createWidget(int x, int y){
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

        return widget;
    }

    @PostMapping("widgets")
    public Widget create(@RequestBody Widget widget) {
//        widget..put("id", String.valueOf(counter++));

//        widgetList.add(widget);

        widget.setId();
        widget.setDate();

        widgetList.add(widget);

        int z = widget.getIndex();

        if (z > 0) {
            int i = 0;
            for (Widget w : widgetList) {
                if (widget.getId() != w.getId()) {
                    if (z == w.getIndex()) {
//                    w.setIndex(w.getIndex()+1);
                        i++;
                    }
                    w.setIndex(w.getIndex() + i);
                }
            }
        }

        if (z == 0) {
            z = widgetList.get(widgetList.size()-2).getIndex() + 1;
//            System.out.println(widgetList.get(widgetList.size()-2).getId());
            widget.setIndex(z);
        }



        return widget;
    }

    @GetMapping("widgets/{id}")
    public Widget getOneWidget(@PathVariable UUID id){
        return getWidget(id);
//        System.out.println(id);
//        for(Widget widget: widgetList){
//            System.out.println(widget.getId());
//            if(widget.getId() == id){
//                System.out.println("not null");
//                return widget;
//            }
//        }
//        System.out.println("null");
//        return null;
    }

    public Widget getWidget(@PathVariable UUID id){
        return widgetList.stream()
                .filter(widget -> widget.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
//        System.out.println(id);
//        for(Widget widget: widgetList){
//            System.out.println(widget.getId());
//            if(widget.getId() == id){
//                System.out.println("not null");
//                return widget;
//            }
//        }
//        System.out.println("null");
//        return null;
    }

    @PutMapping("widgets/{id}")
    public synchronized Widget updateWidget(@PathVariable UUID id, @RequestBody Widget widget) {//UUID id, int x, int y, int z){
//        Widget widget = getWidget(id);
//
//        widget.setWidth(x);
//        widget.setHight(y);
//        widget.setIndex(z);

        deleteWidget(id);
        create(widget);
        widget.setExistingId(id);

//        Widget updatedWidget = getWidget(id);
//
//        updatedWidget.putAll(widget);
//        updatedWidget.put("id", id);

        return widget;
    }

    @GetMapping("widgets")
    public List<Widget> getAllWidgets(){
        List<Widget> sortedList = new ArrayList<Widget>();
        sortedList = widgetList;
        Collections.sort(sortedList, new WidgetComparator());
//        for (Widget widget : sortedList) {
//            System.out.println("Id: " + widget.getId() +" Index: " + widget.getIndex() + " x " + widget.getWidth() + " y: " + widget.getHight() + " Date " + widget.getDate());
//        }
        return sortedList;
    }

    @DeleteMapping("widgets/{id}")
    public void deleteWidget(@PathVariable UUID id){
//
        Widget widget = getWidget(id);
        widgetList.remove(widget);
    }

    @GetMapping("area")
    public List<Widget> getWidgetsInArea(){
        if (area != null) {
            int x1 = area.getX1();
            int y1 = area.getY1();
            int x2 = area.getX2();
            int y2 = area.getY2();

            for (Widget w : widgetList) {
//
                if ((intersectX(w.getX(), w.getWidth(), x1, x2) == true) && (intersectY(w.getY(), w.getHight(), y1, y2) == true)) {
                    selectedWidgets.add(w);
                }
            }
        }

        List<Widget> widgetsInArea = new ArrayList<Widget>();
        widgetsInArea = selectedWidgets;
        Collections.sort(widgetsInArea, new WidgetComparator());



        return widgetsInArea;
    }

    public boolean intersectX(int x, int width, int x1, int x2){

        if ((x>x1)&&(x<x2)) {
            return true;
        }
        if ((x<x1)&&(x+width < x2)) {
            return true;
        }

        return false;
    }

    public boolean intersectY(int y, int hight, int y1, int y2){

        if ((y>y1)&&(y<y2)) {
            return true;
        }
        if ((y<y1)&&(y+hight < y2)) {
            return true;
        }

        return false;
    }

    @PostMapping("area")
    public Area createArea(@RequestBody Area newArea) {
//        widget..put("id", String.valueOf(counter++));

//        widgetList.add(widget);

        area = newArea;


        return newArea;
    }
}
