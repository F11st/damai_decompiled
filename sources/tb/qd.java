package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.projectfiltercopy.bean.CategoryLevelOne;
import cn.damai.projectfiltercopy.bean.CategoryLevelTwo;
import cn.damai.projectfiltercopy.bean.CityBean;
import cn.damai.projectfiltercopy.bean.FilterBean;
import cn.damai.projectfiltercopy.bean.SortBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class qd {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    public boolean b;

    public qd(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public static qd a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-793267288")) {
            return (qd) ipChange.ipc$dispatch("-793267288", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            str = "品类";
        }
        return new qd(str, !TextUtils.equals("品类", str));
    }

    public static qd b(CityBean cityBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1723125068")) {
            return (qd) ipChange.ipc$dispatch("1723125068", new Object[]{cityBean});
        }
        if (cityBean == null) {
            cityBean = CityBean.defaultCity();
        }
        return new qd(cityBean.cityName, !TextUtils.equals(cityBean.cityCode, gm.INSTANCE.a().getCityId()));
    }

    public static qd c(CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189698995")) {
            return (qd) ipChange.ipc$dispatch("1189698995", new Object[]{calendarBean});
        }
        if (calendarBean == null) {
            return new qd("全部时间", false);
        }
        boolean equals = calendarBean.equals(CalendarBean.defaultAllTime());
        return new qd(equals ? "全部时间" : calendarBean.name, !equals);
    }

    public static qd d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-967212033") ? (qd) ipChange.ipc$dispatch("-967212033", new Object[0]) : new qd("默认", false);
    }

    public static qd e(HashMap<String, List<FilterBean>> hashMap, List<String> list) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1786641502")) {
            return (qd) ipChange.ipc$dispatch("1786641502", new Object[]{hashMap, list});
        }
        if (!bb2.d(list) && !bb2.e(hashMap)) {
            for (String str : hashMap.keySet()) {
                if (!bb2.d(hashMap.get(str)) && list.contains(str)) {
                    break;
                }
            }
        }
        z = false;
        return new qd("筛选", z);
    }

    @NotNull
    public static String g(@Nullable List<CategoryLevelOne> list, @Nullable List<CategoryLevelOne> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1635504926")) {
            return (String) ipChange.ipc$dispatch("1635504926", new Object[]{list, list2});
        }
        if (!bb2.d(list) && !bb2.d(list2)) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (CategoryLevelOne categoryLevelOne : list) {
                int indexOf = list2.indexOf(categoryLevelOne);
                if (indexOf >= 0 && !bb2.d(categoryLevelOne.lineItemList)) {
                    CategoryLevelOne categoryLevelOne2 = list2.get(indexOf);
                    if (!bb2.d(categoryLevelOne2.lineItemList)) {
                        if (categoryLevelOne2.lineItemList.get(0).isAll()) {
                            if (categoryLevelOne.lineItemList.size() == 1) {
                                sb.append(categoryLevelOne.name);
                                sb.append(",");
                                i++;
                            } else {
                                for (CategoryLevelTwo categoryLevelTwo : categoryLevelOne.lineItemList) {
                                    if (!categoryLevelTwo.isAll()) {
                                        sb.append(categoryLevelTwo.name);
                                        sb.append(",");
                                        i++;
                                    }
                                }
                            }
                        } else {
                            for (CategoryLevelTwo categoryLevelTwo2 : categoryLevelOne.lineItemList) {
                                if (categoryLevelOne2.lineItemList.contains(categoryLevelTwo2)) {
                                    sb.append(categoryLevelTwo2.name);
                                    sb.append(",");
                                    i++;
                                }
                            }
                        }
                    }
                }
            }
            if (sb.length() >= 1) {
                sb.deleteCharAt(sb.length() - 1);
                if (i > 2) {
                    sb.append("等");
                    sb.append(i);
                    sb.append("类");
                }
                return sb.toString();
            }
        }
        return "品类";
    }

    public static qd h(SortBean sortBean, List<SortBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-104294623")) {
            return (qd) ipChange.ipc$dispatch("-104294623", new Object[]{sortBean, list});
        }
        if (sortBean != null && !bb2.d(list)) {
            return new qd(sortBean.name, list.indexOf(sortBean) != 0);
        }
        return new qd("默认", false);
    }

    public String f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1820084515")) {
            return (String) ipChange.ipc$dispatch("1820084515", new Object[]{this});
        }
        String str = this.a;
        return str == null ? "默认" : str;
    }
}
