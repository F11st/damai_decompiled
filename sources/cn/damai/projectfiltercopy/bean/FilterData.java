package cn.damai.projectfiltercopy.bean;

import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class FilterData {
    public CalendarBean calendarBean;
    public boolean isHorCalendarShouldScroll2AdjustPos = true;
    public CityBean mCityBean;
    public HashMap<String, List<FilterBean>> mFilterMap;
    public List<CategoryLevelOne> mNewCategorySelected;
    public SortBean mSortBean;
    public List<CategoryBean> selected;

    public FilterData() {
    }

    public FilterData(SortBean sortBean) {
        this.mSortBean = sortBean;
    }

    public FilterData(List<CategoryBean> list) {
        this.selected = list;
    }
}
