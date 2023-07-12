package tb;

import cn.damai.uikit.calendar.CalendarDay;
import cn.damai.uikit.calendar.format.TitleFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class u30 implements TitleFormatter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final DateFormat a = new SimpleDateFormat("LLLL yyyy", Locale.getDefault());

    @Override // cn.damai.uikit.calendar.format.TitleFormatter
    public CharSequence format(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "265589562") ? (CharSequence) ipChange.ipc$dispatch("265589562", new Object[]{this, calendarDay}) : this.a.format(calendarDay.getDate());
    }
}
