package tb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import cn.damai.uikit.view.DMThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class qv1 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ long a;

        a(long j) {
            this.a = j;
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "752078329")) {
                ipChange.ipc$dispatch("752078329", new Object[]{this});
            }
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1719211297")) {
                ipChange.ipc$dispatch("1719211297", new Object[]{this});
            } else {
                cn.damai.common.user.c.e().x(pp2.u().p(this.a));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ long b;
        final /* synthetic */ CalendarsResolver.RemindMeListener c;
        final /* synthetic */ Activity d;

        b(String str, long j, CalendarsResolver.RemindMeListener remindMeListener, Activity activity) {
            this.a = str;
            this.b = j;
            this.c = remindMeListener;
            this.d = activity;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1555703761")) {
                ipChange.ipc$dispatch("-1555703761", new Object[]{this});
            } else if (TextUtils.isEmpty(this.a) || this.b <= 0) {
            } else {
                CalendarsResolver.i().k(this.c);
                CalendarsResolver.i().l(10).b(this.d, this.a, "", this.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class c implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ long b;
        final /* synthetic */ CalendarsResolver.RemindMeListener c;
        final /* synthetic */ Activity d;

        c(String str, long j, CalendarsResolver.RemindMeListener remindMeListener, Activity activity) {
            this.a = str;
            this.b = j;
            this.c = remindMeListener;
            this.d = activity;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2066237938")) {
                ipChange.ipc$dispatch("-2066237938", new Object[]{this});
            } else if (TextUtils.isEmpty(this.a) || this.b <= 0) {
            } else {
                CalendarsResolver.i().k(this.c);
                CalendarsResolver.i().l(10).h(this.d, this.a, this.b);
            }
        }
    }

    public static void a(Activity activity, String str, long j, CalendarsResolver.RemindMeListener remindMeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1445953190")) {
            ipChange.ipc$dispatch("1445953190", new Object[]{activity, str, Long.valueOf(j), remindMeListener});
        } else if (activity == null) {
        } else {
            ir1.b(activity, false, mr1.CALENDAR, "用于帮助您设置开售提醒", new b(str, j, remindMeListener, activity));
        }
    }

    public static void b(Activity activity, String str, long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1693591969")) {
            ipChange.ipc$dispatch("1693591969", new Object[]{activity, str, Long.valueOf(j), Long.valueOf(j2)});
        } else if (activity != null && ir1.i(mr1.CALENDAR) && d(activity, str, j)) {
            c(activity, str, j, new a(j2));
        }
    }

    public static void c(Activity activity, String str, long j, CalendarsResolver.RemindMeListener remindMeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1922381817")) {
            ipChange.ipc$dispatch("-1922381817", new Object[]{activity, str, Long.valueOf(j), remindMeListener});
        } else if (activity == null) {
        } else {
            ir1.b(activity, false, mr1.CALENDAR, "用于帮助您取消开售提醒", new c(str, j, remindMeListener, activity));
        }
    }

    public static boolean d(Context context, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12067422")) {
            return ((Boolean) ipChange.ipc$dispatch("12067422", new Object[]{context, str, Long.valueOf(j)})).booleanValue();
        }
        if (context == null || TextUtils.isEmpty(str) || j <= 0) {
            return false;
        }
        return CalendarsResolver.i().j(context, str, j);
    }

    public static void e(Activity activity, String str, long j, CalendarsResolver.RemindMeListener remindMeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1015888908")) {
            ipChange.ipc$dispatch("-1015888908", new Object[]{activity, str, Long.valueOf(j), remindMeListener});
        } else if (activity == null) {
        } else {
            if (ir1.i(mr1.CALENDAR)) {
                if (!d(activity, str, j)) {
                    a(activity, str, j, remindMeListener);
                    return;
                } else {
                    c(activity, str, j, remindMeListener);
                    return;
                }
            }
            a(activity, str, j, remindMeListener);
        }
    }

    public static void f(Activity activity, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "662066703")) {
            ipChange.ipc$dispatch("662066703", new Object[]{activity, str, str2});
        } else if (activity == null) {
        } else {
            new DMThemeDialog(activity).r(DMThemeDialog.DMDialogTheme.THEME_SUPPORT_WANNA).o(str).f(true).k(str2).i("知道了", null).show();
        }
    }
}
