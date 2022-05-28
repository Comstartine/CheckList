package com.example.checklist.logic.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "label")
public class Label {

    @PrimaryKey(autoGenerate = true)
    private long label_id = 0;  //标签id
    private String label_name;  //标签名
    private String label_color; //标签颜色


    public Label(String label_name, String label_color) {
        this.label_name = label_name;
        this.label_color = label_color;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
    }

    public String getLabel_color() {
        return label_color;
    }

    public void setLabel_color(String label_color) {
        this.label_color = label_color;
    }

    @Override
    public String toString() {
        return "Label{" +
                "label_id=" + label_id +
                ", label_name='" + label_name + '\'' +
                ", label_color='" + label_color + '\'' +
                '}';
    }
}
