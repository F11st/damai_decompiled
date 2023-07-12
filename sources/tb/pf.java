package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.DateBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.HolidayBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.widget.DayEntity;
import cn.damai.commonbusiness.seatbiz.sku.qilin.widget.MonthEntity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class pf {
    private static transient /* synthetic */ IpChange $ipChange;
    public static String[] a = {"日", "一", "二", "三", "四", "五", "六"};

    public static Calendar a(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "51658761")) {
            return (Calendar) ipChange.ipc$dispatch("51658761", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(i, i2 - 1, i3);
        calendar.add(5, i4);
        return calendar;
    }

    public static List<MonthEntity> b(List<DateBean> list, List<HolidayBean> list2, boolean z, String str, boolean z2) {
        ArrayList arrayList;
        int i;
        String str2;
        ArrayList arrayList2;
        int i2;
        int i3;
        String str3;
        List<DateBean> list3 = list;
        List<HolidayBean> list4 = list2;
        IpChange ipChange = $ipChange;
        int i4 = 4;
        int i5 = 0;
        boolean z3 = true;
        if (AndroidInstantRuntime.support(ipChange, "1479903671")) {
            return (List) ipChange.ipc$dispatch("1479903671", new Object[]{list3, list4, Boolean.valueOf(z), str, Boolean.valueOf(z2)});
        }
        ArrayList arrayList3 = null;
        if (wh2.e(list) == 0) {
            return null;
        }
        ArrayList arrayList4 = new ArrayList();
        MonthEntity monthEntity = null;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < list.size()) {
            DateBean dateBean = list3.get(i6);
            if (dateBean != null && (str2 = dateBean.dateId) != null && str2.length() == 8) {
                int intValue = Integer.valueOf(dateBean.dateId.substring(i5, i4)).intValue();
                int intValue2 = Integer.valueOf(dateBean.dateId.substring(i4, 6)).intValue();
                int intValue3 = Integer.valueOf(dateBean.dateId.substring(6, 8)).intValue();
                if (i7 == intValue && i8 == intValue2) {
                    for (int i9 = 1; i9 <= arrayList3.size(); i9++) {
                        DayEntity dayEntity = arrayList3.get(i9 - 1);
                        if (intValue3 == i9) {
                            dayEntity.dateId = dateBean.dateId;
                            dayEntity.hasPerform = z3;
                            if (dateBean.buyPermission) {
                                dayEntity.hasPermission = z3;
                            }
                            if (dateBean.validTag()) {
                                dayEntity.otherTag = dateBean.otherTag;
                                dayEntity.promotionTag = dateBean.promotionTag;
                            }
                        }
                        if (dateBean.checked && intValue3 == i9 && z && !TextUtils.isEmpty(str) && dateBean.dateId.equals(str)) {
                            dayEntity.isSelected = z3;
                        }
                    }
                    if (dateBean.checked && z && !TextUtils.isEmpty(str) && dateBean.dateId.equals(str)) {
                        monthEntity.isSelected = z3;
                    }
                    monthEntity.days = arrayList3;
                } else {
                    MonthEntity monthEntity2 = new MonthEntity();
                    arrayList4.add(monthEntity2);
                    monthEntity2.year = intValue;
                    monthEntity2.month = intValue2;
                    if (dateBean.checked && z && !TextUtils.isEmpty(str) && dateBean.dateId.equals(str)) {
                        monthEntity2.isSelected = z3;
                    }
                    int c = c(intValue, intValue2, intValue3);
                    ArrayList arrayList5 = new ArrayList();
                    int i10 = 1;
                    while (i10 <= c) {
                        DayEntity dayEntity2 = new DayEntity();
                        dayEntity2.isSeePage = z2;
                        dayEntity2.year = intValue;
                        dayEntity2.month = intValue2;
                        dayEntity2.day = i10;
                        if (intValue3 == i10) {
                            dayEntity2.dateId = dateBean.dateId;
                            dayEntity2.hasPerform = z3;
                            if (dateBean.buyPermission) {
                                dayEntity2.hasPermission = z3;
                            }
                            if (dateBean.validTag()) {
                                dayEntity2.otherTag = dateBean.otherTag;
                                dayEntity2.promotionTag = dateBean.promotionTag;
                            }
                        }
                        if (wh2.e(list2) > 0) {
                            int i11 = 0;
                            while (i11 < list2.size()) {
                                HolidayBean holidayBean = list4.get(i11);
                                if (holidayBean == null || (str3 = holidayBean.dateStr) == null) {
                                    arrayList2 = arrayList4;
                                    i2 = c;
                                } else {
                                    i2 = c;
                                    if (str3.length() != 8) {
                                        arrayList2 = arrayList4;
                                    } else {
                                        int intValue4 = Integer.valueOf(holidayBean.dateStr.substring(0, 4)).intValue();
                                        arrayList2 = arrayList4;
                                        int intValue5 = Integer.valueOf(holidayBean.dateStr.substring(4, 6)).intValue();
                                        i3 = i6;
                                        int intValue6 = Integer.valueOf(holidayBean.dateStr.substring(6, 8)).intValue();
                                        if (intValue == intValue4 && intValue2 == intValue5 && i10 == intValue6) {
                                            dayEntity2.bottomTag = holidayBean.desc;
                                        }
                                        i11++;
                                        list4 = list2;
                                        arrayList4 = arrayList2;
                                        c = i2;
                                        i6 = i3;
                                    }
                                }
                                i3 = i6;
                                i11++;
                                list4 = list2;
                                arrayList4 = arrayList2;
                                c = i2;
                                i6 = i3;
                            }
                        }
                        ArrayList arrayList6 = arrayList4;
                        int i12 = c;
                        int i13 = i6;
                        arrayList5.add(dayEntity2);
                        if (dateBean.checked && intValue3 == i10 && z && !TextUtils.isEmpty(str) && dateBean.dateId.equals(str)) {
                            dayEntity2.isSelected = true;
                        }
                        i10++;
                        list4 = list2;
                        arrayList4 = arrayList6;
                        c = i12;
                        i6 = i13;
                        z3 = true;
                    }
                    arrayList = arrayList4;
                    i = i6;
                    monthEntity2.days = arrayList5;
                    monthEntity = monthEntity2;
                    arrayList3 = arrayList5;
                    i7 = intValue;
                    i8 = intValue2;
                    i6 = i + 1;
                    list3 = list;
                    list4 = list2;
                    arrayList4 = arrayList;
                    i4 = 4;
                    i5 = 0;
                    z3 = true;
                }
            }
            arrayList = arrayList4;
            i = i6;
            monthEntity = monthEntity;
            i6 = i + 1;
            list3 = list;
            list4 = list2;
            arrayList4 = arrayList;
            i4 = 4;
            i5 = 0;
            z3 = true;
        }
        return arrayList4;
    }

    public static int c(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "630008836")) {
            return ((Integer) ipChange.ipc$dispatch("630008836", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).intValue();
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(i, i2 - 1, i3);
        return calendar.getActualMaximum(5);
    }

    public static String d(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1218578171") ? (String) ipChange.ipc$dispatch("1218578171", new Object[]{Integer.valueOf(i)}) : a[(i % 10) - 1];
    }

    public static String e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1490723477")) {
            return (String) ipChange.ipc$dispatch("-1490723477", new Object[]{Integer.valueOf(i)});
        }
        if (i >= 10) {
            return i + "";
        }
        return "0" + i;
    }

    public static int f(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1856603590")) {
            return ((Integer) ipChange.ipc$dispatch("1856603590", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(i, i2 - 1, 1);
        return calendar.get(7);
    }

    public static List<DayEntity> g(List<DateBean> list, boolean z, String str, boolean z2) {
        int i;
        int i2;
        int i3;
        String str2;
        String str3;
        List<DateBean> list2 = list;
        IpChange ipChange = $ipChange;
        int i4 = 2;
        int i5 = 4;
        int i6 = 1;
        if (AndroidInstantRuntime.support(ipChange, "287627566")) {
            return (List) ipChange.ipc$dispatch("287627566", new Object[]{list2, Boolean.valueOf(z), str, Boolean.valueOf(z2)});
        }
        DateBean dateBean = null;
        if (m91.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (true) {
            i = 8;
            if (i7 >= list.size()) {
                break;
            }
            DateBean dateBean2 = list2.get(i7);
            if (dateBean2 != null && (str3 = dateBean2.dateId) != null && str3.length() == 8 && z && dateBean2.checked && !TextUtils.isEmpty(str) && dateBean2.dateId.equals(str)) {
                dateBean = dateBean2;
            }
            i7++;
        }
        if (dateBean == null) {
            dateBean = list2.get(0);
        }
        int intValue = Integer.valueOf(dateBean.dateId.substring(0, 4)).intValue();
        int intValue2 = Integer.valueOf(dateBean.dateId.substring(4, 6)).intValue();
        int intValue3 = Integer.valueOf(dateBean.dateId.substring(6, 8)).intValue();
        int i8 = -3;
        while (i8 < i5) {
            DayEntity dayEntity = new DayEntity();
            dayEntity.isSeePage = z2;
            Calendar a2 = a(intValue, intValue2, intValue3, i8);
            int i9 = a2.get(i6);
            int i10 = a2.get(i4) + 1;
            int i11 = a2.get(5);
            int i12 = a2.get(7);
            dayEntity.monthAndDay = e(i10) + "." + e(i11);
            dayEntity.week = d(i12);
            dayEntity.year = i9;
            dayEntity.month = i10;
            dayEntity.day = i11;
            int i13 = 0;
            while (i13 < list.size()) {
                DateBean dateBean3 = list2.get(i13);
                if (dateBean3 == null || (str2 = dateBean3.dateId) == null || str2.length() != i) {
                    i2 = intValue3;
                    i3 = intValue;
                } else {
                    int intValue4 = Integer.valueOf(dateBean3.dateId.substring(0, 4)).intValue();
                    i2 = intValue3;
                    int intValue5 = Integer.valueOf(dateBean3.dateId.substring(4, 6)).intValue();
                    i3 = intValue;
                    int intValue6 = Integer.valueOf(dateBean3.dateId.substring(6, 8)).intValue();
                    if (i9 == intValue4 && i10 == intValue5 && i11 == intValue6) {
                        dayEntity.hasPerform = true;
                        dayEntity.hasPermission = dateBean3.buyPermission;
                        dayEntity.dateId = dateBean3.dateId;
                        dayEntity.index = i13;
                        if (dateBean3.validTag()) {
                            dayEntity.otherTag = dateBean3.otherTag;
                            dayEntity.promotionTag = dateBean3.promotionTag;
                        }
                        if (z && !TextUtils.isEmpty(str) && dateBean3.dateId.equals(str)) {
                            dayEntity.isSelected = dateBean3.checked;
                        }
                    }
                }
                i13++;
                list2 = list;
                intValue3 = i2;
                intValue = i3;
                i = 8;
            }
            arrayList.add(dayEntity);
            i8++;
            i4 = 2;
            list2 = list;
            intValue3 = intValue3;
            intValue = intValue;
            i5 = 4;
            i6 = 1;
            i = 8;
        }
        return arrayList;
    }
}
