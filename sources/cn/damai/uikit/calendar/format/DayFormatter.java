package cn.damai.uikit.calendar.format;

import androidx.annotation.NonNull;
import cn.damai.uikit.calendar.CalendarDay;
import tb.t30;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public interface DayFormatter {
    public static final DayFormatter DEFAULT = new t30();

    @NonNull
    String format(@NonNull CalendarDay calendarDay);
}
