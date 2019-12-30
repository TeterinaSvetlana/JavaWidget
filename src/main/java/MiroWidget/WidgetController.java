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
@RequestMapping("/widgets")
public class WidgetController {

    public static List<Widget> widgetList = new ArrayList(); // List with all widgets.

    @Autowired
    public static List<Widget> selectedWidgets = new ArrayList(); // List with widgets, intersecting the area.
    public Area area;
    boolean areaChanged = false;

    public Widget createWidget(int x, int y, int width, int hight, int z){
        Widget widget = new Widget();
        widget.setId();
        widget.setDate();
        widget.setIndex(z);
        widget.setY(y);
        widget.setX(x);
        widget.setHight(hight);
        widget.setWidth(width);

        checkIndex(z, widget);

        widgetList.add(widget);
        Collections.sort(widgetList, new WidgetComparator());

        return widget;
    }

    // Sets right index.
    public void checkIndex(int z, Widget widget) {
        if (z > 0) {
            int i = 0;
            for (Widget w : widgetList) {
                if (widget.getId() != w.getId()) {
                    if (z == w.getIndex()) {
                        i++;
                    }
                    w.setIndex(w.getIndex() + i);
                }
            }
        }

        if (z == 0) {
            if (widgetList.size() >= 1) {
                z = widgetList.get(widgetList.size() - 1).getIndex() + 1;
            }
            else {
                z = 1;
            }
            widget.setIndex(z);
        }
    }

    @PostMapping
    public Widget create(@RequestBody Widget widget) {
        widget.setId();
        widget.setDate();

        int z = widget.getIndex();

        checkIndex(z, widget);

        widgetList.add(widget);

        Collections.sort(widgetList, new WidgetComparator());

        return widget;
    }

    @GetMapping("/{id}")
    public Widget getOneWidget(@PathVariable UUID id){
        return getWidget(id);
    }

    public Widget getWidget(@PathVariable UUID id){
        return widgetList.stream()
                .filter(widget -> widget.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PutMapping("/{id}")
    public synchronized Widget updateWidget(@PathVariable UUID id, @RequestBody Widget widget) {
        deleteWidget(id);
        create(widget);
        widget.setExistingId(id);
        Collections.sort(widgetList, new WidgetComparator());

        return widget;
    }

    @GetMapping
    public static List<Widget> getAllWidgets(){
        return widgetList;
    }

    @DeleteMapping("/{id}")
    public void deleteWidget(@PathVariable UUID id){
        Widget widget = getWidget(id);
        widgetList.remove(widget);
        Collections.sort(widgetList, new WidgetComparator());
    }

    @GetMapping("/area")
    public List<Widget> getWidgetsInArea(){
        if (area != null) {
            int x1 = area.getX1();
            int y1 = area.getY1();
            int x2 = area.getX2();
            int y2 = area.getY2();

            // If area has been changed, pick up widgets for it.
            if (areaChanged) {
                for (Widget w : widgetList) {//
                    if ((intersectX(w.getX(), w.getWidth(), x1, x2) == true) && (intersectY(w.getY(), w.getHight(), y1, y2) == true)) {
                        selectedWidgets.add(w);
                    }
                }
            }
        }

        List<Widget> widgetsInArea = new ArrayList<Widget>();
        widgetsInArea = selectedWidgets;
        Collections.sort(widgetsInArea, new WidgetComparator());
        areaChanged = false;

        return widgetsInArea;
    }

    // Checks if current widget intersects chosen area's x coordinate.
    private boolean intersectX(int x, int width, int x1, int x2){
        if ((x>x1)&&(x<x2)) {
            return true;
        }
        if ((x<x1)&&(x+width > x1)) {
            return true;
        }

        return false;
    }

    // Checks if current widget intersects chosen area's y coordinate.
    private boolean intersectY(int y, int hight, int y1, int y2){
        if ((y>y1)&&(y<y2)) {
            return true;
        }
        if ((y<y1)&&(y+hight > y1)) {
            return true;
        }

        return false;
    }

    @PostMapping("/area")
    public Area createArea(@RequestBody Area newArea) {
        area = newArea;
        areaChanged = true;
        return newArea;
    }

}
