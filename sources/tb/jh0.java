package tb;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.projectfiltercopy.bean.FilterBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class jh0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String LOCATION_POSTFIX = "帮助你获取所在城市的演出赛事信息、找到附近的演出赛事";
    public static final int C_FF2869 = Color.parseColor("#FF2869");
    public static final int C_333333 = Color.parseColor("#333333");
    public static final int C_5F6672 = Color.parseColor("#5F6672");
    public static final int C_C8C8C8 = Color.parseColor("#c8c8c8");
    public static final int C_999999 = Color.parseColor("#999999");
    public static final int C_A30_000000 = Color.parseColor("#4D000000");
    public static final int MARGIN_9 = k62.a(AppInfoProviderProxy.getApplication(), 9.0f);
    public static final int MARGIN_12 = k62.a(AppInfoProviderProxy.getApplication(), 12.0f);

    @NonNull
    public static List<FilterBean> a(List<FilterBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1765485083")) {
            return (List) ipChange.ipc$dispatch("1765485083", new Object[]{list});
        }
        if (bb2.d(list)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (FilterBean filterBean : list) {
            try {
                arrayList.add((FilterBean) filterBean.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static void b(List<FilterBean> list, @Nullable CalendarBean calendarBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "901983100")) {
            ipChange.ipc$dispatch("901983100", new Object[]{list, calendarBean});
            return;
        }
        for (FilterBean filterBean : list) {
            if (TextUtils.equals("dateType", filterBean.option)) {
                if (calendarBean == null) {
                    filterBean.isSelected = false;
                } else if (calendarBean.dateType != null && TextUtils.isEmpty(calendarBean.startDate) && TextUtils.isEmpty(calendarBean.endDate)) {
                    filterBean.isSelected = TextUtils.equals(calendarBean.dateType, filterBean.value);
                } else {
                    filterBean.isSelected = false;
                }
            }
        }
    }

    public static void c(List<FilterBean> list, HashMap<String, List<FilterBean>> hashMap, List<String> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1648656071")) {
            ipChange.ipc$dispatch("1648656071", new Object[]{list, hashMap, list2});
            return;
        }
        for (FilterBean filterBean : list) {
            if (list2.contains(filterBean.option)) {
                if (bb2.e(hashMap)) {
                    filterBean.isSelected = false;
                } else {
                    List<FilterBean> list3 = hashMap.get(filterBean.option);
                    if (bb2.d(list3)) {
                        filterBean.isSelected = false;
                    } else {
                        filterBean.isSelected = list3.contains(filterBean);
                    }
                }
            }
        }
    }

    public static void d(List<FilterBean> list, @Nullable FilterBean filterBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "459378481")) {
            ipChange.ipc$dispatch("459378481", new Object[]{list, filterBean});
            return;
        }
        for (FilterBean filterBean2 : list) {
            if (TextUtils.equals("groupId", filterBean2.option)) {
                if (filterBean == null) {
                    filterBean2.isSelected = false;
                } else {
                    filterBean2.isSelected = TextUtils.equals(filterBean2.value, filterBean.value);
                }
            }
        }
    }

    public static void e(FilterBean filterBean, HashMap<String, List<FilterBean>> hashMap, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "296862695")) {
            ipChange.ipc$dispatch("296862695", new Object[]{filterBean, hashMap, Boolean.valueOf(z)});
            return;
        }
        String str = filterBean.option;
        List<FilterBean> list = hashMap.get(str);
        if (filterBean.isSelected) {
            if (bb2.d(list)) {
                return;
            }
            list.remove(filterBean);
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
            hashMap.put(str, list);
        }
        if (z) {
            list.clear();
        }
        list.add(filterBean);
    }
}
