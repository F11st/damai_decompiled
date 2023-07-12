package cn.damai.projectfilter.bean;

import cn.damai.commonbusiness.calendar.bean.CalendarYearBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class FilterPrimaryBean implements Serializable {
    public List<CalendarYearBean> calendar;
    public boolean city;
    public List<CategoryLevelOne> guideCategory;
    public List<FilterGroupBean> selection;
    public List<SortBean> sortType;
}
