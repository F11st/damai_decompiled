package tb;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class kf {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TIME_INTERVAL_ADD_CALENDAR = 10;

    public static void a(Context context, String str, long j, CalendarsResolver.RemindMeListener remindMeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1160208799")) {
            ipChange.ipc$dispatch("-1160208799", new Object[]{context, str, Long.valueOf(j), remindMeListener});
        } else if (context == null || TextUtils.isEmpty(str) || j <= 0) {
        } else {
            CalendarsResolver.i().k(remindMeListener);
            CalendarsResolver.i().l(10).b(context, str, "", j);
        }
    }

    public static boolean b(Context context, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076508137")) {
            return ((Boolean) ipChange.ipc$dispatch("-2076508137", new Object[]{context, str, Long.valueOf(j)})).booleanValue();
        }
        if (context == null || TextUtils.isEmpty(str) || j <= 0) {
            return false;
        }
        return CalendarsResolver.i().j(context, str, j);
    }
}
