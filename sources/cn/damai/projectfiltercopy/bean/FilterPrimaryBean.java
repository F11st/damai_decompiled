package cn.damai.projectfiltercopy.bean;

import cn.damai.commonbusiness.calendarcopy.bean.CalendarYearBean;
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
