package tb;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.projectfilter.bean.FilterBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class kh0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String LOCATION_POSTFIX = "帮助你获取所在城市的演出赛事信息、找到附近的演出赛事";
    public static final int C_FF2869 = Color.parseColor("#FF2869");
    public static final int C_333333 = Color.parseColor("#333333");
    public static final int C_5F6672 = Color.parseColor("#5F6672");
    public static final int C_C8C8C8 = Color.parseColor("#c8c8c8");
    public static final int C_999999 = Color.parseColor("#999999");
    public static final int C_A30_000000 = Color.parseColor("#4D000000");
    public static final int MARGIN_9 = m62.a(mu0.a(), 9.0f);
    public static final int MARGIN_12 = m62.a(mu0.a(), 12.0f);

    @NonNull
    public static List<FilterBean> a(List<FilterBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2107515226")) {
            return (List) ipChange.ipc$dispatch("-2107515226", new Object[]{list});
        }
        if (cb2.d(list)) {
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
        if (AndroidInstantRuntime.support(ipChange, "1230708198")) {
            ipChange.ipc$dispatch("1230708198", new Object[]{list, calendarBean});
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
        if (AndroidInstantRuntime.support(ipChange, "-2122955566")) {
            ipChange.ipc$dispatch("-2122955566", new Object[]{list, hashMap, list2});
            return;
        }
        for (FilterBean filterBean : list) {
            if (list2.contains(filterBean.option)) {
                if (cb2.f(hashMap)) {
                    filterBean.isSelected = false;
                } else {
                    List<FilterBean> list3 = hashMap.get(filterBean.option);
                    if (cb2.d(list3)) {
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
        if (AndroidInstantRuntime.support(ipChange, "1171452305")) {
            ipChange.ipc$dispatch("1171452305", new Object[]{list, filterBean});
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

    public static int e(int i, RecyclerView recyclerView) {
        RecyclerView.Adapter adapter;
        int itemCount;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1192398368")) {
            return ((Integer) ipChange.ipc$dispatch("1192398368", new Object[]{Integer.valueOf(i), recyclerView})).intValue();
        }
        if (recyclerView == null || recyclerView.getAdapter() == null || (itemCount = (adapter = recyclerView.getAdapter()).getItemCount()) <= 0) {
            return -1;
        }
        for (int i2 = 0; i2 < itemCount; i2++) {
            if (adapter.getItemViewType(i2) == i) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean f(int i, RecyclerView recyclerView, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925954779")) {
            return ((Boolean) ipChange.ipc$dispatch("1925954779", new Object[]{Integer.valueOf(i), recyclerView, Integer.valueOf(i2)})).booleanValue();
        }
        try {
            int e = e(i, recyclerView);
            if (e < 0) {
                return false;
            }
            View view = null;
            int i3 = 0;
            while (true) {
                View childAt = recyclerView.getChildAt(i3);
                if (childAt == null) {
                    break;
                } else if (childAt.getMeasuredHeight() > 0) {
                    view = childAt;
                    break;
                } else {
                    i3++;
                }
            }
            if (view == null) {
                return false;
            }
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            if (i2 <= 0) {
                return e == childAdapterPosition;
            } else if (e == childAdapterPosition) {
                return view.getTop() <= (-i2);
            } else {
                return false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void g(FilterBean filterBean, HashMap<String, List<FilterBean>> hashMap, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1281963577")) {
            ipChange.ipc$dispatch("-1281963577", new Object[]{filterBean, hashMap, Boolean.valueOf(z)});
            return;
        }
        String str = filterBean.option;
        List<FilterBean> list = hashMap.get(str);
        if (filterBean.isSelected) {
            if (cb2.d(list)) {
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
