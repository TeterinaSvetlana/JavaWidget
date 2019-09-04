package MiroWidget;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component ;

@Component
public class Widget {

    public int x; // ширина
    public int y; // высота
    public int z; // индекс
    public Date date;
    public UUID id;

    public Widget(){}
    protected Widget(int x, int y, int z, Date date, UUID id){
        this.x = x;
        this.y = y;
        this.z = z;
        this.date = date;
        this.id = id;
    }

    public int getWidth() {
        return x;
    }

    public void setWidth(int x){
        this.x = x;
    }

    public int getHight() {
        return y;
    }

    public void setHight(int y){
        this.y = y;
    }

    public int getIndex() {
        return z;
    }

    public void setIndex(int z){
        this.z = z;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(){
        this.date = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(){
        this.id = UUID.randomUUID();
    }


}

