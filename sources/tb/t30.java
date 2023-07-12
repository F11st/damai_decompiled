package tb;

import androidx.annotation.NonNull;
import cn.damai.uikit.calendar.CalendarDay;
import cn.damai.uikit.calendar.format.DayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class t30 implements DayFormatter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final DateFormat a = new SimpleDateFormat("d", Locale.getDefault());

    @Override // cn.damai.uikit.calendar.format.DayFormatter
    @NonNull
    public String format(@NonNull CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "86130268") ? (String) ipChange.ipc$dispatch("86130268", new Object[]{this, calendarDay}) : this.a.format(calendarDay.getDate());
    }
}
