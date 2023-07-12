package cn.damai.projectfiltercopy.bean;

import cn.damai.commonbusiness.calendarcopy.bean.CalendarEntity;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarYearBean;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CalendarInitBean implements Serializable {
    public final List<CalendarEntity> mCalendarEntityList;
    public final List<CalendarYearBean> mYearBeanList;

    public CalendarInitBean(List<CalendarYearBean> list, List<CalendarEntity> list2) {
        this.mYearBeanList = list;
        this.mCalendarEntityList = list2;
    }
}
