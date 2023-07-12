package cn.damai.category.common.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CalendarMonthBean implements Serializable {
    private static final long serialVersionUID = -6648808176618931536L;
    public List<CalendarDayBean> days;
    public String desc;
    public int month;
}
