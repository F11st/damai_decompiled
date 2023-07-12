package cn.damai.tetris.component.drama.bean;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.cb2;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class FilterBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public CategoryItemListInfo itemInfo;
    public int pos;
    public List<FilterMainBean> tabs;
    public String title;
    public int mTagPanelScrollX = 0;
    private FilterDateBean mDateBean = FilterDateBean.defaultDateBean();

    private FilterMainBean getSelectMainTab() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2105494827")) {
            return (FilterMainBean) ipChange.ipc$dispatch("2105494827", new Object[]{this});
        }
        if (cb2.d(this.tabs)) {
            return null;
        }
        for (FilterMainBean filterMainBean : this.tabs) {
            if (filterMainBean.isSelected) {
                return filterMainBean;
            }
        }
        return null;
    }

    public static FilterBean parseBeanWithDefaultSelect(JSONObject jSONObject) {
        List<FilterMainBean> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1810210988")) {
            return (FilterBean) ipChange.ipc$dispatch("-1810210988", new Object[]{jSONObject});
        }
        try {
            FilterBean filterBean = (FilterBean) m61.d(jSONObject, FilterBean.class);
            if (filterBean != null && (list = filterBean.tabs) != null && list.size() > 0) {
                filterBean.setSelectTab(list.get(0));
            }
            return filterBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean changedFilterDate(FilterDateBean filterDateBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-67243068")) {
            return ((Boolean) ipChange.ipc$dispatch("-67243068", new Object[]{this, filterDateBean})).booleanValue();
        }
        if (filterDateBean == null || this.mDateBean.equals(filterDateBean)) {
            return false;
        }
        this.mDateBean = filterDateBean;
        return true;
    }

    public void clearSelect(FilterMainBean filterMainBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1548401052")) {
            ipChange.ipc$dispatch("-1548401052", new Object[]{this, filterMainBean});
        } else if (filterMainBean != null) {
            filterMainBean.isSelected = false;
            List<FilterTagBean> list = filterMainBean.labels;
            if (cb2.d(list)) {
                return;
            }
            for (FilterTagBean filterTagBean : list) {
                filterTagBean.isSelected = false;
            }
        }
    }

    public String getCalendarText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "939185062")) {
            return (String) ipChange.ipc$dispatch("939185062", new Object[]{this});
        }
        FilterDateBean filterDateBean = this.mDateBean;
        if (filterDateBean != null) {
            return filterDateBean.calendarText;
        }
        return null;
    }

    public CategoryQuery getQuery() {
        String str;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1261961160")) {
            return (CategoryQuery) ipChange.ipc$dispatch("1261961160", new Object[]{this});
        }
        FilterMainBean selectMainTab = getSelectMainTab();
        if (selectMainTab != null) {
            int i2 = selectMainTab.id;
            FilterTagBean selectTag = getSelectTag(selectMainTab);
            str = selectTag != null ? selectTag.groupId : null;
            i = i2;
        } else {
            str = null;
            i = 0;
        }
        FilterDateBean filterDateBean = this.mDateBean;
        return new CategoryQuery(i, str, filterDateBean.dateType, filterDateBean.startDate, filterDateBean.endDate, filterDateBean.index);
    }

    public FilterTagBean getSelectTag(FilterMainBean filterMainBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1994189042")) {
            return (FilterTagBean) ipChange.ipc$dispatch("-1994189042", new Object[]{this, filterMainBean});
        }
        if (filterMainBean == null || cb2.d(filterMainBean.labels)) {
            return null;
        }
        for (FilterTagBean filterTagBean : filterMainBean.labels) {
            if (filterTagBean.isSelected) {
                return filterTagBean;
            }
        }
        return null;
    }

    public void setSelectTab(FilterMainBean filterMainBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1240883202")) {
            ipChange.ipc$dispatch("-1240883202", new Object[]{this, filterMainBean});
        } else if (filterMainBean != null && !cb2.d(this.tabs)) {
            for (FilterMainBean filterMainBean2 : this.tabs) {
                if (filterMainBean2.equals(filterMainBean)) {
                    filterMainBean.isSelected = true;
                    List<FilterTagBean> list = filterMainBean.labels;
                    if (!cb2.d(list)) {
                        for (int i = 0; i < list.size(); i++) {
                            FilterTagBean filterTagBean = list.get(i);
                            if (i == 0) {
                                filterTagBean.isSelected = true;
                            } else {
                                filterTagBean.isSelected = false;
                            }
                        }
                    }
                } else {
                    clearSelect(filterMainBean2);
                }
            }
        }
    }

    public void setSelectTag(FilterTagBean filterTagBean) {
        FilterMainBean selectMainTab;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1345544122")) {
            ipChange.ipc$dispatch("1345544122", new Object[]{this, filterTagBean});
        } else if (filterTagBean != null && (selectMainTab = getSelectMainTab()) != null) {
            List<FilterTagBean> list = selectMainTab.labels;
            if (cb2.d(list)) {
                return;
            }
            for (FilterTagBean filterTagBean2 : list) {
                if (filterTagBean2 == filterTagBean) {
                    filterTagBean2.isSelected = true;
                } else {
                    filterTagBean2.isSelected = false;
                }
            }
        }
    }
}
