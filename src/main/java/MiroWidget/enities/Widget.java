package MiroWidget.enities;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component ;

@Component
public class Widget {

    private int x;
    private int y;
    private int hight;
    private int width;
    private int z;
    private Date date;
    private UUID id;

    public Widget(){}
    protected Widget(int x, int y, int hight, int width, int z, Date date, UUID id){
        this.x = x;
        this.y = y;
        this.hight = hight;
        this.width = width;
        this.z = z;
        this.date = date;
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight){
        this.hight = hight;
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

    public void setExistingId(UUID id){
        this.id = id;
    }


}

