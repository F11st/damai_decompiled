package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.projectfilter.bean.CategoryBean;
import cn.damai.projectfilter.bean.CategoryLevelOne;
import cn.damai.projectfilter.bean.CategoryLevelTwo;
import cn.damai.projectfilter.bean.CityBean;
import cn.damai.projectfilter.bean.FilterBean;
import cn.damai.projectfilter.bean.SortBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class rd {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    public boolean b;

    public rd(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public static rd a(List<CategoryBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815357327")) {
            return (rd) ipChange.ipc$dispatch("-815357327", new Object[]{list});
        }
        if (cb2.d(list)) {
            return new rd("品类", false);
        }
        StringBuilder sb = new StringBuilder();
        for (CategoryBean categoryBean : list) {
            sb.append(",");
            sb.append(categoryBean.name);
        }
        sb.deleteCharAt(0);
        return new rd(sb.toString(), true);
    }

    public static rd b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798231688")) {
            return (rd) ipChange.ipc$dispatch("1798231688", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            str = "品类";
        }
        return new rd(str, !TextUtils.equals("品类", str));
    }

    public static rd c(CityBean cityBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139028801")) {
            return (rd) ipChange.ipc$dispatch("2139028801", new Object[]{cityBean});
        }
        if (cityBean == null) {
            cityBean = CityBean.defaultCity();
        }
        return new rd(cityBean.cityName, !TextUtils.equals(cityBean.cityCode, z20.c()));
    }

    public static rd d(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "111738088")) {
            return (rd) ipChange.ipc$dispatch("111738088", new Object[]{calendarBean});
        }
        if (calendarBean == null) {
            return new rd("全部时间", false);
        }
        boolean equals = calendarBean.equals(CalendarBean.defaultAllTime());
        return new rd(equals ? "全部时间" : calendarBean.name, !equals);
    }

    public static rd e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-70748385") ? (rd) ipChange.ipc$dispatch("-70748385", new Object[0]) : new rd("默认", false);
    }

    public static rd f(HashMap<String, List<FilterBean>> hashMap, List<String> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1271321022")) {
            return (rd) ipChange.ipc$dispatch("1271321022", new Object[]{hashMap, list});
        }
        if (!cb2.d(list) && !cb2.f(hashMap)) {
            for (String str : hashMap.keySet()) {
                if (!cb2.d(hashMap.get(str)) && list.contains(str)) {
                    break;
                }
            }
        }
        z = false;
        return new rd("筛选", z);
    }

    @NotNull
    public static String h(@Nullable List<CategoryLevelOne> list, @Nullable List<CategoryLevelOne> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1735640397")) {
            return (String) ipChange.ipc$dispatch("-1735640397", new Object[]{list, list2});
        }
        if (!cb2.d(list) && !cb2.d(list2)) {
            StringBuilder sb = new StringBuilder();
            for (CategoryLevelOne categoryLevelOne : list) {
                int indexOf = list2.indexOf(categoryLevelOne);
                if (indexOf >= 0 && !cb2.d(categoryLevelOne.lineItemList)) {
                    CategoryLevelOne categoryLevelOne2 = list2.get(indexOf);
                    if (!cb2.d(categoryLevelOne2.lineItemList)) {
                        if (categoryLevelOne2.lineItemList.get(0).isAll()) {
                            if (categoryLevelOne.lineItemList.size() == 1) {
                                sb.append(categoryLevelOne.name);
                                sb.append(",");
                            } else {
                                for (CategoryLevelTwo categoryLevelTwo : categoryLevelOne.lineItemList) {
                                    if (!categoryLevelTwo.isAll()) {
                                        sb.append(categoryLevelTwo.name);
                                        sb.append(",");
                                    }
                                }
                            }
                        } else {
                            for (CategoryLevelTwo categoryLevelTwo2 : categoryLevelOne.lineItemList) {
                                if (categoryLevelOne2.lineItemList.contains(categoryLevelTwo2)) {
                                    sb.append(categoryLevelTwo2.name);
                                    sb.append(",");
                                }
                            }
                        }
                    }
                }
                if (sb.length() >= 12) {
                    break;
                }
            }
            if (sb.length() >= 1) {
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
        }
        return "品类";
    }

    public static rd i(SortBean sortBean, List<SortBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "808921878")) {
            return (rd) ipChange.ipc$dispatch("808921878", new Object[]{sortBean, list});
        }
        if (sortBean != null && !cb2.d(list)) {
            return new rd(sortBean.name, list.indexOf(sortBean) != 0);
        }
        return new rd("默认", false);
    }

    public String g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46945864")) {
            return (String) ipChange.ipc$dispatch("-46945864", new Object[]{this});
        }
        String str = this.a;
        return str == null ? "默认" : str;
    }
}
