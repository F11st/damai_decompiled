package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class qf {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Calendar calendar, Calendar calendar2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-717461333")) {
            ipChange.ipc$dispatch("-717461333", new Object[]{calendar, calendar2});
            return;
        }
        int g = g(calendar);
        int f = f(calendar);
        int b = b(calendar);
        calendar2.clear();
        calendar2.set(g, f, b);
    }

    public static int b(Calendar calendar) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "520569093") ? ((Integer) ipChange.ipc$dispatch("520569093", new Object[]{calendar})).intValue() : calendar.get(5);
    }

    public static int c(Calendar calendar) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1234805018") ? ((Integer) ipChange.ipc$dispatch("1234805018", new Object[]{calendar})).intValue() : calendar.get(7);
    }

    @NonNull
    public static Calendar d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-32486833")) {
            return (Calendar) ipChange.ipc$dispatch("-32486833", new Object[0]);
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        a(calendar, calendar);
        return calendar;
    }

    public static Calendar e(@Nullable Date date) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-319205170")) {
            return (Calendar) ipChange.ipc$dispatch("-319205170", new Object[]{date});
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        if (date != null) {
            calendar.setTime(date);
        }
        a(calendar, calendar);
        return calendar;
    }

    public static int f(Calendar calendar) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1848059809") ? ((Integer) ipChange.ipc$dispatch("1848059809", new Object[]{calendar})).intValue() : calendar.get(2);
    }

    public static int g(Calendar calendar) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1112973172") ? ((Integer) ipChange.ipc$dispatch("1112973172", new Object[]{calendar})).intValue() : calendar.get(1);
    }
}
