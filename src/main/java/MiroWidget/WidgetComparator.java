package MiroWidget;

import MiroWidget.enities.Widget;

import java.util.Comparator;

public class WidgetComparator implements Comparator<Widget> {
    @Override
    public int compare(Widget o1, Widget o2) {
        // Null objects are considered to be equal.
        if (o1 == null && o2 == null) {
            return 0;
        }
        // If o1 is null, o2 is considered to be bigger.
        if (o1 == null) {
            return -1;
        }
        // If o2 is null, o1 is considered to be bigger.
        if (o2 == null) {
            return 1;
        }
        // Rule:
        // Distribute in ascending order of index.
        int value = o1.getIndex() - o2.getIndex();
        if (value != 0) {
            return value;
        }
        return value;
    }
}
