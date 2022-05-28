package com.example.checklist.logic.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "files")
public class Files {

    @PrimaryKey(autoGenerate = true)
    private long file_id = 0;  //文件id
    private String file_name;   //文件名
    private String file_datetime;     //文件上传时间
    private String file_url;        //文件所处位置
    private String file_taskId;     //文件所属日程id

    public Files(String file_name, String file_datetime, String file_url, String file_taskId) {
        this.file_name = file_name;
        this.file_datetime = file_datetime;
        this.file_url = file_url;
        this.file_taskId = file_taskId;
    }

    public long getFile_id() {
        return file_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_datetime() {
        return file_datetime;
    }

    public void setFile_datetime(String file_datetime) {
        this.file_datetime = file_datetime;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getFile_taskId() {
        return file_taskId;
    }

    public void setFile_taskId(String file_taskId) {
        this.file_taskId = file_taskId;
    }


    @Override
    public String toString() {
        return "Files{" +
                "file_id=" + file_id +
                ", file_name='" + file_name + '\'' +
                ", file_datetime='" + file_datetime + '\'' +
                ", file_url='" + file_url + '\'' +
                ", file_taskId='" + file_taskId + '\'' +
                '}';
    }
}
