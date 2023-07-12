package tb;

import cn.damai.uikit.calendar.format.WeekDayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class sf implements WeekDayFormatter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final Calendar a;

    public sf(Calendar calendar) {
        calendar.get(7);
        this.a = calendar;
    }

    @Override // cn.damai.uikit.calendar.format.WeekDayFormatter
    public CharSequence format(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "19458796")) {
            return (CharSequence) ipChange.ipc$dispatch("19458796", new Object[]{this, Integer.valueOf(i)});
        }
        this.a.set(7, i);
        return this.a.getDisplayName(7, 1, Locale.getDefault());
    }
}
