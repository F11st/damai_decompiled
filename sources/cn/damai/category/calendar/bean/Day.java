package cn.damai.category.calendar.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Day implements Serializable {
    private static final long serialVersionUID = 5156852305176208854L;
    public int day;
    public int month;
    public String project;
    public String projectId;
    public String projectName;
    public int selectType = 0;
    public int showType = 0;
    public String tag;
    public int year;

    public Day() {
    }

    public Day(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.day = i3;
    }
}
