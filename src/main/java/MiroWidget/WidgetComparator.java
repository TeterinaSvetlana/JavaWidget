package MiroWidget;

import MiroWidget.enities.Widget;

import java.util.Comparator;

public class WidgetComparator implements Comparator<Widget> {
    @Override
    public int compare(Widget o1, Widget o2) {
        // Два объекта null считаются равными.
        if (o1 == null && o2 == null) {
            return 0;
        }
        // Если o1 является null, считается что o2 больше
        if (o1 == null) {
            return -1;
        }
        // Если o2 является null, считается что o1 больше.
        if (o2 == null) {
            return 1;
        }
        // Правило:
        // Распределить по возрастанию индекса.
        int value = o1.getIndex() - o2.getIndex();
        if (value != 0) {
            return value;
        }
        return value;
    }
}
