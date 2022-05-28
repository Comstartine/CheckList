package com.example.checklist.logic.entity;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "list_task",primaryKeys = {"list_task_taskId","list_task_listId"})
public class ListTask {
    private Long list_task_taskId;  //日程id
    private Long list_task_listId;  //清单id

    public ListTask(Long list_task_taskId, Long list_task_listId) {
        this.list_task_taskId = list_task_taskId;
        this.list_task_listId = list_task_listId;
    }

    public Long getList_task_taskId() {
        return list_task_taskId;
    }

    public void setList_task_taskId(Long list_task_taskId) {
        this.list_task_taskId = list_task_taskId;
    }

    public Long getList_task_listId() {
        return list_task_listId;
    }

    public void setList_task_listId(Long list_task_listId) {
        this.list_task_listId = list_task_listId;
    }

    @Override
    public String toString() {
        return "ListTask{" +
                "list_task_taskId=" + list_task_taskId +
                ", list_task_listId=" + list_task_listId +
                '}';
    }
}
